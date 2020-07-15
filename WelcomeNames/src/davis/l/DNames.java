package davis.l;
import java.sql.Timestamp;

public class DNames {

	private Long id;
	private String firstName;
	private String lastName;
	
	

	
	 public Long getId() {
	        return id;
	    }

	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString()
   {return getFirstName() + getLastName(); }
}
	     //   return insertCount;
