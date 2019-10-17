package elements;

public abstract class Element {

	protected String name;
	protected String identity;
	
	public void displayIdentity() {
		System.out.print(this.identity);
	}
}
