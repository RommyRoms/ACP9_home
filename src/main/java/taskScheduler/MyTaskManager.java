package taskScheduler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ro on 29.10.2015.
 */
public class MyTaskManager {
    private List<Task> taskList;

    public MyTaskManager() {
        taskList = new LinkedList<>();
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public boolean containTask(Task task){
        return taskList.contains(task);
    }


}
