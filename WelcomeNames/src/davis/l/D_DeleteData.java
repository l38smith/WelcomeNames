		  
	package davis.l;
import java.util.Scanner;

public class D_DeleteData {
	
  public void deleteRecord() throws Exception {
		 
   Scanner scanner 
   = new Scanner(System.in);
   DNamePath namePath = new DNamePath () ;
   DNameHandler nameHandler = new DNameHandler(namePath);
   DNamePrinter namePrinter = new DNamePrinter();
	   
	  
   namePrinter.print(
   nameHandler.findNames());	
		  
   Long id = null;
   String dd = null;
   boolean keepAsking = true;
	
   
   while(keepAsking) {
		
System.out.printf("Enter ID to delete: (\".\" when done):");
dd = scanner.nextLine();
dd = dd.trim();

 if ((".").equals(dd)) {
	 
keepAsking = false;
D_UpdateData udData = new D_UpdateData();
udData.updateRecord();  

 }

 else if (! dd.matches("[0-9]+")) {// added
 }

else	{				  
id = Long.parseLong(dd);							
int count = 0;


count = nameHandler.delete(id); 

if (count == 1) {
  System.out.printf("> Deleted !  ID = %d%n", id);
} 
else
if (count == 0) {
  System.out.printf("> FAIL ID %d NOT FOUND%n", id);
}
else {
  System.out.printf("> FAIL multiple accounts deleted (%d). This should never happen %n", count);
					 		 
      }
     }
   }
  }
}
			
							 
			
	  
		      
			 
			  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	
		  
		  
		  
		  
	  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		