package model;

public class Champ {
	
	Class<?> type;
	String nom;
	Object valeur;
	
	
	public Champ(Class<?> type, String nom, Object valeur) {
		this.type = type;
		this.nom = nom;
		this.valeur = valeur;
	}	
	
	public Object getValeur() {
		return valeur;
	}
	public void setValeur(Object valeur) {
		this.valeur = valeur;
	}
	public Class<?> getType() {
		return type;
	}
	public String getNom() {
		return nom;
	}

}
