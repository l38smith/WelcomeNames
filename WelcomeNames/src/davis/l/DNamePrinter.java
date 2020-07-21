package davis.l;

import java.util.List;


public class DNamePrinter {

	public void print(List<DNames> names) {
		System.out.printf(" \nNAMES\n");
		System.out.printf("\nID                        FIRST NAME                          LAST NAME\n");
		System.out.printf("==================     =========================           ===========================\n");
		names.forEach(n
				-> System.out.printf (
						"%d\t                 %s\t                       %s\n",
						
						n.getId(),
						n.getFirstName(),
						n.getLastName())
				     );
 }	
}		
					
		
		