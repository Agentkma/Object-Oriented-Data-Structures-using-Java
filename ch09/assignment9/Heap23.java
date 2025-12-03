package ch09.assignment9;

import ch09.priorityQueues.*;

public class Heap23 {

    public static void main(String[] args) {
        PriQueueInterface<String> h = new HeapPriQ<String>(10);
        h.enqueue("C");
        h.enqueue("O");
        h.enqueue("M");
        h.enqueue("P");
        h.enqueue("U");
        h.enqueue("T");
        h.enqueue("E");
        h.enqueue("R");
        System.out.println(h);
        System.out.println(h.dequeue() + "\n");
        System.out.println(h);
    }

}
