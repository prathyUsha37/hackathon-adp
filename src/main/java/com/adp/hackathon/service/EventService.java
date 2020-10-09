package com.adp.hackathon.service;
import java.util.List;

import com.adp.hackathon.model.Event;

public interface EventService{
	public Event createEvent(Event event);
	public void updateEvent(Event event);
	public List<Event> listEvents();
	public List<Event> getEventByKeyword(String keyword);
	public List<Event> getEventSUpcoming();
	public Event getEventById(Long id);
	public boolean removeEvent(Long id);
}
