package co.edu.unbosque.servletjsptutorial.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import co.edu.unbosque.servletjsptutorial.dtos.User;

import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {
	
	public List<User> readFromPath(String localPath) {
        try {
            URI uri = ClassLoader.getSystemResource(localPath).toURI();
            Path path = Paths.get(uri);
            HeaderColumnNameMappingStrategy ms = new HeaderColumnNameMappingStrategy();
            ms.setType(User.class);
            
            Reader reader = Files.newBufferedReader(path);
            CsvToBean cb = new CsvToBeanBuilder(reader).withType(User.class)
                    .withMappingStrategy(ms)
                    .withSeparator(';')
                    .build();


            CsvTransfer csvTransfer = new CsvTransfer();
            csvTransfer.setCsvList(cb.parse());
            reader.close();

            return csvTransfer.getCsvList();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {

        System.out.println("Reading a CSV using OpenCSV library");

        List<User> result = new ReadCsv().readFromPath("resources/users.csv");
        for (User r : result) {
            System.out.println(r.toString());
        }
    }
}
