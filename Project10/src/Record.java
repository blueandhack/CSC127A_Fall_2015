/* Section Letter: B
 *
 * CSc 127A Fall 15, Project 10
 *
 * Author:  Yujia Lin
 * SL Name: David Lamparter
 *
 * ---
 * The file is class for record.
 * named three attributes for the class.
 * We rewrite toString method for return all values.
 */

public class Record {
	// named three attributes
	private String lastName;
	private String firstName;
	private int age;

	// get method for lastName
	public String getLastName() {
		return lastName;
	}

	// set method for lastName
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// get method for firstName
	public String getFirstName() {
		return firstName;
	}

	// set method for firstName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// get method for age
	public int getAge() {
		return age;
	}

	// set method for age
	public void setAge(int age) {
		this.age = age;
	}

	// constructor method generates objects
	public Record(String lastName, String firstName, int age) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}

	// rewrite toString method
	@Override
	public String toString() {
		return lastName + " " + firstName + " " + age;
	}

}
