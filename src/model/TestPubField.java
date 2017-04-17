package model;

public class TestPubField {
	public int heyaInt;
	public boolean isHeya;
	public float heyaFloat;
	public short heyaShort;
	public long heyaLong;
	public byte heyaByte;
	public char heyaChar;
	public String heyaString;
	public double heyaDouble;
	
	private float iAmPrivate;
	
	public TestPubField(int heyaInt, boolean isHeya,float heyaFloat,short heyaShort,long heyaLong,byte heyaByte, char heyaChar, String heyaString, double heyaDouble) {
		super();
		this.heyaInt = heyaInt;
		this.isHeya = isHeya;
		this.heyaFloat = heyaFloat;
		this.heyaShort=heyaShort;
		this.heyaLong=heyaLong;
		this.heyaByte=heyaByte;
		this.heyaChar=heyaChar;
		this.heyaString=heyaString;
		this.heyaDouble=heyaDouble;
		iAmPrivate = 4.3f;
	}

	public float getiAmPrivate() {
		return iAmPrivate;
	}

	public void setiAmPrivate(float iAmPrivate) {
		this.iAmPrivate = iAmPrivate;
	}
	
	
	
}
