public class Activity {
		// write your solution here
	private int subjectNum;
	private String type;
	private int num;
	private String day;
	private String room;
	private int hour;
	private int minute;
	private int duration;
	private int size;
	private int NoStudents;
	
	public Activity(int subjectNum, String type, int num, String day, String room, 
						   int hour, int duration, int size){
		this.subjectNum = subjectNum;
		this.num = num;
		this.type = type;
		this.day = day;
		this.room = room;
		this.hour = hour;
		this.duration = duration;
		this.size = size;
	}
	
	public String toString(){
		return this.subjectNum+" "+
			this.type+" "+
			this.num+" "+
			this.day+" "+
			this.room+" "+
			String.format("%02d",this.hour)+":00 "+
			this.duration+"hrs "+
			this.NoStudents+"/"+this.size;
	}
	
	public String getCode(){
		return this.type+":"+this.num;
	}
	
	public int getNum(){
		return this.subjectNum;
	}
	
	public int getSeats(){
		return this.size - this.NoStudents;
	}
	
	public void enroll(){
		this.NoStudents++;
	}
	
	public void unenroll(){
		this.NoStudents--;
	}
}