import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class InformationProcessing {
    public static void saveFile(List<Task> taskList, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Task task : taskList) { // Проходимся по TaskList'у и сохраняем построчно все в txt файл
                fileWriter.write(task.saveFormat() + "\n"); //записываем строчку + делаем отступ
            }
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных " + e.getMessage());
        }
    }

    public static List<Task> loadFile(String fileName) throws IOException {
        List<Task> taskList = new ArrayList<>(); // создаем ArrayList, который мы и вернем
        int maxID = Integer.MIN_VALUE; // это для maxID, чтобы потом создавать новые Task'и с правильным ID

        File file = new File(fileName); // создаем новый файл, чтобы проверить его на существование и не совать сразу в Scanner
        // ибо иначе Scanner сразу выдаст Exception

        if (!file.exists()) { // если такого файла нет, то мы создаем новый пустой файл
            System.out.println("File not found. Creating new file");
            file.createNewFile();
            Task.setCount(0);
            return taskList;
        }

        try {
            Scanner scanner = new Scanner(new File(fileName));
            if (new File(fileName).length() == 0 || new File(fileName).length() == 1) {
                System.out.println("File is empty");
                return taskList; // если файл есть, но он пустой, то мы говорим об этом и возвращаем
            }

            while (scanner.hasNextLine()) { // если же файл не пустой, то мы построчно делаем split по "?"
                String line = scanner.nextLine(); // и создаем Task'и, которые потом суём в созданный ранее ArrayList
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
        Task.setCount(maxID); // ставим новый ID если дошли до этого момента

        return taskList;
    }
}
