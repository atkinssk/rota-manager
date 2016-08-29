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
public class PartTimeValidator extends ValidatorBase implements Validator
{
    public boolean accept (WeekRota rota)
    {
        // Should contain an entry for each day of the week
        // Should have two off days
        // Should have
        return allDays(rota) && validShifts(rota);
    }

    private boolean validShifts (WeekRota rota)
    {
        List<Shift> shifts = getShifts(rota.getDayRotas());
        return shifts.size() == 7 &&
                filterShifts(shifts, Shift.EARLY, Shift.LATE).size() == 4 &&
                filterShifts(shifts, Shift.OFF).size() == 3
                ;
    }
}
