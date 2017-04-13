package model;

public class TestPubField {
	public int Heya;
	public boolean isHeya;
	
	private float iAmPrivate;
	
	public TestPubField(int heya, boolean isHeya) {
		super();
		Heya = heya;
		this.isHeya = isHeya;
		iAmPrivate = 4.3f;
	}

	public float getiAmPrivate() {
		return iAmPrivate;
	}

	public void setiAmPrivate(float iAmPrivate) {
		this.iAmPrivate = iAmPrivate;
	}
	
	
	
}
