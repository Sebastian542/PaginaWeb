package co.edu.unbosque.servletjsptutorial.services;


import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class OpenCSVWriter {
    private static final String STRING_ARRAY_SAMPLE = "./src/main/resources/punto3.csv";
  //  private static final String OBJECT_LIST_SAMPLE = "./object-list-sample.csv";

    

	public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {

        writeFromArrayOfStrings();
        writeFromListOfObjects();
        
    }


    private static void writeFromArrayOfStrings() throws IOException {
        try (
            Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));

            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
        ) {
            String[] headerRecord = {"username", "titulo", "precio", "urlobra"};
            csvWriter.writeNext(headerRecord);

          //  csvWriter.writeNext(new String[]{"sada","Sundar Pichai ♥", "sundar.pichai@gmail.com", "111111111", "India"});
           
        }
    }

    private static void writeFromListOfObjects() throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {

        try (
            Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));
        ) {
            StatefulBeanToCsv<CrearObra> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<CrearObra> myUsers = new ArrayList<>();
            
            System.out.println(Paths.get(STRING_ARRAY_SAMPLE));
            
            
            myUsers.add(new CrearObra("sada","Sundar Pichai ♥", 1111111111, "primeraobra.jpg"));
            
    

            beanToCsv.write(myUsers);
        }
    }
}
