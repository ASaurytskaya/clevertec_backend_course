package ru.clevertec.priority_queue;

import java.util.Comparator;

public interface ICustomPriorityQueue<T> {
    void add(T t);

    T peek();

    T poll();
}
