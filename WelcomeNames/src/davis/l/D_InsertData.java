package davis.l;

import java.util.Scanner;

public class D_InsertData {

    public static void main(String[] args) throws Exception {

        System.out.printf("Welcome to Name database!\n\n");
        Scanner scanner
            = new Scanner(System.in);

        DNamePath namePath = new DNamePath();
        DNameHandler nameHandler = new DNameHandler(namePath);

        DNamePrinter namePrinter = new DNamePrinter();

        namePrinter.print(
            nameHandler.findNames());

        boolean keepAsking = true;
        while (keepAsking) {

            String firstName = " ";
            String lastName = " ";
            System.out.print("Enter first and last name (\".\"when done):");

            String userinput = scanner.nextLine();
            userinput = userinput.trim();

          
            if (userinput.isEmpty() || userinput.matches("[0-9]+")) {
            	  
            } else if (userinput.equals(".")) {                
               
                keepAsking = false;
                
               
                D_DeleteData delDat = new D_DeleteData();
                delDat.deleteRecord();
            } else {
                
                DNames newName = new DNames();
                
                String tokens[] = userinput.split(" ");

                firstName = tokens[0];
                
                if (tokens.length >= 2) {
                    lastName = tokens[1];
                }

                System.out.printf("firstName = \"%s\"%n", firstName);
                System.out.printf("lastName = \"%s\"%n", lastName);

              
                newName = new DNames();
                newName.setFirstName(firstName);
                newName.setLastName(lastName);
                
                nameHandler.insert(newName);

               
                System.out.printf(" > Inserted! ID=%d%n", newName.getId());
            }
        }
    }
}
