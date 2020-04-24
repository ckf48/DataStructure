package queue;

import java.util.Random;

public class QueueMain {
    private static double testQueue(Queue<Integer> queue, int opCount) {
        Long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        Long end = System.nanoTime();

        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 10000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> loopQueue = new LoopQueue<>();

        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue: " + time1 + " s");

        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue: " + time2 + " s");
    }
}
