package com.airport.task.services;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.airport.task.models.Runaway;

@Service
public class RunawayService {

    private List<Runaway> readRunawaysFromCSV() {
        List<Runaway> runaways = new ArrayList<>();

        try {
            Path pathToFile = Paths.get("src/main/resources/runways.csv");
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8);

            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.replaceAll("\"", "").split(",", 20);

                Runaway runaway = createRunaway(attributes);
                runaways.add(runaway);

                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return runaways;
    }

    private Runaway createRunaway(String[] metadata) {
        String id = metadata[0];
        String airport_ref = metadata[1];
        String airport_ident = metadata[2];
        String length_ft = metadata[3];
        String width_ft = metadata[4];
        String surface = metadata[5];
        String lighted = metadata[6];
        String closed = metadata[7];
        String le_ident = metadata[8];
        String le_latitude_deg = metadata[9];
        String le_longitude_deg = metadata[10];
        String le_elevation_ft = metadata[11];
        String le_heading_degT = metadata[12];
        String le_displaced_threshold_ft = metadata[13];
        String he_ident = metadata[14];
        String he_latitude_deg = metadata[15];
        String he_longitude_deg = metadata[16];
        String he_elevation_ft = metadata[17];
        String he_heading_degT = metadata[18];
        String he_displaced_threshold_ft = metadata[19];

        return new Runaway(id,
                airport_ref,
                airport_ident,
                length_ft,
                width_ft,
                surface,
                lighted,
                closed,
                le_ident,
                le_latitude_deg,
                le_longitude_deg,
                le_elevation_ft,
                le_heading_degT,
                le_displaced_threshold_ft,
                he_ident,
                he_latitude_deg,
                he_longitude_deg,
                he_elevation_ft,
                he_heading_degT,
                he_displaced_threshold_ft);
    }

    public List<Runaway> returnRunaways(String countryCode) {
        AirportService as = new AirportService();
        List<String> airtporIds = as.getAirportIds(countryCode);

        List<Runaway> result = new ArrayList<>();

        List<Runaway> runaways = readRunawaysFromCSV();

        airtporIds.forEach(id -> {
            List<Runaway> temp = runaways.stream().filter(runaway -> runaway.getAurport_ref().equals(id))
                    .collect(Collectors.toList());
            if (temp.size() > 0) {
                result.addAll(temp);
            }
        });

        return result;

    }

}
