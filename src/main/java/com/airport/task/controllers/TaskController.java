package com.airport.task.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airport.task.models.Runaway;
import com.airport.task.services.AirportService;
import com.airport.task.services.CountryService;
import com.airport.task.services.RunawayService;

@RestController
public class TaskController {

    @RequestMapping("/country-runaways")
    @ResponseBody
    public String country(@RequestParam(name = "name", required = true) String name) {
        CountryService cs = new CountryService();
        RunawayService rs = new RunawayService();
        String header = "<html>\n" + "<header><title>Runaways For " + name + "</title></header>\n" +
        "<body>\n";

        StringBuilder body = new StringBuilder();

        try {

            String countryCode = cs.getCountryCode(name);

            if (countryCode == null) {
                countryCode = cs.fetchPartialCountryCode(name);
            }

            if (countryCode != null) {
                List<Runaway> runaways = rs.returnRunaways(countryCode);
              
                runaways.forEach(runaway -> {
                    body.append("<li>" + runaway.toString() + "</li>");
                } );
            }

            if (countryCode == null) {
                body.append("Entered country is not matching with any country possibilities, please try again");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Entered country is not matching with any country possibilities, please try again");
            body.append(e.getMessage());
        }

       String footer = "</body>\n" + "</html>";
       
       return header + body + footer;
    }

    @RequestMapping("/list-top-10-countries-with-max-airports")
    public String maxAirports() {
        String header = "<html>\n" + "<header><title> Top 10 Countries which has Highest Airports </title></header>\n" + "<body>\n";
        StringBuilder body = new StringBuilder();

        AirportService as = new AirportService();
        CountryService cs = new CountryService();

        SortedMap<Long, String> resultMap = new TreeMap<Long, String>(Collections.reverseOrder());

        try {
            // Get Top 10 Airports in CountryCode, Number of Total Airport
            Map<String, Long> highestNumberOfAirportsMap = as.getHighestAirports();

            Map<String, String> countryCodeAndNamesMap = new HashMap<>();

            // Create a Map with Top 10 CountryCode and CountryName
            for (Map.Entry<String, Long> entry : highestNumberOfAirportsMap.entrySet()) {
                countryCodeAndNamesMap.put(entry.getKey(), cs.getCountryName(entry.getKey()).get(0));
            }

            // Convert Sorted Country Code Map with CountryName Map
            for (Map.Entry<String, Long> entry : highestNumberOfAirportsMap.entrySet()) {
                resultMap.put(entry.getValue(), countryCodeAndNamesMap.get(entry.getKey()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        for(Map.Entry<Long, String> entry : resultMap.entrySet()){
            body.append("<li>" + entry.getValue() + ": " + entry.getKey() + "</li>");
        }

        String footer = "</body>\n" + "</html>";
       
       return header + body + footer;
    }

}