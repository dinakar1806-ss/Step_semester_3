
import java.util.Scanner;

public class LibraryReturnDesk {

    static String[] stack = new String[3];
    static int top = -1;

    static String[] queue = new String[3];
    static int front = 0;
    static int rear = -1;
    static int size = 0;

    static void returnBook(String book) {
        if (top == 2) {
            System.out.println(book + " rejected: pile is full");
        } else {
            stack[++top] = book;
            System.out.println(book + " placed on pile");
        }
    }

    static void shelveBook() {
        if (top == -1) {
            System.out.println("pile is empty");
        } else {
            System.out.println("shelved " + stack[top]);
            stack[top] = null;
            top--;
        }
    }

    static void waitStudent(String name) {
        if (size == 3) {
            System.out.println(name + " rejected: line is full");
        } else {
            rear = (rear + 1) % 3;
            queue[rear] = name;
            size++;
            System.out.println(name + " joined the line");
        }
    }

    static void serveStudent() {
        if (size == 0) {
            System.out.println("no one waiting");
        } else {
            System.out.println("served " + queue[front]);
            queue[front] = null;
            front = (front + 1) % 3;
            size--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Commands can be separated by commas or spaces.
        sc.useDelimiter("[,\\s]+");

        while (sc.hasNext()) {
            String command = sc.next();

            switch (command.toUpperCase()) {

                case "RETURN":
                    if (sc.hasNext()) {
                        returnBook(sc.next());
                    }
                    break;

                case "SHELVE":
                    shelveBook();
                    break;

                case "WAIT":
                    if (sc.hasNext()) {
                        waitStudent(sc.next());
                    }
                    break;

                case "SERVE":
                    serveStudent();
                    break;

                default:
                    System.out.println("Invalid command");
            }
        }

        sc.close();
    }
}
