import java.util.*;

public class WaitingListManager {
    private Queue<String> waitingList;
    private Set<String> uniqueNames;

    public WaitingListManager() {
        waitingList = new LinkedList<>();
        uniqueNames = new HashSet<>();
    }

    public void addPerson(String name) {
        if (uniqueNames.contains(name)) {
            System.out.println(name + " is already on the list.");
        } else {
            waitingList.add(name);
            uniqueNames.add(name);
            System.out.println(name + " has been added to the list.");
        }
    }

    public String servePerson() {
        if (waitingList.isEmpty()) {
            return "The list is empty.";
        } else {
            String name = waitingList.poll();
            uniqueNames.remove(name);
            return name + " has been served.";
        }
    }

    public boolean isPersonInList(String name) {
        return uniqueNames.contains(name);
    }

    public int waitingListSize() {
        return waitingList.size();
    }

    public void displayWaitingList() {
        if (waitingList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Waiting list: ");
            for (String name : waitingList) {
                System.out.println(name);
            }
        }
    }

    public static void main(String[] args) {
        WaitingListManager manager = new WaitingListManager();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add person to the list");
            System.out.println("2. Serve person");
            System.out.println("3. Check if person is on the list");
            System.out.println("4. Display list size");
            System.out.println("5. Display list");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Please enter your name: ");
                    String nameToAdd = scanner.nextLine();
                    manager.addPerson(nameToAdd);
                    break;
                case "2":
                    System.out.println(manager.servePerson());
                    break;
                case "3":
                    System.out.print("Please enter your name: ");
                    String nameToCheck = scanner.nextLine();
                    if (manager.isPersonInList(nameToCheck)) {
                        System.out.println(nameToCheck + " is on the list.");
                    } else {
                        System.out.println(nameToCheck + " is not on the list.");
                    }
                    break;
                case "4":
                    System.out.println("Waiting list size: " + manager.waitingListSize());
                    break;
                case "5":
                    manager.displayWaitingList();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Sorry, invalid choice. Please try again.");
            }
        }
    }
}
