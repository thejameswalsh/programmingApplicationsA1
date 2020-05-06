import java.util.*;

public class Subject {
		// write your solution here
	private int subjectNumber;
	private String subjectName;
	
	private LinkedList<Activity> activities = new LinkedList<Activity>(); 
	
	public Subject(int number, String name){
		this.subjectNumber = number;
		this.subjectName = name;
	}
	
	public void addActivity(String type, int num, String day, String room, 
						   int hour, int duration, int size){
		this.activities.add(new Activity(this.subjectNumber, type, num, day, room, 
						   hour, duration, size));
	}
	
	public String toString(){
		return subjectNumber+" "+subjectName;
	}
	
	public int getSubjectNum(){
		return this.subjectNumber;
	}
	
	public Activity selectActivity(){
		System.out.println("Select an activity");
		for(Activity activity : activities){
			System.out.println(activity.toString());
		}
		System.out.print("Activity code (group:activity): ");
		String input = In.nextLine();
		
		for(Activity activity : activities){
			if(activity.getCode().equals(input)){
				
				return activity;
			}
		}
		
		if(input.length() == 4){
			for(Activity activity : activities){
				if(activity.getCode().substring(0,4).equals(input)){
					if(activity.getSeats() != 0){
						
						return activity;
					}
				}
			}
			return new Activity(0," ",0," "," ",100,100,100);
		}
		
		return new Activity(0," ",0," "," ",10,10,10);
	}
}