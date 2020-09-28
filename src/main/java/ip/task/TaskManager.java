package ip.task;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();

    /**
     * @return Total number of tasks in the task ArrayList
     */
    public static int getTasksCount() {
        return tasks.size();
    }

    /**
     * Takes in a Task parameter to add it to the ArrayList
     *
     * @param task
     * @return task
     */
    private static Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    /**
     * Takes in an integer representing the ID of a task
     * Removes task from the ArrayList and returns the deleted task parameter
     *
     * @param id task ID
     * @return task
     */
    public static Task deleteTask(int id) {
        Task task = tasks.get(id-1);
        tasks.remove(id-1);
        return task;
    }

    /**
     * Prints out all the tasks currently in the ArrayList
     */
    public static void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(" " + (i+1) + "." + tasks.get(i).toString() );
        }
    }

    /**
     * Takes in an integer representing the ID of a task
     * Marks task as completed and returns the deleted task parameter
     *
     * @param id task ID
     * @return task
     */
    public static Task markAsDone(int id) {
        Task task = tasks.get(id - 1);
        task.markAsDone();
        return task;
    }

    /**
     * Takes in a description of the task
     * Pass task as a new todo task and adds it to the ArrayList
     *
     * @param description Task Description
     * @return task converted to a Todo Class
     */
    public static Todo addTodo(String description) {
        Todo todo = new Todo(description);
        return (Todo) addTask(todo);
    }

    /**
     * Takes in a description and end time of the task
     * Pass task as a new deadline task and adds it to the ArrayList
     *
     * @param description Task Description
     * @param duration Deadline of Task
     * @return task converted to a Deadline Class
     */
    public static Deadline addDeadline(String description, String duration) {
        Deadline deadline = new Deadline(description, duration);
        return (Deadline) addTask(deadline);
    }

    /**
     * Takes in a description and start time of the task
     * Pass task as a new event task and adds it to the ArrayList
     *
     * @param description Task Description
     * @param duration Start Time of Task
     * @return task converted to an Event Class
     */
    public static Event addEvent(String description, String duration) {
        Event event = new Event(description, duration);
        return (Event) addTask(event);
    }

    /**
     * Filters task by keyword inputted by user
     * Returns an array list of the resulting filtered task
     *
     * @param keyword Keyword inputted by user to narrow search
     * @return Filtered task by keyword
     */
    public static ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> filteredTask = (ArrayList<Task>) tasks.stream()
                .filter((s) -> s.description.toUpperCase().contains(keyword))
                .collect(Collectors.toList());

        return filteredTask;
    }
}
