package com.company;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class accessInformation {
    public static void accessInformation(int lineCounter) throws FileNotFoundException {

        //region Variable Declaration

        String patientLine = null;
        String[] patientData = null;

        //endregion

        //region Line Picker
        try
        {

            patientLine = Files.readAllLines(Paths.get("/Users/ryantobin/Coding Projects/hospitalDatabase/patientInformation/patientData")).get(lineCounter);
            //This separates the CSV file and saves the specific patient's info into a new string, using a passed in parameter

            patientData = patientLine.split(",");
            //This separates the line into an array of data

        }
        catch(IOException e)
        {

            System.out.println(e);
            //error in case the line is not found

        }
        //endregion

        //region Information Display

        System.out.println("Name: " + patientData[0] + " " + patientData[1]);
        System.out.println("Weight: " + patientData[3]);
        System.out.println("Height: " + patientData[4]);
        System.out.println("Age: " + patientData[5]);
        System.out.println("Date of Birth: " + patientData[6]);

        //endregion

        }
    }

