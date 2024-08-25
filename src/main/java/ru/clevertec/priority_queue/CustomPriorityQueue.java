package ru.clevertec.priority_queue;

import java.util.Arrays;
import java.util.Comparator;

public class CustomPriorityQueue<T>  implements ICustomPriorityQueue<T>{

    private Object[] heap;
    private int size;
    private final Comparator<? super T> comparator;

    public CustomPriorityQueue() {
        this(null);
    }

    public CustomPriorityQueue(Comparator<? super T> comparator) {
        this.heap = new Object[8];
        this.size = 0;
        this.comparator = comparator;
    }

    @Override
    public void add(T element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }

        if (comparator == null && !(element instanceof Comparable)) {
            throw new ClassCastException("Element must implement Comparable if no comparator is provided");
        }

        if (size == heap.length) {
            grow();
        }

        heap[size] = element;
        siftUp(size);
        size++;
    }

    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return (T) heap[0];
    }

    @Override
    public T poll() {
        if (size == 0) {
            return null;
        }
        T result = (T) heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        siftDown(0);
        return result;
    }

    private void siftUp(int index) {
        T element = (T) heap[index];

        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T parent = (T) heap[parentIndex];

            if (compare(element, (T) heap[parentIndex]) >= 0) {
                break;
            }

            heap[index] = parent;
            index = parentIndex;
        }

        heap[index] = element;
    }


    private void siftDown(int index) {
        int leftChild, rightChild, smallest;
        T element = (T) heap[index];

        while (true) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            smallest = index;

            if (leftChild < size && compare((T) heap[leftChild], (T) heap[smallest]) < 0) {
                smallest = leftChild;
            }

            if (rightChild < size && compare((T) heap[rightChild], (T) heap[smallest]) < 0) {
                smallest = rightChild;
            }

            if (smallest == index) {
                break;
            }

            heap[index] = heap[smallest];
            heap[smallest] = element;
            index = smallest;
        }

        heap[index] = element;
    }


    private int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            return ((Comparable<? super T>) a).compareTo(b);
        }
    }


    private void grow() {
        int newCapacity = heap.length * 2;
        heap = Arrays.copyOf(heap, newCapacity);
    }
}
