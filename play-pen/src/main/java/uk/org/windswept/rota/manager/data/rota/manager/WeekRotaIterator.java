package uk.org.windswept.rota.manager.data.rota.manager;

import uk.org.windswept.rota.manager.data.Day;
import uk.org.windswept.rota.manager.data.Shift;

import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by steveatkinson on 29/08/2016.
 */
public class WeekRotaIterator implements Iterator<WeekRota>
{
    private final List<DayRota> dayRotaList = newArrayList();
    public WeekRotaIterator ()
    {
        for (Day day : Day.values())
        {
             dayRotaList.add(new DayRota(day, Shift.values()[0]));
        }
    }

    public boolean hasNext ()
    {
        Shift last = Shift.last();
        // TODO optimise this by keeping track of it
        for (DayRota dayRota : dayRotaList)
        {
           if (!dayRota.getShift().equals(last))
           {
               return true;
           }
        }
        return false;
    }

    public WeekRota next ()
    {
        for (DayRota dayRota : dayRotaList)
        {
            if (dayRota.getShift().isLast())
            {
                dayRota.setShift(Shift.first());
            }
            else
            {
                dayRota.setShift(dayRota.getShift().next());
                break;
            }
        }
        return cloneList(dayRotaList);
    }

    private WeekRota cloneList (final List<DayRota> dayRotaList)
    {
        final WeekRota weekRota = new WeekRota()    ;
        for (DayRota dayRota : dayRotaList)
        {
            weekRota.add(new DayRota(dayRota));
        }
        return weekRota ;
    }


    public void remove ()
    {
        throw new IllegalAccessError("remove method not supported") ;
    }
}
