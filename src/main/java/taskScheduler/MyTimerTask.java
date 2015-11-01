package taskScheduler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimerTask;

/**
 * Created by ro on 29.10.2015.
 */
public class MyTimerTask extends TimerTask {
    private MyTaskManager taskManager;

    public MyTimerTask(MyTaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public void run() {
        Calendar justNowCalendar = new GregorianCalendar();
        String result = "";
        taskManager.getTaskList().stream().filter(t -> t.getMinute() == justNowCalendar.get(Calendar.MINUTE)).forEach(t -> {
            System.out.println(t);
        });
    }
}
