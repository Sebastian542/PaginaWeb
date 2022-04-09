package co.edu.unbosque.servletjsptutorial.services;

import co.edu.unbosque.servletjsptutorial.dtos.Art;
import com.opencsv.bean.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

import co.edu.unbosque.servletjsptutorial.dtos.User;

public class ArtService {

	public List<Art> getArts() throws IOException {

        List<Art> arts;

        try (InputStream is = ArtService.class.getClassLoader()
                .getResourceAsStream("arts.csv")) {

            HeaderColumnNameMappingStrategy<Art> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Art.class);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

                CsvToBean<Art> csvToBean = new CsvToBeanBuilder<Art>(br)
                        .withType(Art.class)
                        .withMappingStrategy(strategy)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                arts = csvToBean.parse();
            }
        }

        return arts;
    }
	
	   public void createArt(String title, String fcoinsprice, String image, String path) throws IOException {
	        String newLine = "\n" + title + "," + fcoinsprice +  ","+image + " ";
	        FileOutputStream os = new FileOutputStream(path + "WEB-INF/classes/" + "arts.csv", true);
	        os.write(newLine.getBytes());
	        os.close();
	    }
}
