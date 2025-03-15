package services;

import repository.EmployeeRepository;

import java.util.Scanner;

public class EmployeeRemover {
    public void RemoveEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id: ");

        var inputId = scanner.nextLine();

        int id;
        try{
            id = Integer.parseInt(inputId);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid input");
            id = 0;
            RemoveEmployee();
        }

        var userListSize = EmployeeRepository.getInstance().getUserListLength();

        if(id > userListSize || id < 1){
            if(userListSize == 0) {
                System.out.println("No current active employee yet..");
                MenuPageViewer.getInstance().DisplayMainPrompt();
            }
            else {
                System.out.println("User's Id not found...");
                RemoveEmployee();
            }
        }
        else{
            EmployeeRepository.getInstance().removeUserByIndex(id - 1);
            System.out.println("Successfully removed employee with id " + id);
            MenuPageViewer.getInstance().DisplayMainPrompt();
        }
    }
}
