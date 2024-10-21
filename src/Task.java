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

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task [id = " + id + ", name= " + name + ", task = " + task + "]";
    }
}