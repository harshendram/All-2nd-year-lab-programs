package Generic8;

import java.util.*;

public class Stack<T> {
    private int tos;
    public ArrayList<T> stackArray;
    public int maxsize;

    public Stack(int size) {
        this.maxsize = size;
        tos = -1;
        stackArray = new ArrayList<>(size);
    }

    public void push(T item) {
        if (tos == maxsize - 1) {
            System.out.println("Stack Overflow. Cannot push " + item);
            return;
        }
        stackArray.add(++tos, item);
    }

    public boolean isEmpty() {
        return tos == -1;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return null;
        }
        return stackArray.remove(tos--);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Stack Elements:");
            for (int i = tos; i >= 0; i--) {
                System.out.println(stackArray.get(i));
            }
        }
    }

    public void clear() {
        tos = -1;
        System.out.println("Stack Cleared");
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Select Stack Type: ");
        System.out.println("1. String Stack");
        System.out.println("2. Float Stack");
        int type = sc.nextInt();

        System.out.print("Enter Stack size: ");
        int size = sc.nextInt();

        if (type == 1) {
            Stack<String> stringStack = new Stack<>(size);

            while (true) {
                System.out.println("\n1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Display");
                System.out.println("4. Clear");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter String to push: ");
                        String str = sc.nextLine();
                        stringStack.push(str);
                        break;
                    case 2:
                        String poppedStr = stringStack.pop();
                        if (poppedStr != null) {
                            System.out.println("Popped: " + poppedStr);
                        }
                        break;
                    case 3:
                        stringStack.display();
                        break;
                    case 4:
                        stringStack.clear();
                        System.out.println("Stack cleared.");
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

        else if (type == 2) {
            Stack<Float> floatStack = new Stack<>(size);

            while (true) {
                System.out.println("\n1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Display");
                System.out.println("4. Clear");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Float to push: ");
                        float num = sc.nextFloat();
                        floatStack.push(num);
                        break;
                    case 2:
                        Float poppedFloat = floatStack.pop();
                        if (poppedFloat != null) {
                            System.out.println("Popped: " + poppedFloat);
                        }
                        break;
                    case 3:
                        floatStack.display();
                        break;
                    case 4:
                        floatStack.clear();
                        System.out.println("Stack cleared.");
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

        else {
            System.out.println("Invalid stack type selected.");
        }
    }
}