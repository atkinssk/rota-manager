package uk.org.windswept.rota.manager;

import com.google.common.io.Files;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.org.windswept.rota.manager.data.Day;
import uk.org.windswept.rota.manager.data.Shift;
import uk.org.windswept.rota.manager.data.rota.manager.*;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by steveatkinson on 29/08/2016.
 */
public class ProduceRotaTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProduceRotaTest.class);

    @Test
    public void shouldProducePartTime () throws Exception
    {
        new ProduceRota(new PartTimeValidator(), FileUtils.getFile("target", "PartTime.csv")).produceRota();
    }
    @Test
    public void shouldProduceFullTime () throws Exception
    {
        new ProduceRota(new FullTimeValidator(), FileUtils.getFile("target", "FullTime.csv")).produceRota();
    }
}
