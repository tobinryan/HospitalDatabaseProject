package com.company;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class createPatient {
    public static void createPatient() {

        //region Scanner to Create Patient

        Scanner scan = new Scanner(System.in);
        // Starts new scanner

        System.out.println("Provide the patient's first name: ");
        // Saving first name to string
        String patientFirstName = scan.next();

        System.out.println("Provide the patient's last name: ");
        // Saving last name to string
        String patientLastName = scan.next();

        System.out.println("Provide the patient's weight: ");
        // Saving ID to string
        String patientWeight = scan.next();

        System.out.println("Provide the patient's height: ");
        // Saving ID to string
        String patientHeight = scan.next();

        System.out.println("Provide the patient's age: ");
        // Saving ID to string
        String patientAge = scan.next();

        System.out.println("Provide the patient's DOB: ");
        // Saving ID to string
        String patientDOB = scan.next();

        int ID = (int) (Math.random() * 8999 + 1000);
        //Generating a random 4-digit ID number

        String patientID = String.valueOf(ID);
        System.out.println("The patient's unique ID number is: " + patientID);
        // Providing user patient ID

        scan.close();

        //endregion

        //region Writing New Info to CSV

        try {
            // Creating a file writer that doesn't overwrite patient database file
            PrintWriter myWriter = new PrintWriter(new FileWriter("/Users/ryantobin/Coding Projects/hospitalDatabase/patientInformation/patientData", true));
            myWriter.write("\n" + patientFirstName + "," + patientLastName + "," + patientID + "," + patientWeight + "," + patientHeight + "," + patientAge + "," + patientDOB);
            myWriter.close();
            System.out.println("Successfully created a patient.");
        }
        catch (IOException e) {
            // Catches an error
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //endregion
    }
}
