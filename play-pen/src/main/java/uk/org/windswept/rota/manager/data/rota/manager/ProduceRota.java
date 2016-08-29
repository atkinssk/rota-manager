package uk.org.windswept.rota.manager.data.rota.manager;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.org.windswept.rota.manager.data.Day;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by steveatkinson on 29/08/2016.
 */
public class ProduceRota
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProduceRota.class);

    private final Validator validator;
    private final File target;

    public ProduceRota (Validator validator, File target)
    {
        this.validator = validator;
        this.target = target;
    }

    public void produceRota () throws IOException
    {
        final Appendable out = new FileWriter(target);
        final CSVPrinter printer = CSVFormat.EXCEL.withHeader(Day.class).print(out);

        WeekRotaIterator it = new WeekRotaIterator();

        while (it.hasNext())
        {
            WeekRota weekRota = it.next();
            boolean valid = validator.accept(weekRota);
            LOGGER.info("{} {}", valid, weekRota.toCSV());
            if (valid)
            {
                printer.printRecord(weekRota.shifts());
            }
        }
        printer.close();
        LOGGER.info("CSV written to {}", target);
    }
}
