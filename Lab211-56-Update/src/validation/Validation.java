/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.ArrayList;
import java.util.Scanner;
import model.Worker;

/**
 *
 * @author tungl
 */
public class Validation {

    private final static Scanner in = new Scanner(System.in);

// Method to validate user input of an integer within a specified range.
    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException(); // Throw an exception if the input is outside of the specified range.
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number in the range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

// Method to validate user input of a non-empty string.
    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input cannot be empty.");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

// Method to check if a given Worker ID exists in a list of Workers.
    public static boolean checkIdExist(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) { // Check if any Worker object in the list has the same ID as the given ID.
                return true;
            }
        }
        return false; // If no match is found, return false.
    }

// Method to validate user input of a positive integer (salary).
    public static int checkInputSalary() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < 0) {
                    throw new NumberFormatException(); // Throw an exception if the input is negative.
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Salary must be greater than 0.");
                System.out.print("Enter again: ");
            }
        }
    }

// Method to check if a given Worker (identified by ID, name, age, and salary) already exists in a list of Workers.
    public static boolean checkWorkerExist(ArrayList<Worker> lw, String id, String name, int age, int salary, String workLocation) {
        for (Worker i : lw) {
            if (id.equalsIgnoreCase(i.getId()) // Check if any Worker object in the list matches all the input parameters.
                    && name.equalsIgnoreCase(i.getName())
                    && age == i.getAge()
                    && salary == i.getSalary()) {
                return false; // If a match is found, return false (i.e. the Worker already exists in the list).
            }
        }
        return true; // If no match is found, return true.
    }
}
