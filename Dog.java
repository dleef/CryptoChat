package prime;

public class Dog {
	private String name;
	private String breed;
	private int age;
	private static String animal = "Dog";
	
	public static void main(String[] args) {
		Dog dansLab = new Dog("Daniel", "Lab", 4);
		Dog marcsPug = new Dog("Marc", "Pug", 7);
		
		System.out.println("Daniel's dog is named " + dansLab.getName());
		System.out.println("Marc's dog is named " + marcsPug.getName());
		
	}
	
	public Dog(String name, String breed, int age) {
		this.name = name;
		this.breed = breed;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getBreed() {
		return this.breed;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public static String getAnimal() {
		return animal;
	}

}
