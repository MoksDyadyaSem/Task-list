import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class InformationProcessing {
    public static void saveFile(List<Task> taskList, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Task task : taskList) {
                fileWriter.write(task.saveFormat() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных " + e.getMessage());
        }
    }

    public static List<Task> loadFile(String fileName) throws IOException {
        List<Task> taskList = new ArrayList<>();
        int maxID = Integer.MIN_VALUE;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            if (new File(fileName).length() == 0 || new File(fileName).length() == 1) {
                return new ArrayList<Task>();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] taskInfo = line.split("\\?");
                int id = Integer.parseInt(taskInfo[0]);
                String name = taskInfo[1];
                String description = taskInfo[2];
                taskList.add(new Task(id, name, description));

                if (id > maxID) {
                    maxID = id;
                } else {
                    maxID = 0;
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + e.getMessage());
        }
        Task.setCount(maxID);

        return taskList;
    }
}
