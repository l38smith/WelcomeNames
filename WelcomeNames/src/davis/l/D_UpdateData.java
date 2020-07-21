package davis.l;

import java.util.Scanner;

public class D_UpdateData {

    public void updateRecord() throws Exception {

        Scanner scanner
            = new Scanner(System.in);

        DNamePath namePath = new DNamePath();
        DNameHandler nameHandler = new DNameHandler(namePath);
        DNamePrinter namePrinter = new DNamePrinter();

        namePrinter.print(
            nameHandler.findNames());

        Long id = null;
        String ud = null;

       
        boolean keepAsking = true;
        while (keepAsking) {
            System.out.println("Enter ID to update: (\".\" when done):");
            ud = scanner.nextLine();
            ud = ud.trim();
            
            if (ud.isEmpty() || ud.contains("[a-zA-Z]+")) {
            } 
           
         else
           if ((".").equals(ud)) {
              
            keepAsking = false;
            DGoodBye g = new DGoodBye();
            g.bye();
               
            }
      
           else {    
           id = Long.parseLong(ud);  
           boolean keepAskingNewName = true;
           String userinput = "";
           while (keepAskingNewName) {

                   
           System.out.printf("Enter updated name: %n");

           userinput = scanner.nextLine();
                
           userinput = userinput.trim();
           if (userinput.isEmpty() || userinput.matches("[0-9]+")) {
                        
                    } else {
                        keepAskingNewName = false;
                    }
                }
                    
           String tokens[] = userinput.split(" ");
           String firstName = tokens[0];
              
           String lastName = "";
           if (tokens.length >= 2) {
           lastName = tokens[1];
              
                }
                     
           int updateCount = nameHandler.update(id, firstName, lastName);
     
           updateCount = nameHandler.update(id, firstName, lastName);
                
           if (updateCount <= 0) {
           System.out.printf(" > FAIL! ID = %d not found%n", id);
           } else if (updateCount > 0) {
           System.out.printf("> Updated !  ID = %d%n", id);
              
        }
       }    
      }
     } 
    }
