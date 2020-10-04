package com.adp.hackathon.model;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long employeeId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable=false)
	private String email;
	
	@Column( nullable = false)
	private String type;
	
	private String image;
	
	@Column( nullable = false)
	private String favourites;
	
	@Column( nullable = false)
	private String password;

	public Long getId() {
		return employeeId;
	}

	public void setId(Long id) {
		this.employeeId = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFavourites() {
		return favourites;
	}

	public void setFavourites(String favourites) {
		this.favourites = favourites;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + employeeId + ", name=" + name + ", email=" + email + ", type=" + type + ", image=" + image
				+ ", favourites=" + favourites + ", password=" + password + "]";
	}
	
}
