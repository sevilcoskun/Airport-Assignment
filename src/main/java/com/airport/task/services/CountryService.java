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

import com.airport.task.models.Country;

@Service
public class CountryService {

    public String getCountryCode(String countryName) {
        List<Country> countries = readCountriesFromCSV();
        List<Country> countryList = countries.stream().filter(country -> country.getName().equals(countryName))
                .collect(Collectors.toList());
        return countryList.size() == 0 ? null : countryList.get(0).getCode();
    }

    // TODO: BONUS
    public String fetchPartialCountryCode(String countryName) throws IllegalArgumentException {
        return null;
    }

    public List<String> getCountryName(String countryCode) {
        List<Country> countries = readCountriesFromCSV();
        List<String> countryNameList = countries.stream().filter(country -> country.getCode().equals(countryCode))
                .map(country -> country.getName()).collect(Collectors.toList());
        return countryNameList;
    }

    private List<Country> readCountriesFromCSV() {
        List<Country> countries = new ArrayList<>();

        try {
            Path pathToFile = Paths.get("src/main/resources/countries.csv");
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8);

            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.replaceAll("\"", "").split(",");

                Country country = createCountry(attributes);
                countries.add(country);

                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return countries;
    }

    private Country createCountry(String[] metadata) {
        String id = metadata[0];
        String code = metadata[1];
        String name = metadata[2];

        return new Country(id, code, name);
    }

}
