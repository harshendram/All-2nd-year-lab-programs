package Telephone6;

import java.util.*;
import java.time.LocalTime;

public class Manager {
    @SuppressWarnings("resource")
    public static void main(String[] args) {

        LinkedList<Contact> cl = new LinkedList<>();
        cl.add(new Contact("name1", 9110987654L));
        cl.add(new Contact("name2", 9110837654L));
        cl.add(new Contact("name3", 999987557L));

        ArrayList<MissedCall> mc = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Missed Call");
            System.out.println("2. Iterate Missed Calls (Display/Delete)");
            System.out.println("3. Exit");
            System.out.println("4. Show Contact List");
            System.out.println("5. Show Missed Call List");
            System.out.print("\nEnter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter the number: ");
                    long miss_ca = sc.nextLong();
                    sc.nextLine(); // consume newline
                    String name = "Private Caller";

                    for (Contact c : cl) {
                        if (c.number == miss_ca) {
                            name = c.name;
                            break;
                        }
                    }

                    if (mc.size() >= 5) {
                        MissedCall rem = mc.remove(0);
                        System.out.println("Removed oldest call: " + rem);
                    }

                    mc.add(new MissedCall(LocalTime.now(), name, miss_ca));
                    System.out.println("Missed call added.");
                    break;

                case 2:
                    ArrayList<MissedCall> delCall = new ArrayList<>();
                    for (MissedCall v : mc) {
                        System.out.println(v);
                        System.out.print("Do you want to delete this missed call? (1 = Yes, 0 = No): ");
                        int val = Integer.parseInt(sc.nextLine());
                        if (val == 1) {
                            delCall.add(v);
                        }
                    }
                    mc.removeAll(delCall);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                case 4:
                    System.out.println("\n--- Contact List ---");
                    for (Contact c : cl) {
                        System.out.println(c);
                    }
                    break;

                case 5:
                    System.out.println("\n--- Missed Call List ---");
                    for (MissedCall v : mc) {
                        System.out.println(v);
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}