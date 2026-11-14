
import java.util.Scanner;

public class Question4_CancelBooking {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            next = null;
        }
    }

    static Node removeFirst(Node head, String booking) {

        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        if (head.data.equals(booking))
            return head.next;

        Node temp = head;

        while (temp.next != null &&
               !temp.next.data.equals(booking)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println(booking + " not found");
        } else {
            temp.next = temp.next.next;
        }

        return head;
    }

    static void printBookings(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        Node head = null, tail = null;

        System.out.println("Enter booking numbers:");

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.next());

            if (head == null)
                head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter booking number to cancel: ");
        String booking = sc.next();

        head = removeFirst(head, booking);

        System.out.print("Bookings after cancellation: ");
        printBookings(head);

        sc.close();
    }
}
