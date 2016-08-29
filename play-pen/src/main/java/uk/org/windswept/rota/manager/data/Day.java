package uk.org.windswept.rota.manager.data;

import com.google.common.base.Function;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

/**
 * Created by steveatkinson on 29/08/2016.
 */
public enum Day
{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static final List<String> valuesAsStrings()
    {
        return transform (newArrayList(values()), new Function<Day,String>(){
            public String apply (Day input)
            {
                return input.toString();
            }
        });
    }
}
