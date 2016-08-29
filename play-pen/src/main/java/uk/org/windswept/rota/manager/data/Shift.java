package uk.org.windswept.rota.manager.data;

/**
 * Created by steveatkinson on 29/08/2016.
 */
public enum Shift
{
    OFF,
    EARLY,
    LATE,
    HALF;

    private static final Shift last = values()[values().length-1];

    public static Shift first()
    {
        return values()[0];
    }

    public static Shift last()
    {
        return last;
    }

    public boolean isLast()
    {
        return this.equals(last);
    }

    public Shift next()
    {
        return values()[ordinal()+1];
    }
}
