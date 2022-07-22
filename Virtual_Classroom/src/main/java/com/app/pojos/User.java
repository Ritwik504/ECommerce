package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="users")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User extends BaseEntity{
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String email;
	@Column(length = 30)
	private String pass;
	private int rollno;
	@Column(length = 30)
	private String batch;
	private String message;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", pass=" + pass + ", rollno=" + rollno + ", batch=" + batch
				+ ", message=" + message + "]";
	}

	
	
}
