
public class Voter {
	private String name;
	private String preferences[];

	public Voter(String name, String[] preferences) {
		super();
		this.name = name;
		this.preferences = new String[5];
		for (int i = 0; i < preferences.length; i++) {
			this.preferences[i] = preferences[i];
		}
	}

	public void print() {
		String a = "Voter: name=" + this.name + " preferences: ";
		for (int i = 0; i < preferences.length; i++) {
			a = a + preferences[i] + " ";
		}
		a = a.trim();
		System.out.println(a);
	}

	public void vote() {
		String a = this.name + " votes for " + this.preferences[0];
		System.out.println(a);
	}

}
