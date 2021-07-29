package practice.demo;

public class StudentDAO {
	
	private static Students list = new Students();
	
	static
    {
        list.getStudentList().add(new Student(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getStudentList().add(new Student(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getStudentList().add(new Student(3, "David", "Kameron", "titanic@gmail.com"));
    }

	public Students getStudents() {
		// TODO Auto-generated method stub
		return list;
	}

	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		list.getStudentList().add(student);
		
	}



}
