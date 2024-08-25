package ru.clevertec.priority_queue;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class CustomPriorityQueueTest {

    @Test
    public void testAddAndPeek() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(5);
        assertEquals(5, pq.peek());
    }

    @Test
    public void testPoll() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(5);
        assertEquals(5, pq.poll());
        assertEquals(10, pq.poll());
        assertEquals(20, pq.poll());
        assertNull(pq.poll());
    }

    @Test
    public void testAddNullThrowsException() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        assertThrows(NullPointerException.class, () -> pq.add(null));
    }

    @Test
    public void testPeekEmptyQueue() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        assertNull(pq.peek());
    }

    @Test
    public void testPollEmptyQueue() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        assertNull(pq.poll());
    }

    @Test
    public void testCustomComparator() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>(Comparator.reverseOrder());
        pq.add(10);
        pq.add(20);
        pq.add(5);
        assertEquals(20, pq.peek());
        assertEquals(20, pq.poll());
        assertEquals(10, pq.poll());
        assertEquals(5, pq.poll());
        assertNull(pq.poll());
    }

    @Test
    public void testGrowArray() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        for (int i = 0; i < 100; i++) {
            pq.add(i);
        }
        assertEquals(0, pq.peek());
        for (int i = 0; i < 100; i++) {
            assertEquals(i, pq.poll());
        }
        assertNull(pq.poll());
    }

    @Test
    public void testAddDuplicateElements() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(10);
        pq.add(10);
        pq.add(10);
        assertEquals(10, pq.poll());
        assertEquals(10, pq.poll());
        assertEquals(10, pq.poll());
        assertNull(pq.poll());
    }

    @Test
    public void testAddNegativeElements() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(-1);
        pq.add(-10);
        pq.add(-5);
        assertEquals(-10, pq.poll());
        assertEquals(-5, pq.poll());
        assertEquals(-1, pq.poll());
    }

    @Test
    public void testMixedElements() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(0);
        pq.add(-10);
        pq.add(10);
        pq.add(5);
        pq.add(-5);
        assertEquals(-10, pq.poll());
        assertEquals(-5, pq.poll());
        assertEquals(0, pq.poll());
        assertEquals(5, pq.poll());
        assertEquals(10, pq.poll());
    }

    @Test
    public void testAddAndPeekString() {
        CustomPriorityQueue<String> pq = new CustomPriorityQueue<>();
        pq.add("apple");
        pq.add("banana");
        pq.add("pear");
        assertEquals("apple", pq.peek());
    }

    @Test
    public void testPollString() {
        CustomPriorityQueue<String> pq = new CustomPriorityQueue<>();
        pq.add("apple");
        pq.add("banana");
        pq.add("pear");
        assertEquals("apple", pq.poll());
        assertEquals("banana", pq.poll());
        assertEquals("pear", pq.poll());
        assertNull(pq.poll());
    }

    @Test
    public void testCustomComparatorString() {
        CustomPriorityQueue<String> pq = new CustomPriorityQueue<>(Comparator.reverseOrder());
        pq.add("apple");
        pq.add("banana");
        pq.add("pear");
        assertEquals("pear", pq.peek());
        assertEquals("pear", pq.poll());
        assertEquals("banana", pq.poll());
        assertEquals("apple", pq.poll());
        assertNull(pq.poll());
    }
}
