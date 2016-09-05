package com.lamo.goeuro.test.utils;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CSVFileHelper {
	public static final String CSV_EXTENSION = ".csv";
	private static CsvMapper mapper = new CsvMapper();

    /**
     * Method that can be used to get a CSV schema to use for given
     * POJO type.
     * @param pojoType the type.
     */
	public static CsvSchema getCsvSchema(Class<?> pojoType){
		return mapper.schemaFor(pojoType).withHeader();
	}
	
	/**
	 * Writes list of object to a csv file.
	 * @param objects {@code List} of objects to be written into the csv file.
	 * @param schema schema for the csv file.
	 * @param fileName name of the  csv file.
	 */
	public static void writeToCSV(List<?> objects, CsvSchema schema, String fileName)
			throws JsonGenerationException, JsonMappingException, IOException {
		checkArgument(objects != null, "The citiy list must not be null" );
		checkArgument(objects != null && !fileName.isEmpty(), "Wrong name of the csv file" );
		ObjectWriter writer = mapper.writer(schema.withLineSeparator("\n"));
		writer.writeValue(new File(fileName.concat(CSV_EXTENSION)), objects);
	}
	
	/**
	 * Writes list of object to a csv file.
	 * @param objects {@code List} of objects to be written into the csv file.
	 * @param schema schema for the csv file.
	 * @param fileName name of the  csv file.
	 * @param file for test purposes
	 */
	public static void writeToCSVFile(List<?> objects, CsvSchema schema, File file)
			throws JsonGenerationException, JsonMappingException, IOException {
		checkArgument(objects != null, "The citiy list must not be null" );
		checkArgument(objects != null && file != null , "Null file" );
		ObjectWriter writer = mapper.writer(schema.withLineSeparator("\n"));
		writer.writeValue(file, objects);
	}
}
