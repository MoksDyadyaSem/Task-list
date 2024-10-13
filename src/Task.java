public class Task {
    protected static Integer count = 0;
    protected final Integer id;
    protected final String task;

    public Task(String task) {
        this.id = ++count;
        this.task = task;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " - " + task;
    }
}