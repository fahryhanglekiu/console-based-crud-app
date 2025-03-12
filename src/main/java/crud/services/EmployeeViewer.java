package services;

import repository.EmployeeRepository;

public class EmployeeViewer {
    public void ViewEmployee(){
        System.out.println("Employees :");

        for (int i = 0; i < EmployeeRepository.getInstance().getUserListLength(); i++){
            String toPrint = EmployeeRepository.getInstance().getUserList().get(i).Name + " " + EmployeeRepository.
                    getInstance().getUserList().get(i).Position;

            System.out.println(toPrint);
        }

        MenuPageViewer.getInstance().DisplayMainPrompt();
    }
}
