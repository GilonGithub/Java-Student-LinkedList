import java.util.Objects;

public class Student {
	int id;
	String email;
	String fullName;
	
	public Student(int id, String email, String fullName) {
		setID(id);
		setEmail(email);
		setFullName(fullName);
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = Objects.isNull(id) || id < 0 ? ((int) (Math.random() * 1000) + 1) : id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = Objects.isNull(email) || email.isEmpty() ? "Unknown" : email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = Objects.isNull(fullName) || fullName.isEmpty() ? "Unknown" : fullName;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d"
							+ "\nEmail: %s"
							+ "\nName: %s\n", id, email, fullName);
	}
}
