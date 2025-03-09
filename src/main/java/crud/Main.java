import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Add employee\n2. View employee\n3. Update employee\n4. Remove employee\n5. Exit");
        System.out.print("Enter your choice: ");

        String input = scanner.nextLine();

        try{
            if(Integer.parseInt(input) <= 5 && Integer.parseInt(input) > 0){
                System.out.println("Your input is " + input);
            }
            else{
                System.err.println("Not Valid input");
            }
        }
        catch(NumberFormatException exception){
            System.err.println("Not Valid input");
        }
        
    }
}
