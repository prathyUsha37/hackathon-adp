package com.adp.hackathon.dao;

import java.util.List;
import com.adp.hackathon.model.Event;


public interface EventDAO {
	public boolean isIdExists(Long id);
	public Event createEvent(Event e);
	public void updateEvent(Event e);
	public List<Event> listEvents();
	public Event getEventById(Long id);
	public void removeEvent(Long id);	

	public List<Event> getEventByKeyword(String keyword);
	public List<Event> getEventSUpcoming();
}
