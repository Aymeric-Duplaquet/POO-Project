package model;

import java.util.ArrayList;

public class InterfaceObjet {
	
	ArrayList<Champ> listChamp;
	
	public InterfaceObjet(Object toRead)
	{
		
	}
	
	static public InterfaceObjet test()
	{
		InterfaceObjet ret = new InterfaceObjet(null);
		Champ temp = new Champ(Integer.class, "Test", new Integer(5));
		ret.listChamp.add(temp);
		return ret;
	}

	public ArrayList<Champ> getListChamp() {
		return listChamp;
	}
	
}
