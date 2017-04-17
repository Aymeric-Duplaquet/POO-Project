package model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;

public class InterfaceObjet {
	
	ArrayList<Champ> listChamp;
	Object myObject;
	Hashtable<String, Boolean> isPrivate;
	
	public InterfaceObjet(Object toRead) throws NoSuchMethodException, SecurityException
	{
		if(toRead != null)
		{
	
			myObject = toRead;
			listChamp = new ArrayList<Champ>();
			isPrivate = new Hashtable<>();
			
			//It�ration sur tous les champs publiques
			Class<?> myClass = myObject.getClass();
			Field[] pubField = myClass.getFields();
			for(int i = 0;i<pubField.length;i++)
			{
				if(false == java.lang.reflect.Modifier.isStatic(pubField[i].getModifiers()))
				{
					addField(new Champ(pubField[i].getType(), pubField[i].getName(), true),false);
					System.out.println(pubField[i].getName());
				}
				
			}
			
			//Recherche d'�ventuels getteur et setteur
			Method[] pubMeht = myClass.getMethods();
			for(int i = 0;i<pubField.length;i++)
			{
				Method cur = pubMeht[i];
				if(false == java.lang.reflect.Modifier.isStatic(cur.getModifiers()) && cur.getName().startsWith("get"))
				{
					
					String nomChamp = cur.getName().substring(3);
					if(GetChamp(nomChamp) == null)
					{
						Class<?> type = cur.getReturnType();
						boolean modifiable = false;
						try
						{
							Method set = myObject.getClass().getMethod("set"+nomChamp, type);
							if(set !=null && false == java.lang.reflect.Modifier.isStatic(cur.getModifiers()))
							{
								modifiable = true;
							}
							
						}catch(NoSuchMethodException e )
						{
							modifiable = false;
						}
						addField(new Champ(type, nomChamp, modifiable),true);
					}
				}
			}
			
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
	
	static public InterfaceObjet test() throws NoSuchMethodException, SecurityException
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
		
		
		InterfaceObjet temp = new InterfaceObjet(new TestPubField(42,true,41.0f,(short)10,120000,(byte) 18,'a',"bonjour",20.0d));

		//InterfaceObjet temp = new InterfaceObjet(new Integer(5));
		
		return temp;
	}

	public ArrayList<Champ> getListChamp() {
		return listChamp;
	}
	
	public Object getValeurChamp(Champ c) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		return getValeurChamp(c.getNom());
	}
	
	public Object getValeurChamp(String champNom) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		if(isPrivate.get(champNom) == false)
		{
			Field t = myObject.getClass().getField(champNom);
			return t.get(myObject);
		}
		else
		{
			String getteurName = "get"+champNom;
			Method temp =  myObject.getClass().getMethod(getteurName, null);
			if(temp != null)
			{
				return temp.invoke(myObject, null);
			}
			throw new SecurityException();
		}
	}
	
	public void setValeurChamp(String champNom,Object in) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		Champ c = GetChamp(champNom);
		if(isPrivate.get(champNom) == false)
		{
			Field t = myObject.getClass().getField(champNom);
			t.set(myObject, in);
		}
		else if(c.modifiable == true)
		{
			try
			{
				Method setteur = myObject.getClass().getMethod("set"+c.nom, c.type);
				setteur.invoke(myObject, in);
			}
			catch(NoSuchMethodException e)
			{
				throw new SecurityException();
			}
			
			
		}
	}
	
}
