package taskScheduler;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ro on 29.10.2015.
 */
public class Test {
    public static void main(String[] args) {
        MyTaskManager manager = new MyTaskManager();
        manager.addTask(new Task("Go home",6));
        manager.addTask(new Task("Second task", 8));
        Timer timer = new Timer();
        TimerTask task = new MyTimerTask(manager);
        timer.schedule(task, 0L,60L*1000);
    }
}
