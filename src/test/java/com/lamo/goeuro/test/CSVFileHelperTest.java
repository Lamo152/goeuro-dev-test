package com.lamo.goeuro.test;


import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.lamo.goeuro.test.model.City;
import com.lamo.goeuro.test.model.GeoLocation;
import com.lamo.goeuro.test.utils.CSVFileHelper;

public class CSVFileHelperTest {

    @Test
    public void fileShouldBeValid() throws IOException {
        List<City> listCities = new ArrayList<City>();
        File file = new File("berlin.csv");
        City location1 = new City(1234, "prag", "location", new GeoLocation(55.4523, 22.34));
        City location2 = new City(5678, "berlin", "location", new GeoLocation(44.4353, 15.4443));
        City location3 = new City(9156, "paris", "location", new GeoLocation(59.3253523523523, 9.0982379847823));

        listCities.add(location1);
        listCities.add(location2);
        listCities.add(location3);

        CsvSchema schema = CSVFileHelper.getCsvSchema(City.class);
        CSVFileHelper.writeToCSVFile(listCities,schema, file);

        List<String> lines = Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        if (!lines.isEmpty()) {
            assertEquals(lines.get(1), "1234,prag,location,55.4523,22.34");
            assertEquals(lines.get(2), "5678,berlin,location,44.4353,15.4443");
            assertEquals(lines.get(3), "9156,paris,location,59.3253523523523,9.0982379847823");
        }
}
}
