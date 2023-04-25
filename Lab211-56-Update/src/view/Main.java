/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import BO.ChangeSalary;
import java.util.ArrayList;
import model.History;
import model.Worker;
import controller.ManagementWorker;
/**
 *
 * @author tungl
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Worker> listWorker = new ArrayList<>();
        ArrayList<History> listHistory = new ArrayList<>();
        //loop until user want to exit
        while (true) {
            int choice = ManagementWorker.menu();
            switch (choice) {
                case 1:
                    ManagementWorker.addWorker(listWorker);
                    break;
                case 2:
                    ChangeSalary.changeSalary(listWorker, listHistory, 1);
                    break;
                case 3:
                    ChangeSalary.changeSalary(listWorker, listHistory, 2);
                    break;
                case 4:
                    ManagementWorker.printListHistory(listHistory);
                    break;
                case 5:
                    return;
            }
        }
    }
}
