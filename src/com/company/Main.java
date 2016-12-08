package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static HashMap<String, ArrayList<Country>> countryList = new HashMap<>(); //HashMap<String, ArrayList<Country>
    public static void main(String[] args) throws Exception {
        fileScan();
        enterLetter();
    }
    public static void fileScan() throws Exception {
//Create file object and scanner, scan file
        File countriesFile = new File("countries.txt");
        Scanner countryScanner = new Scanner(countriesFile);
//while the file has more stuff
        while (countryScanner.hasNext()) {                                              //read each line
            String line = countryScanner.nextLine();
            String[] columns = line.split("\\|");                                //split each line into an array
            Country country = new Country(columns[1], columns[0]);
            country.countryName.substring(0,1);                                         //use the array to create a new country
            String firstLetter = country.countryName.substring(0,1);                    //figure out first letter of the of the country name
            if(countryList.containsKey(firstLetter)) {                                  //if HashMap contains the first letter as a key
                ArrayList<Country> hasFirstLetter = countryList.get(firstLetter);       //ArrayList<Country> temp = get the ArrayList out of the HashMap using the
                hasFirstLetter.add(country);                                            //add our new Country to that ArrayList
//else HashMaps does not contain the first letter as a key
            } else {
                ArrayList<Country> addCountry = new ArrayList<>();                      //create a new ArrayList
                addCountry.add(country);                                                //add our new Country to that ArrayList
                //put the ArrayList into our HashMap using the first letter as a key
                countryList.put(firstLetter, addCountry);
            }
        }
//end of while loop
    }
    public static void enterLetter() throws Exception  {
//ask the user for the a letter they want the countries
        String letterEntered;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter letter to list the countries beginning with that letter:");
        letterEntered = scanner.nextLine();
//if they haven't entered a single letter
        if (letterEntered.isEmpty()) {                                                  //throw exception, error message
            System.out.println("No letter entered!");
        }
        else {                                                                          //else
            File writeCountryList = new File(letterEntered + "_countries.txt");
            FileWriter fw = new FileWriter(writeCountryList);
            int i = 0;
//get the ArrayList out of the HashMap using the entered letter as the key
            for (Country addLetter : countryList.get(letterEntered)) {                  //create file object with correct name
                if (addLetter.countryAbbreviation == letterEntered) {
                    System.out.printf("%s %s", letterEntered, addLetter.countryAbbreviation);
                }
                i++;//iterate through ArrayList
                //write out each country to a new line in our file
                fw.append(addLetter.countryName + "\n");
            }
//close the file
            fw.close();
        }

    }
}
