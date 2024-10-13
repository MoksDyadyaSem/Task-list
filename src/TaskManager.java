import java.util.Scanner;

public class TaskManager {
    private final User user;

    public TaskManager(User user) {
        this.user = user;
    }

    public void start() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            listMenu();
            switch (sc.nextLine()) {
                case "1" -> {
                    System.out.println("Enter task:");
                    this.addTask(new Task(sc.nextLine()));
                    System.out.println("\ntask was successfully added\n");
                }
                case "2" -> {
                    System.out.println("Enter task ID to remove:");
                    this.removeTask(sc.nextInt());
                    sc.nextLine(); // Чтобы "съесть" символ новой строки
                    System.out.println("\ntask was successfully removed\n");
                }
                case "3" -> {
                    System.out.println("\nlist of your tasks");
                    this.printTaskList();
                }
                case "4" -> {
                    System.out.println("\nend of work\n");
                    return;
                }
                default -> System.out.println("\nче ты ввёл\n");
            }
        }
    }

    public void listMenu() {
        System.out.print("""
                enter 1 to add task
                enter 2 to delete task
                enter 3 to list your tasks
                enter 4 to exit
                enter your choice:
                """);
    }

    public void addTask(Task task) {
        this.user.taskList.add(task);
    }

    public void removeTask(int id) {
        for (int i = 0; i < this.user.taskList.size(); i++) {
            if (this.user.taskList.get(i).getId().equals(id)) {
                this.user.taskList.remove(i);
                break;
            }
        }
    }

    public void printTaskList() {
        if (this.user.taskList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : this.user.taskList) {
                System.out.println("---------------------------------");
                System.out.println("ID: " + task.getId());
                System.out.println("Task: " + task);
                System.out.println("---------------------------------");
            }
        }
    }
}