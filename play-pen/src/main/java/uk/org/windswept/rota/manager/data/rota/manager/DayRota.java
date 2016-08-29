package uk.org.windswept.rota.manager.data.rota.manager;

import uk.org.windswept.rota.manager.data.Day;
import uk.org.windswept.rota.manager.data.Shift;

/**
 * Created by steveatkinson on 29/08/2016.
 */
public class DayRota
{
    private Day day;
    private Shift shift;

    public DayRota (Day day, Shift shift)
    {
        this.day = day;
        this.shift = shift;
    }

    public DayRota (DayRota dayRota)
    {
        this.day = dayRota.getDay();
        this.shift = dayRota.getShift();
    }

    public Day getDay ()
    {
        return day;
    }

    public Shift getShift ()
    {
        return shift;
    }

    public void setDay (Day day)
    {
        this.day = day;
    }

    public void setShift (Shift shift)
    {
        this.shift = shift;
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder("DayRota{");
        sb.append("day=").append(day);
        sb.append(", shift=").append(shift);
        sb.append('}');
        return sb.toString();
    }
}
