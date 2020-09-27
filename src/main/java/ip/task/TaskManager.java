package ip.task;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static int getTasksCount() {
        return tasks.size();
    }

    private static Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public static Task deleteTask(int id) {
        Task task = tasks.get(id-1);
        tasks.remove(id-1);
        return task;
    }

    public static void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(" " + (i+1) + "." + tasks.get(i).toString() );
        }
    }

    public static Task markAsDone(int id) {
        Task task = tasks.get(id - 1);
        task.markAsDone();
        return task;
    }

    public static Todo addTodo(String description) {
        Todo todo = new Todo(description);
        return (Todo) addTask(todo);
    }

    public static Deadline addDeadline(String description, String duration) {
        Deadline deadline = new Deadline(description, duration);
        return (Deadline) addTask(deadline);
    }

    public static Event addEvent(String description, String duration) {
        Event event = new Event(description, duration);
        return (Event) addTask(event);
    }

    public static ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> filteredTask = (ArrayList<Task>) tasks.stream()
                .filter((s) -> s.description.toUpperCase().contains(keyword))
                .collect(Collectors.toList());

        return filteredTask;
    }
}
