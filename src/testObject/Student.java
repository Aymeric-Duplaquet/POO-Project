package testObject;

public class Student {
	
	public String nom;
	private String prenom;
	private int age;


	
	public Student() {
		super();
		this.nom="Franck";
		this.prenom="Henry";
		this.age=18;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}


}
