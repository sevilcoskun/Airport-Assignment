package com.airport.task.services;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.airport.task.models.Airport;

@Service
public class AirportService {

    private List<Airport> readAirportsFromCSV() {
        List<Airport> airports = new ArrayList<>();

        try {
            Path pathToFile = Paths.get("src/main/resources/airports.csv");
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8);

            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.replaceAll("\"", "").split(",");

                Airport airport = createAirport(attributes);
                airports.add(airport);

                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return airports;
    }

    private Airport createAirport(String[] metadata) {
        String id = metadata[0];
        String name = metadata[3];
        String countryCode = metadata[8];
        return new Airport(id, name, countryCode);
    }

    protected List<String> getAirportIds(String countryCode) {
        // Reading Airports from CSV
        List<Airport> airports = readAirportsFromCSV();
        List<String> airportIds = airports.stream().filter(airport -> airport.getIso_country().equals(countryCode))
                .map(airport -> airport.getId()).collect(Collectors.toList());
        return airportIds;
    }

    public Map<String, Long> getHighestAirports() {
        // Reading Airports from CSV
        List<Airport> airports = readAirportsFromCSV();

        // Grouping by Country
        Map<String, Long> groupedAirports = airports.stream()
                .collect(Collectors.groupingBy(Airport::getIso_country, Collectors.counting()));

        // Sorting in Desc order and Limit by 10
        Map<String, Long> sortedMap = groupedAirports.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        SortedMap<String, Long> resultMap = new TreeMap<String, Long>();

        for (Map.Entry<String, Long> entry : sortedMap.entrySet()) {
            resultMap.put(entry.getKey(), entry.getValue());
        }

        return resultMap;
    }

}
