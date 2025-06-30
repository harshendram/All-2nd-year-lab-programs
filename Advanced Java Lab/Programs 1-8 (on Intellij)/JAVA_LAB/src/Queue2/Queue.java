package Queue2;

import java.util.*;

class QueueFull extends Exception {
    public QueueFull(String message) {
        super(message);
    }
}

class QueueEmpty extends Exception {
    public QueueEmpty(String message) {
        super(message);
    }
}

public class Queue {
    public int front, rear, size;
    public String[] a;

    Queue(int n) {
        size = n;
        rear = -1;
        front = 0;
        a = new String[n];
    }

    public void enqueue(String item) throws QueueFull {
        if (rear == size - 1)
            throw new QueueFull("Queue is full, cannot enqueue more items");
        a[++rear] = item;
    }

    public String dequeue() throws QueueEmpty {
        if (front > rear)
            throw new QueueEmpty("Queue is empty");
        return a[front++];
    }

    public void display() throws QueueEmpty {
        if (front > rear)
            throw new QueueEmpty("Queue is empty");
        System.out.println("The following are the elements of the Queue:");
        for (int i = front; i <= rear; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, choice;
        System.out.print("Enter the size of the Queue: ");
        n = scan.nextInt();
        scan.nextLine();

        Queue q1 = new Queue(n);

        while (true) {
            System.out.println("\nEnter the operation:");
            System.out.println("1 - Enqueue (Add Name)  2 - Dequeue (Remove Name)  3 - Display  4 - Exit");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter the Name to enqueue: ");
                        String name = scan.nextLine();
                        q1.enqueue(name);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.println(q1.dequeue() + " dequeued from the Queue");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        q1.display();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
            }
        }
    }
}



































//package Queue2;
//
//import java.util.*;
//
//class QueueFull extends Exception {
//    public QueueFull(String message) {
//        super(message);
//    }
//}
//
//class QueueEmpty extends Exception {
//    public QueueEmpty(String message) {
//        super(message);
//    }
//}
//
//public class Queue {
//    public int front, rear, size;
//    public int[] a;
//
//    Queue(int n) {
//        size = n;
//        rear = -1;
//        front = 0;
//        a = new int[n];
//    }
//
//    public void enqueue(int item) throws QueueFull {
//        if (rear == size - 1)
//            throw new QueueFull("Queue is full, cannot enqueue more items");
//        a[++rear] = item;
//    }
//
//    public int dequeue() throws QueueEmpty {
//        if (front > rear)
//            throw new QueueEmpty("Queue is empty");
//        return a[front++];
//    }
//
//    public void display() throws QueueEmpty {
//        if (front > rear)
//            throw new QueueEmpty("Queue is empty");
//        System.out.println("The following are elements of the Queue:");
//        for (int i = front; i <= rear; i++) {
//            System.out.print(a[i] + " ");
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n, choice;
//        System.out.print("Enter the size of the Queue: ");
//        n = scan.nextInt();
//
//        Queue q1 = new Queue(n);
//
//        while (true) {
//            System.out.println("\nEnter the operation:");
//            System.out.println("1 - push  2 - pop  3 - display  4 - Exit");
//            choice = scan.nextInt();
//
//            switch (choice) {
//                case 1:
//                    try {
//                        System.out.print("Enter the value: ");
//                        choice = scan.nextInt();
//                        q1.enqueue(choice);
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//
//                case 2:
//                    try {
//                        System.out.println(q1.dequeue() + " dequeued element");
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//
//                case 3:
//                    try {
//                        q1.display();
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//
//                case 4:
//                    scan.close();
//                    return;
//            }
//        }
//    }
//}
