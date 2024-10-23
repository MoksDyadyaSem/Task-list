public class Task {
    protected static Integer count = 0;
    protected final Integer id;
    protected final String name;
    protected final String task;

    public Task(String name,String task) {
        this.id = ++count;
        this.name = name;
        this.task = task;
    }
    public Task(int id,String name,String task) {
        this.id = id;
        this.name = name;
        this.task = task;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task [id = " + id + ", name= " + name + ", task = " + task + "]";
    }
    public String saveFormat() {
        return String.format("%d?%s?%s", id, name, task);
    }

    public static void setCount(Integer count) {
        Task.count = count;
    }
}