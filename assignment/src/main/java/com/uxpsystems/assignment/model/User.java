package com.uxpsystems.assignment.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "userName"))
public class User {

    @Id
 //   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String password;
    private UserStatus status;

   
    public User() {
    }

    public User(Long id, String userName, String password, UserStatus status) {
    	this.id = id;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + "*********" + '\'' +
                ", status='" + status +
                '}';
    }
}

/*
 * package com.uxpsystems.assignment.controller;
 * 
 * import javax.persistence.Entity; import javax.persistence.Id;
 * 
 * @Entity public class User {
 * 
 * @Id private Long id; private String name; private String password; private
 * Enum<UserStatus> status;
 * 
 * public Long getId() { return id; }
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * 
 * public Enum<UserStatus> getStatus() { return status; }
 * 
 * public void setStatus(Enum<UserStatus> status) { this.status = status; }
 * 
 * public User(Long id, String name, String password, Enum<UserStatus> status) {
 * super(); this.id = id; this.name = name; this.password = password;
 * this.status = status; }
 * 
 * public User() { super(); }
 * 
 * }
 */