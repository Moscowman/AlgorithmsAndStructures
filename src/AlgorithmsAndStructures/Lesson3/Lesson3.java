package AlgorithmsAndStructures.Lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Lesson3 {

    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue queue = new PriorityQueue();
        final int NO_OF_ELEMENTS = 10;


        for (int i = 0; i < NO_OF_ELEMENTS; i++) {
            stack.push(i);
            queue.add(i);
        }

        System.out.println("Стек:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("Очередь:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        reverseInput();

        Deque deque = new DequeImpl(10);
        deque.insertLeft(1);
        deque.insertRight(2);
        deque.insertLeft(3);
        deque.insertRight(4);
        deque.insertLeft(5);
        deque.insertRight(6);
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeRight());
        System.out.println(deque.removeRight());
        System.out.println(deque.removeRight());

    }

    private static void reverseInput () {
        System.out.println("Введите строку текста");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stack stack = new Stack();
        for (int i = 0; i < line.length(); i++) {
            stack.push(line.charAt(i));
        }
        System.out.println("Перевёрнутая строка");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();

    }
}
