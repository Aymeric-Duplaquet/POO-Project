package model;

public class TestPubField {
	public int heyaInt;
	public boolean heyaBoolean;
	public float heyaFloat;
	public short heyaShort;
	public long heyaLong;
	public byte heyaByte;
	public char heyaChar;
	public String heyaString;
	public double heyaDouble;
	
	private int heyaIntP;
	private boolean heyaBooleanP;
	private float heyaFloatP;
	private short heyaShortP;
	private long heyaLongP;
	private byte heyaByteP;
	private char heyaCharP;
	private String heyaStringP;
	private double heyaDoubleP;
	
	private int heyaIntSP;
	private boolean heyaBooleanSP;
	private float heyaFloatSP;
	private short heyaShortSP;
	private long heyaLongSP;
	private byte heyaByteSP;
	private char heyaCharSP;
	private String heyaStringSP;
	private double heyaDoubleSP;
	
	public TestPubField(int heyaInt, boolean heyaBoolean,float heyaFloat,short heyaShort,long heyaLong,byte heyaByte, char heyaChar, String heyaString, double heyaDouble) {
		super();
		this.heyaInt = heyaInt;
		this.heyaBoolean = heyaBoolean;
		this.heyaFloat = heyaFloat;
		this.heyaShort=heyaShort;
		this.heyaLong=heyaLong;
		this.heyaByte=heyaByte;
		this.heyaChar=heyaChar;
		this.heyaString=heyaString;
		this.heyaDouble=heyaDouble;
		
		heyaIntP=1;
		heyaBooleanP=false;
		heyaFloatP=4.3f;
		heyaShortP=25;
		heyaLongP=250;
		heyaByteP=3;
		heyaCharP='h';
		heyaStringP="Without Set";
		heyaDoubleP=68d;
		
		heyaIntSP=1;
		heyaBooleanSP=false;
		heyaFloatSP=4.3f;
		heyaShortSP=25;
		heyaLongSP=250;
		heyaByteSP=3;
		heyaCharSP='h';
		heyaStringSP="Without Set";
		heyaDoubleSP=68d;
		
	}

	public int getHeyaIntP() {
		return heyaIntP;
	}

	public float getHeyaFloatP() {
		return heyaFloatP;
	}

	public short getHeyaShortP() {
		return heyaShortP;
	}

	public long getHeyaLongP() {
		return heyaLongP;
	}

	public byte getHeyaByteP() {
		return heyaByteP;
	}

	public char getHeyaCharP() {
		return heyaCharP;
	}

	public String getHeyaStringP() {
		return heyaStringP;
	}

	public double getHeyaDoubleP() {
		return heyaDoubleP;
	}

	public boolean getHeyaBooleanP() {
		return heyaBooleanP;
	}


	
	

	public boolean getHeyaBooleanSP() {
		return heyaBooleanSP;
	}

	public void setHeyaBooleanSP(boolean heyaBooleanSP) {
		this.heyaBooleanSP = heyaBooleanSP;
	}

	public int getHeyaIntSP() {
		return heyaIntSP;
	}

	public void setHeyaIntSP(int heyaIntSP) {
		this.heyaIntSP = heyaIntSP;
	}

	public float getHeyaFloatSP() {
		return heyaFloatSP;
	}

	public void setHeyaFloatSP(float heyaFloatSP) {
		this.heyaFloatSP = heyaFloatSP;
	}

	public short getHeyaShortSP() {
		return heyaShortSP;
	}

	public void setHeyaShortSP(short heyaShortSP) {
		this.heyaShortSP = heyaShortSP;
	}

	public long getHeyaLongSP() {
		return heyaLongSP;
	}

	public void setHeyaLongSP(long heyaLongSP) {
		this.heyaLongSP = heyaLongSP;
	}

	public byte getHeyaByteSP() {
		return heyaByteSP;
	}

	public void setHeyaByteSP(byte heyaByteSP) {
		this.heyaByteSP = heyaByteSP;
	}

	public char getHeyaCharSP() {
		return heyaCharSP;
	}

	public void setHeyaCharSP(char heyaCharSP) {
		this.heyaCharSP = heyaCharSP;
	}

	public String getHeyaStringSP() {
		return heyaStringSP;
	}

	public void setHeyaStringSP(String heyaStringSP) {
		this.heyaStringSP = heyaStringSP;
	}

	public double getHeyaDoubleSP() {
		return heyaDoubleSP;
	}

	public void setHeyaDoubleSP(double heyaDoubleSP) {
		this.heyaDoubleSP = heyaDoubleSP;
	}
	
}
