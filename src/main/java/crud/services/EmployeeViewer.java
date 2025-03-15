package services;

import repository.EmployeeRepository;

public class EmployeeViewer {
    public void ViewEmployee(){
        System.out.println("Employees :");

        for (int i = 0; i < EmployeeRepository.getInstance().getUserListLength(); i++){
            var item = EmployeeRepository.getInstance().getUserList().get(i);

            var name = item.Name;
            var position = item.Position;

            var id = i + 1;

            String toPrint = "Id: " + id + " Name: " + name + " Position: " + position;

            System.out.println(toPrint);
        }

        MenuPageViewer.getInstance().DisplayMainPrompt();
    }
}
