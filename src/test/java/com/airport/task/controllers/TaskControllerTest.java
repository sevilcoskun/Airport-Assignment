package com.airport.task.controllers;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.Normalizer;

import org.junit.jupiter.api.Test;

public class TaskControllerTest {
    @Test
    void testCountryHappyFlow() {
        String expectedOutput = "<html>\n"+
        "<header><title>Runaways For Albania</title></header>\n"+
        "<body>\n"+
        "<li>{ id=\'232874\', airport_ref=\'5\', airport_ident=\'AL-LA10\', length_ft=\'3855\', width_ft=\'228\', surface=\'GRS\', lighted=\'0\', closed=\'0\', le_ident=\'14\', le_latitude_deg=\'40.0915\', le_longitude_deg=\'20.1489\', le_elevation_ft=\'\', le_heading_degT=\'142\', le_displaced_threshold_ft=\'\', he_ident=\'32\', he_latitude_deg=\'40.0831\', he_longitude_deg=\'20.1573\', he_elevation_ft=\'\', he_heading_degT=\'322\', he_displaced_threshold_ft=\'\'}"+
        "</li><li>{ id=\'232870\', airport_ref=\'3969\', airport_ident=\'LAGJ\', length_ft=\'9186\', width_ft=\'197\', surface=\'CON\', lighted=\'1\', closed=\'0\', le_ident=\'16\', le_latitude_deg=\'41.9065\', le_longitude_deg=\'19.5912\', le_elevation_ft=\'19\', le_heading_degT=\'153\', le_displaced_threshold_ft=\'\', he_ident=\'34\', he_latitude_deg=\'41.8841\', he_longitude_deg=\'19.606\', he_elevation_ft=\'23\', he_heading_degT=\'333\', he_displaced_threshold_ft=\'\'}"+
        "</li><li>{ id=\'232871\', airport_ref=\'3969\', airport_ident=\'LAGJ\', length_ft=\'7223\', width_ft=\'78\', surface=\'CON\', lighted=\'0\', closed=\'1\', le_ident=\'17\', le_latitude_deg=\'41.8961\', le_longitude_deg=\'19.5889\', le_elevation_ft=\'\', le_heading_degT=\'169\', le_displaced_threshold_ft=\'\', he_ident=\'35\', he_latitude_deg=\'41.8766\', he_longitude_deg=\'19.5939\', he_elevation_ft=\'\', he_heading_degT=\'349\', he_displaced_threshold_ft=\'\'}"+
        "</li><li>{ id=\'232873\', airport_ref=\'3970\', airport_ident=\'LAKO\', length_ft=\'7475\', width_ft=\'275\', surface=\'GRS\', lighted=\'0\', closed=\'0\', le_ident=\'01\', le_latitude_deg=\'40.6356\', le_longitude_deg=\'20.7389\', le_elevation_ft=\'\', le_heading_degT=\'11\', le_displaced_threshold_ft=\'\', he_ident=\'19\', he_latitude_deg=\'40.6557\', he_longitude_deg=\'20.7443\', he_elevation_ft=\'\', he_heading_degT=\'191\', he_displaced_threshold_ft=\'\'}"+
        "</li><li>{ id=\'264033\', airport_ref=\'31795\', airport_ident=\'LAKU\', length_ft=\'5906\', width_ft=\'148\', surface=\'paved\', lighted=\'1\', closed=\'0\', le_ident=\'01\', le_latitude_deg=\'\', le_longitude_deg=\'\', le_elevation_ft=\'\', le_heading_degT=\'12\', le_displaced_threshold_ft=\'\', he_ident=\'19\', he_latitude_deg=\'\', he_longitude_deg=\'\', he_elevation_ft=\'\', he_heading_degT=\'192\', he_displaced_threshold_ft=\'\'}"+
        "</li><li>{ id=\'232869\', airport_ref=\'3971\', airport_ident=\'LAKV\', length_ft=\'9318\', width_ft=\'220\', surface=\'CON\', lighted=\'1\', closed=\'0\', le_ident=\'14\', le_latitude_deg=\'40.7814\', le_longitude_deg=\'19.8906\', le_elevation_ft=\'\', le_heading_degT=\'137\', le_displaced_threshold_ft=\'200\', he_ident=\'32\', he_latitude_deg=\'40.7624\', he_longitude_deg=\'19.9131\', he_elevation_ft=\'\', he_heading_degT=\'317\', he_displaced_threshold_ft=\'\'}"+
        "</li><li>{ id=\'232868\', airport_ref=\'3972\', airport_ident=\'LATI\', length_ft=\'9022\', width_ft=\'148\', surface=\'ASP\', lighted=\'1\', closed=\'0\', le_ident=\'17\', le_latitude_deg=\'41.427\', le_longitude_deg=\'19.7189\', le_elevation_ft=\'109\', le_heading_degT=\'174\', le_displaced_threshold_ft=\'\', he_ident=\'35\', he_latitude_deg=\'41.4025\', he_longitude_deg=\'19.7222\', he_elevation_ft=\'126\', he_heading_degT=\'354\', he_displaced_threshold_ft=\'\'}"+
        "</li><li>{ id=\'232872\', airport_ref=\'3973\', airport_ident=\'LAVL\', length_ft=\'2813\', width_ft=\'195\', surface=\'GRE\', lighted=\'0\', closed=\'0\', le_ident=\'16\', le_latitude_deg=\'40.4797\', le_longitude_deg=\'19.4726\', le_elevation_ft=\'\', le_heading_degT=\'161.6\', le_displaced_threshold_ft=\'\', he_ident=\'34\', he_latitude_deg=\'40.4724\', he_longitude_deg=\'19.4758\', he_elevation_ft=\'\', he_heading_degT=\'341.6\', he_displaced_threshold_ft=\'\'}"+
        "</li></body>\n"+
        "</html>";
        TaskController tc = new TaskController();
        String actualOutput = tc.country("Albania");
        assertEquals(expectedOutput,actualOutput);

    }

    @Test
    void testMaxAirportsHappyflow() {
        String expectedOutput = "<html>\n"+
        "<header><title> Top 10 Countries which has Highest Airports </title></header>\n"+
        "<body>\n"+
        "<li>United States: 23781</li><li>Brazil: 5323</li><li>Canada: 2802</li><li>Australia: 2018</li><li>Mexico: 1527</li><li>South Korea: 1371</li><li>United Kingdom: 1267</li><li>Russia: 1123</li><li>Germany: 963</li><li>France: 903</li></body>\n"+
        "</html>";
        TaskController tc = new TaskController();
        String actualOutput = tc.maxAirports();
        Normalizer.normalize(actualOutput, Normalizer.Form.NFKC);
        actualOutput.replaceAll("\n", "");
        assertEquals(expectedOutput,actualOutput);
    }

}
