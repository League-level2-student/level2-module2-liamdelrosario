package _04_animals_inheritance;

public class Animals {
	String name;
	String furColor;
	Boolean isGirl;
	Animals(String name, String furColor, Boolean isGirl){
		this.name=name;
		this.furColor=furColor;
		this.isGirl=isGirl;
	}
	public void printName(){
		System.out.println("The pets name is "+name);
	}
	public void eat() {
		System.out.println("Eating");
	}
	public void sleep() {
		System.out.println("Sleeping");
	}
	public void play() {
		System.out.println("Playing");
	}
}
