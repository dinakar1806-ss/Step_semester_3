
import java.util.Scanner;

public class Question5_PlateStack {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            next = null;
        }
    }

    static class Stack {
        Node top = null;
        int size = 0;

        void push(String plate) {
            Node newNode = new Node(plate);
            newNode.next = top;
            top = newNode;
            size++;

            System.out.println("push " + plate +
                " -> top " + top.data + ", size " + size);
        }

        void pop() {
            if (isEmpty()) {
                System.out.println("pop -> stack is empty");
                return;
            }

            String removed = top.data;
            top = top.next;
            size--;

            System.out.println("pop -> " + removed +
                ", size " + size);
        }

        void peek() {
            if (isEmpty())
                System.out.println("peek -> stack is empty");
            else
                System.out.println("peek -> " + top.data);
        }

        boolean isEmpty() {
            return top == null;
        }

        void printIsEmpty() {
            System.out.println("isEmpty -> " + isEmpty());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();

        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String operation = sc.next();

            switch (operation.toLowerCase()) {

                case "push":
                    String plate = sc.next();
                    stack.push(plate);
                    break;

                case "pop":
                    stack.pop();
                    break;

                case "peek":
                    stack.peek();
                    break;

                case "isempty":
                    stack.printIsEmpty();
                    break;

                default:
                    System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}
