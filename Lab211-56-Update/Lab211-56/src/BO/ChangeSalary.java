/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import static controller.ManagementWorker.getCurrentDate;
import static controller.ManagementWorker.getWorkerByCode;
import java.util.ArrayList;
import model.History;
import model.Worker;
import validation.Validation;

/**
 *
 * @author tungl
 */
public class ChangeSalary {
    //allow user increase salary for user
    public static void changeSalary(ArrayList<Worker> lw, ArrayList<History> lh, int status) {
        if (lw.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter code: ");
        String id = Validation.checkInputString();
        Worker worker = getWorkerByCode(lw, id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            int salaryCurrent = worker.getSalary();
            int salaryUpdate;
            //check user want to update salary
            if (status == 1) {
                System.out.print("Enter salary: ");
                //loop until user input salary update > salary current
                while (true) {
                    salaryUpdate = Validation.checkInputSalary();
                    //check user input salary update > salary current
                    if (salaryUpdate <= salaryCurrent) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("UP", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            } else {
                System.out.print("Enter salary: ");
                //loop until user input salary update < salary current
                while (true) {
                    salaryUpdate = Validation.checkInputSalary();
                    //check user input salary update < salary current
                    if (salaryUpdate >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("DOWN", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            }
            worker.setSalary(salaryUpdate);
            System.err.println("Update success");
        }
    }
}
