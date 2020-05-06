import java.util.*;

// view my activities
// enrol
// withdraw
public class Student {
	private LinkedList<Subject> subjects = new LinkedList<Subject>(); 
	private LinkedList<Activity> activities = new LinkedList<Activity>(); 
	
	private String StudentName;
	private int StudentNumber;
		// write your solution here
	public Student(int number,String name, LinkedList<Subject> subjects){
		this.StudentName = name;
		this.StudentNumber = number;
		
		this.subjects = subjects;
		//this.subjects.add(new Subject(48024, "Applications Programming"));
		//this.subjects.add(new Subject(31284, "Web Servces Development"));
	}
	
	public String getName(){
		return this.StudentName;
	}

	public int getNum(){
		return this.StudentNumber;
	}
	
	public String toString(){
		return this.StudentNumber + " " + this.StudentName;
	}
	
	public void menu(){
		while(true){
			System.out.print("Choice (v/e/w/x): ");
			String in = In.nextLine();
			switch(in)
			{
				case "v":
					viewActivities();
					break;
				case "e":
					addActivity();
					break;
				case "w":
					removeActivity();
					break;
				case "?":
					help();
					break;
				case "x":
					//System.out.println("Done");
					return;		
				default:
					help();
					break;
			}
		}
	}
	
	public void removeActivity(){
		System.out.print("Activity code (subject:group): ");
		String input = In.nextLine();
		
		String subjectNum = input.substring(0,5);
		String group = input.substring(6,10);
		int subject = Integer.parseInt(subjectNum);	
		
		for(Activity activity : activities){
			if(activity.getCode().substring(0,4).equals(group)
			  && activity.getNum() == subject){
				activity.unenroll();
				activities.remove(activity);
				return;
			}
		}
		System.out.println("Not enrolled in activity");
		
	}
	
	public void viewActivities(){
		for(Activity activity : activities){
			System.out.println(activity.toString());
		}
	}
	
	public LinkedList<Activity> getActivities(){
		return this.activities;
	}
	
	public void addActivity(){
		System.out.println("Select a subject");
		for(Subject subject : subjects){
			System.out.println(subject.toString());
		}
		System.out.print("Subject number: ");
		int choice = In.nextInt();
		
		for(Subject subject : subjects){
			if(subject.getSubjectNum() == choice){
				Activity activity = subject.selectActivity();
				
				if(activity.getSeats() == 0){
					System.out.println("No available seats");
					return;
				}
				
				for(Activity iActivity : activities){
					if(activity.getCode().substring(0,4).equals(iActivity.getCode().substring(0,4))
					  && iActivity.getNum() == activity.getNum()){
						iActivity.unenroll();
						activities.remove(iActivity);
						break;
					}
				}
				
				if(activity.getNum() == choice){
					activity.enroll();
					activities.add(activity);
					return;
				}
				else if(activity.getSeats() == 100){
					System.out.println("No available seats");
					return;
				}
				else{
					System.out.println("No such activity");
					return;
				}
			}
		}
		System.out.println("No such subject");
	}
	
	public void help(){
		System.out.println("Student menu options");
		System.out.println("v = view my activities");
		System.out.println("e = enrol in an activity");
		System.out.println("w = withdraw from an activity");
		System.out.println("x = exit");
	}
}