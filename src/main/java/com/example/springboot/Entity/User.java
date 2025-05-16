package com.example.springboot.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String Fullname;
	
	@Column(nullable=false)
	private String password;
	
	private String gender;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	private String phonenumber;
	
	private String dateofbirth;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	public User() {
		super();
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", Fullname=" + Fullname + ", password=" + password + ", gender=" + gender
				+ ", email=" + email + ", phonenumber=" + phonenumber + ", dateofbirth=" + dateofbirth + ", role="
				+ role + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
    

	public User(Long id, String fullname, String password, String gender, String email, String phonenumber,
			String dateofbirth, Role role) {
		super();
		this.id = id;
		Fullname = fullname;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.phonenumber = phonenumber;
		this.dateofbirth = dateofbirth;
		this.role = role;
	}


}
