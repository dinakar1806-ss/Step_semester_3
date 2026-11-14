
import java.util.Scanner;

public class Question2_LateComers {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            next = null;
        }
    }

    static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    static Node addLast(Node head, String name) {
        Node newNode = new Node(name);

        if (head == null)
            return newNode;

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        return head;
    }

    static void printLine(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter starting number of students: ");
        int n = sc.nextInt();

        Node head = null;

        System.out.println("Enter starting student names:");
        for (int i = 0; i < n; i++)
            head = addLast(head, sc.next());

        System.out.print("Enter number of operations: ");
        int operations = sc.nextInt();

        System.out.println("1 = addFirst, 2 = addLast");

        for (int i = 0; i < operations; i++) {
            int choice = sc.nextInt();
            String name = sc.next();

            if (choice == 1)
                head = addFirst(head, name);
            else if (choice == 2)
                head = addLast(head, name);
            else {
                System.out.println("Invalid operation");
                i--;
            }
        }

        System.out.print("Final line: ");
        printLine(head);

        sc.close();
    }
}
