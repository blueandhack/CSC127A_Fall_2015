
public class Voter {
	private String name;
	private String preferences[];
	private String candidates[];

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getPreferences() {
		return preferences;
	}

	public void setPreferences(String[] preferences) {
		this.preferences = preferences;
	}

	public String[] getCandidates() {
		return candidates;
	}

	public void setCandidates(String[] candidates) {
		this.candidates = candidates;
	}

	public Voter(String name, String[] preferences, String[] candidates) {
		super();
		this.name = name;
		this.preferences = new String[5];
		this.candidates = new String[candidates.length];
		for (int i = 0; i < preferences.length; i++) {
			this.preferences[i] = preferences[i];
		}
		for (int i = 0; i < candidates.length; i++) {
			this.candidates[i] = candidates[i];
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

	public int vote() {
		for (int i = 0; i < preferences.length; i++) {
			for (int j = 0; j < candidates.length; j++) {
				if (candidates[j].equals(preferences[i])) {
					String a = this.name + " votes for " + this.preferences[i];
					System.out.println(a);
					return j;
				}
			}
		}
		String b = this.name + " chooses not to vote.";
		System.out.println(b);
		return -1;

	}

}
