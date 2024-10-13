public class Main {
    public static void main(String[] args) {
        User user = new User();
        TaskManager taskManager = new TaskManager(user);
        taskManager.start();
    }
}
