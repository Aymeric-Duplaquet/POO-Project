package model;

import java.util.ArrayList;

public class InterfaceObjet {
	
	ArrayList<Champ> listChamp = new ArrayList<Champ>();
	
	public InterfaceObjet(Object toRead)
	{
		
	}
	
	static public InterfaceObjet test()
	{
		InterfaceObjet ret = new InterfaceObjet(null);
		Champ temp = new Champ(Integer.class, "Test", new Integer(5));
		ret.listChamp.add(temp);
		Champ temp2 = new Champ(Double.class, "Test2", new Double(52.0d));
		ret.listChamp.add(temp2);
		Champ temp3 = new Champ(Boolean.class, "Test3", new Boolean(true));
		ret.listChamp.add(temp3);
		Champ temp4 = new Champ(Short.class, "Test4", new Short((short)54));
		ret.listChamp.add(temp4);
		Champ temp5 = new Champ(Long.class, "Test5", new Long(55L));
		ret.listChamp.add(temp5);
		Champ temp6 = new Champ(Float.class, "Test6", new Float(56.0f));
		ret.listChamp.add(temp6);
		Champ temp7 = new Champ(String.class, "Test7", new String("Liste"));
		ret.listChamp.add(temp7);
		Champ temp8 = new Champ(Byte.class, "Test8", new Byte((byte) 58));
		ret.listChamp.add(temp8);
		Champ temp9 = new Champ(Character.class, "Test9", new Character('a') );
		ret.listChamp.add(temp9);
		return ret;
	}

	public ArrayList<Champ> getListChamp() {
		return listChamp;
	}
	
}
