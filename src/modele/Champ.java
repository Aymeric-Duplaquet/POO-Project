package modele;

public class Champ {
	
	Class<?> type;
	String nom;
	boolean modifiable;
	
	public Champ(Class<?> type, String nom,boolean modifiableIn) {
		this.type = type;
		this.nom = nom;
		this.modifiable = modifiableIn;
	}	
	
	public Class<?> getType() {
		return type;
	}
	public String getNom() {
		return nom;
	}
	
	public boolean getModifiable()
	{
		return modifiable;
	}

}
