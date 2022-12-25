# Developer Assessment

##Description
The assessment comes with 3 CSV files. The files contain data for countries, airports and runways.

Write a program that retrieves the following information given the provided files:
- Runways for each airport given a country code or country name. 
- Top 10 countries with highest number of airports.

Bonus: Support retrieving the information given a partial/fuzzy country code/name as input parameter, e.g. entering 'zimb' will result in 'Zimbabwe'. 

##Requirements
- The program should be written in Java.
- Write production-ready code.
- Document how to run the application.
- Publish the source code into GitHub (using your own personal account) and share it with us.

**_Disclaimer: The data files in this repo have been extracted from https://openflights.org/data.html. Accenture claims no ownership or responsibility to this data or its usage._**

## How to Run Application:
# Prerequisites:
- Java 17 JDK Installed
- Maven Installed
# Run Applicaiton
  1. To get all Runaways for a given country NAME:
  - Go to your Web Browser and type
  - > localhost:8080/country-runaways?name={PUT COUNTRY NAME} 
  - e.g. Turkey, Netherlands

  2. Top 10 countries with highest number of airports.
  - Go to your Web Browser and type
  - > localhost:8080/list-top-10-countries-with-max-airports



