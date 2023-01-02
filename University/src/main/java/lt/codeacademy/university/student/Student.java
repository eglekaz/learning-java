package lt.codeacademy.university.student;

import org.springframework.lang.NonNull;

import jakarta.persistence.*;

@Entity
@Table(name="Students")
public class Student{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NonNull
    @Column(name = "name")
    private String name;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "phoneNum")
    private String phoneNum;

	public Student() {}

	public Student(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNumber;
	}

	public Student(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNumber) {
		this.phoneNum = phoneNumber;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNum + "]";
	}

	
	
	
}
