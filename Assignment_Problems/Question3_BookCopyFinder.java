
import java.util.Scanner;

public class Question3_BookCopyFinder {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            next = null;
        }
    }

    static String find(Node head, String id) {
        int position = 1;
        int copies = 0;
        int firstPosition = -1;

        Node temp = head;

        while (temp != null) {
            if (temp.data.equals(id)) {
                copies++;

                if (firstPosition == -1)
                    firstPosition = position;
            }

            temp = temp.next;
            position++;
        }

        if (copies == 0)
            return id + " not found";

        return id + " first at position " +
            firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        Node head = null, tail = null;

        System.out.println("Enter book IDs:");

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.next());

            if (head == null)
                head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter book ID to find: ");
        String id = sc.next();

        System.out.println(find(head, id));

        sc.close();
    }
}
