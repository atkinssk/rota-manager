package uk.org.windswept.rota.manager.data.rota.manager;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import uk.org.windswept.rota.manager.data.Day;
import uk.org.windswept.rota.manager.data.Shift;

import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

/**
 * Created by steveatkinson on 29/08/2016.
 */
public abstract class ValidatorBase
{
    protected Collection<Shift> filterShifts (final List<Shift> shifts, final Shift... allowedShifts)
    {
        return filterShifts(shifts, newArrayList(allowedShifts));
    }

    protected Collection<Shift> filterShifts (final List<Shift> shifts, final List<Shift> allowedShifts)
    {
        return filter(shifts, new Predicate<Shift>() {
            public boolean apply (Shift input)
            {
                return allowedShifts.contains(input);
            }
        });
    }

    protected boolean allDays (WeekRota rota)
    {
        List<Day> days = getDays(rota.getDayRotas());

        return days.size() == 7 && days.containsAll(newArrayList(Day.values()));
    }

    protected List<Shift> getShifts (List<DayRota> dayRotas)
    {
        return transform(dayRotas, new Function<DayRota, Shift>(){
            public Shift apply (DayRota input)
            {
                return input.getShift();
            }
        });
    }

    protected List<Day> getDays (List<DayRota> dayRotas)
    {
        return transform(dayRotas, new Function<DayRota, Day>(){
            public Day apply (DayRota input)
            {
                return input.getDay();
            }
        });
    }
}
