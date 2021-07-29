package practice.demo;

import java.util.Map;

public class Student {
	
	private Integer id;
    private String firstName;
    private String lastName;
    private String email;
	
	public Student() {
		 
    }
	
	public Student(Integer id, String firstName, String lastName, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
	
	 @Override
	    public String toString() {
	        return "Student [id=" + id + ", firstName=" + firstName + ",  lastName=" + lastName + ", email=" + email + "]";
	    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



}
