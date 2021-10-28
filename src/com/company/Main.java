package com.company;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //region Initial Question

        Scanner scan = new Scanner(System.in);
        // Starts new scanner

        System.out.println("Would you like to create a patient file? (Y/N)");

        String answer1 = scan.next();
        String answer2 = answer1.toUpperCase(Locale.ROOT);
        // This saves there answer to be checked

        //endregion

        //region If/Else Statement

        if (answer2.equals("Y"))
        {
            //If answer = yes, runs createPatient class method
            createPatient.createPatient();
        }
        else {
            //If answer is no, will run patient access

            //region Variable Declaration

            String firstName = null;
            String lastName = null;
            String patientID = null;
            int tracker = 0;
            int lineCounter = -1;

            //endregion

            //region Patient Access Input

            System.out.println("Enter the patient's first name: ");
            // Saving first name to string
            String firstNameInput = scan.next();

            System.out.println("Enter the patient's last name: ");
            // Saving last name to string
            String lastNameInput = scan.next();

            System.out.println("Enter the patient's ID number: ");
            // Saving ID to string
            String patientIdInput = scan.next();

            scan.close();
            // Ending the input scanner

            //endregion

            //region Database Reader

            String filePath = "/Users/ryantobin/Coding Projects/hospitalDatabase/patientInformation/patientData";
            Scanner dataReader = new Scanner(new File(filePath));
            // Initializes a scanner that reads the CSV file

            while (dataReader.hasNextLine()) {

                String line = dataReader.nextLine();
                String[] info = line.split(",");
                // This splits the CSV file into lines

                lineCounter++;

                firstName = info[0];
                lastName = info[1];
                patientID = info[2];
                // Saves the patient information in 3 categories

                if (firstName.equals(firstNameInput) && lastName.equals(lastNameInput) && patientID.equals(patientIdInput)) {
                    System.out.println("Finding " + info[0] + "'s information...");
                    accessInformation.accessInformation(lineCounter);
                    tracker++;
                    break;
                }

            }

            if (tracker == 0) {
                System.out.println("Unable to locate " + firstNameInput + "'s information.");
            }

            //endregion
        }

        //endregion
    }

}
