package com.adp.hackathon.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eventId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String date;
	
	@Column(nullable = false)
	private String time;
	
	@Column( nullable = false)
	private String description;
	
	private String image;
	
	@Column( nullable = false)
	private String link;

	public Long getId() {
		return eventId;
	}

	public void setId(Long id) {
		this.eventId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Event [id=" + eventId + ", name=" + name + ", date=" + date + ", time=" + time + ", description="
				+ description + ", image=" + image + ", link=" + link + "]";
	}
	
	

}
