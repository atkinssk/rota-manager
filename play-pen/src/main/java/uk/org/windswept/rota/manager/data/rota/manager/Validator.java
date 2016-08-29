package uk.org.windswept.rota.manager.data.rota.manager;

import uk.org.windswept.rota.manager.data.Day;
import uk.org.windswept.rota.manager.data.Shift;

import java.util.Collection;
import java.util.List;

/**
 * Created by steveatkinson on 29/08/2016.
 */
public interface Validator
{
    public boolean accept(WeekRota rota);
}
