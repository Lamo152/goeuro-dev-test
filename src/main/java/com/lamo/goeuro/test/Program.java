package com.lamo.goeuro.test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.lamo.goeuro.test.model.City;
import com.lamo.goeuro.test.services.GetCityAPI;
import com.lamo.goeuro.test.utils.CSVFileHelper;

/**
 * @author Lamo
 */
public class Program 
{
	private final static Logger LOGGER = Logger.getLogger(Program.class.getName());

	public static void main( String[] args )
	{
		if (args.length == 0) {
			System.err.println("No arguments! Pass a city name as a parameter.");
			System.exit(0);
		}

		String city = args[0];
		GetCityAPI restConsumer = new GetCityAPI();

		try {
			CsvSchema schema = CSVFileHelper.getCsvSchema(City.class);
			List<City> cities = restConsumer.querySuggestedCities(city);
			CSVFileHelper.writeToCSV(cities, schema, city);
		} catch (JsonGenerationException e) {
			LOGGER.severe(String.format("Exception while writing to a file. %s", e.getMessage()));
		} catch (JsonMappingException e) {
			LOGGER.severe(String.format("Exception while writing to a file. %s", e.getMessage()));
		} catch (IOException e) {
			LOGGER.severe(String.format("Exception while writing to a file. %s", e.getMessage()));
		} catch (IllegalArgumentException e) {
			LOGGER.severe(String.format("Wrong parameter. %s", e.getMessage()));
		}
	}
}

