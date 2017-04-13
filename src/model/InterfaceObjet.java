package model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;

public class InterfaceObjet {
	
	ArrayList<Champ> listChamp;
	Object myObject;
	Hashtable<String, Boolean> isPrivate;
	
	public InterfaceObjet(Object toRead)
	{
		myObject = toRead;
		listChamp = new ArrayList<Champ>();
		isPrivate = new Hashtable<>();
		
		//Itération sur tous les champs publiques
		Class<?> myClass = myObject.getClass();
		Field[] pubField = myClass.getFields();
		for(int i = 0;i<pubField.length;i++)
		{
			addField(new Champ(pubField[i].getType(), pubField[i].getName(), true),false);
		}
	}
	
	private void addField(Champ inC,boolean mod)
	{
		listChamp.add(inC);
		isPrivate.put(inC.nom, mod);
	}
	
	private Champ GetChamp(String nom)
	{
		for(int i =0;i<listChamp.size();i++)
		{
			if(listChamp.get(i).nom.compareTo(nom) == 0)
			{
				return listChamp.get(i);
			}
		}
		return null;
	}
	
	static public InterfaceObjet test()
	{
		/*InterfaceObjet ret = new InterfaceObjet(null);
		Champ temp = new Champ(Integer.class, "Test",false);
		ret.listChamp.add(temp);
		Champ temp2 = new Champ(Double.class, "Test2",false);
		ret.listChamp.add(temp2);
		Champ temp3 = new Champ(Boolean.class, "Test3",false);
		ret.listChamp.add(temp3);
		Champ temp4 = new Champ(Short.class, "Test4",false);
		ret.listChamp.add(temp4);
		Champ temp5 = new Champ(Long.class, "Test5",false);
		ret.listChamp.add(temp5);
		Champ temp6 = new Champ(Float.class, "Test6",false);
		ret.listChamp.add(temp6);
		Champ temp7 = new Champ(String.class, "Test7",false);
		ret.listChamp.add(temp7);
		Champ temp8 = new Champ(Byte.class, "Test8",false);
		ret.listChamp.add(temp8);
		Champ temp9 = new Champ(Character.class, "Test9",false);
		ret.listChamp.add(temp9);
		return ret;*/
		return new InterfaceObjet(new TestPubField(42,true));
	}

	public ArrayList<Champ> getListChamp() {
		return listChamp;
	}
	
	public Object getValeurChamp(Champ c) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		return getValeurChamp(c.getNom());
	}
	
	public Object getValeurChamp(String champNom) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		if(isPrivate.get(champNom) == false)
		{
			Field t = myObject.getClass().getField(champNom);
			return t.get(myObject);
		}
		else
		{
			throw new SecurityException();
		}
	}
	
	public void setValeurChamp(String champNom,Object in)
	{
		
	}
	
}
