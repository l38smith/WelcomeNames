package davis.l;


public class DGoodBye {
	
	public void  bye() throws Exception{
		
		 DNamePath namePath = new DNamePath () ;
		 DNamePrinter namePrinter = new DNamePrinter();
		 DNameHandler nameHandler = new DNameHandler(namePath);
		 namePrinter.print(
		      nameHandler.findNames());
		
		 System.out.println("\nGood bye!");
		
	}

}

