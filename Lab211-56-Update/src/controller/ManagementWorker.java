/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to ngnge this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import model.History;
import model.Worker;
import validation.Validation;
import BO.*;
/**
 *
 * @author tungl
 */
public class ManagementWorker {
    //show menu

    public static int menu() {
        System.out.println("1. Add worker.");
        System.out.println("2. Increase salary for worker.");
        System.out.println("3. Decrease for worker");
        System.out.println("4. Show adjusted salary worker information");
        System.out.println("5. Exist");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 5);
        return choice;
    }

    //allow user add worker
    public static void addWorker(ArrayList<Worker> listWorker) {
        System.out.print("Enter code: ");
        String id = Validation.checkInputString();
//        if (!Validation.checkIdExist(listWorker, id)) {
//            System.err.println("Code(id) must be existed in DB.");
//            return;
//        }
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        System.out.print("Enter age: ");
        int age = Validation.checkInputIntLimit(18, 50);
        System.out.print("Enter salary: ");
        int salary = Validation.checkInputSalary();
        System.out.print("Enter work location: ");
        String workLocation = Validation.checkInputString();
        if (!Validation.checkWorkerExist(listWorker, id, name, age, salary, workLocation)) {
            System.err.println("Duplicate.");
        } else {
            listWorker.add(new Worker(id, name, age, salary, workLocation));
            System.err.println("Add success.");
        }
    }
    //allow user print history
    public static void printListHistory(ArrayList<History> listHistory) {
        if (listHistory.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(listHistory);
        //print history from first to last list
        for (History history : listHistory) {
            printHistory(history);
        }
    }

    //get worker by code
    public static Worker getWorkerByCode(ArrayList<Worker> listWorker, String id) {
        for (Worker worker : listWorker) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    //get current date 
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    //print history
    public static void printHistory(History history) {
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }
}
