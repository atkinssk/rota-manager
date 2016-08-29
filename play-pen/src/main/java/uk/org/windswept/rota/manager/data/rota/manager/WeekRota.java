package uk.org.windswept.rota.manager.data.rota.manager;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.transform;


/**
 * Created by steveatkinson on 29/08/2016.
 */
public class WeekRota
{
    private final List<DayRota> dayRotas;

    public WeekRota (List<DayRota> dayRotas)
    {
        this.dayRotas = dayRotas;
    }

    public WeekRota()
    {
        this(new ArrayList());
    }

    public WeekRota add(DayRota dayRota)
    {
        dayRotas.add(dayRota);
        return this;
    }

    public List<DayRota> getDayRotas ()
    {
        return dayRotas;
    }

    public String toCSV()
    {
        return Joiner.on(",").join(transform(dayRotas, shiftFunction()));
    }

    private Function<DayRota, String> shiftFunction ()
    {
        return new Function<DayRota, String>()
        {
            public String apply (DayRota input)
            {
                return input.getShift().toString();
            }
        };
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder("WeekRota{");
        sb.append("dayRotas=").append(dayRotas);
        sb.append('}');
        return sb.toString();
    }

    public List<String> shifts ()
    {
        return transform(dayRotas, shiftFunction());
    }
}
