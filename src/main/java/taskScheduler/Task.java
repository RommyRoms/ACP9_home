package taskScheduler;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by ro on 29.10.2015.
 */
public class Task {
    private String name;
    private Calendar calendar;


    public Task(String name,int minutes) {
        this.name = name;
        calendar = new GregorianCalendar(2015,10,5,16,minutes);
    }

    public String getName() {
        return name;
    }

    public int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", calendar=" + calendar +
                '}';
    }
}
