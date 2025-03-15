package services;

import model.User;
import repository.EmployeeRepository;
import java.util.Scanner;

public class EmployeeUpdater {
    public void PrintUpdateEmployeeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id: ");

        var inputId = scanner.nextLine();

        int id;

        try {
            id = Integer.parseInt(inputId);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid input");
            id = 0;
            PrintUpdateEmployeeInput();
        }

        var userListSize = EmployeeRepository.getInstance().getUserListLength();

        if(id > userListSize || id < 1) {
            if(userListSize == 0) {
                System.out.println("No current active employee yet..");
                MenuPageViewer.getInstance().DisplayMainPrompt();
            }
            else {
                System.out.println("User's Id not found...");
                PrintUpdateEmployeeInput();
            }
        }
        else
            SetNewName(id);
    }

    private void SetNewName(int id){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new name: ");

        var inputName = scanner.nextLine();

        if(inputName == null || inputName.trim().isEmpty()){
            SetNewName(id);
        }
        else
            SetNewPosition(id, inputName);
    }

    private void SetNewPosition(int id, String newName){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new position :");

        var inputPosition = scanner.nextLine();

        if(inputPosition == null || inputPosition.trim().isEmpty())
            SetNewPosition(id, newName);
        else{
            UpdateEmployee(id, newName, inputPosition);
        }
    }

    private void UpdateEmployee(int employeeId, String newName, String newPosition){
        EmployeeRepository.getInstance().getUserList().set(employeeId - 1, new User(){{
            Name = newName;
            Position = newPosition;
        }});

        System.out.println("Successfully update employee Name : " + newName + " with new Position " + newPosition);

        MenuPageViewer.getInstance().DisplayMainPrompt();
    }
}
