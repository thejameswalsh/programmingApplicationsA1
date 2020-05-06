import java.util.*;

// - add student
// - remove student
// - view students
// - login
public class University {
	private LinkedList<Student> students = new LinkedList<Student>();
	private LinkedList<Subject> subjects = new LinkedList<Subject>(); 
	
	
		// write your solution here
	public static void main(String[] args)
	{		
		
		
		University myUni = new University();
		myUni.use();
	}
	
	public void University(){
		
	}
	
	public  void use()
	{
		Subject subject1 = new Subject(48024,"Applications Programming");
		subject1.addActivity("Lec1",1,"Wed","CB11.00.405",18,1,200);
		subject1.addActivity("Cmp1",1,"Wed","CB11.B1.403",19,2,2);
		subject1.addActivity("Cmp1",2,"Wed","CB11.B1.401",19,2,2);
		subject1.addActivity("Cmp1",3,"Wed","CB11.B1.402",19,2,2);
		
		this.subjects.add(subject1);
		
		Subject subject2 = new Subject(31284,"Web Services Development");
		subject2.addActivity("Lec1",1,"Tue","CB02.03.002",16,1,160);
		subject2.addActivity("Cmp1",1,"Tue","CB11.B1.102",9,2,30);
		subject2.addActivity("Cmp1",2,"Tue","CB11.B1.103",9,2,30);
		subject2.addActivity("Cmp1",3,"Tue","CB11.B1.102",14,2,30);
		subject2.addActivity("Cmp1",4,"Tue","CB11.B1.103",14,2,30);
		
		this.subjects.add(subject2);
		menu();
	}
	
	public  void menu()
	{
		while(true){
			System.out.print("Choice (a/r/v/l/x): ");
			String in = In.nextLine();
			switch(in)
			{
				case "a":
					add();
					break;
				case "r":
					remove();
					break;
				case "v":
					view();
					break;
				case "l":
					login();
					break;
				case "?":
					help();
					break;
				case "x":
					System.out.println("Done");
					return;		
				default:
					help();
					break;
			}
		}
	}
	
	public  void add(){
		//get number
		int studentNum = getNumber();
		//check is number exists
		for (Student student : students){
			if(student.getNum() == studentNum){
				System.out.println("Student number already exists");
				return;
			}
		}
		
		String studentName = getName();
				
		this.students.add(new Student(studentNum, studentName, this.subjects));
	}
	
	public  void remove(){
		LinkedList<Activity> Activities = new LinkedList<Activity>();
		//get number		
		int studentNum = getNumber();
		//check is number exists
		for (Student student : students){
			if(student.getNum() == studentNum){
				//System.out.println("Student number already exists");
				Activities = student.getActivities();
				
				for(Activity activity :  Activities){
					activity.unenroll();
				}
				
				students.remove(student);
				return;
			}
		}
		System.out.println("No such student");
	}
	
	public  void view(){
		for (Student student : students){
			System.out.println(student.toString());
		}
	}
	
	public  void login(){
		//get number
		int studentNum = getNumber();
		//check is number exists
		for (Student student : students){
			if(student.getNum() == studentNum){
				//System.out.println("Student number already exists");
				student.menu();
				return;
			}
		}
		System.out.println("No such student");
	}
	
	public  void help()
	{
		System.out.println("University menu options");
		System.out.println("a = add a student");
		System.out.println("r = remove a student");
		System.out.println("v = view all students");
		System.out.println("l = login");
		System.out.println("x = exit");
	}
	
	private int getNumber()
	{
		System.out.print("Number: ");
		return In.nextInt();
	}
	
	private String getName()
	{
		System.out.print("Name: ");
		return In.nextLine();
	}
	
	
}