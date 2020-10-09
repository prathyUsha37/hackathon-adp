package com.adp.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adp.hackathon.dao.EventDAO;
import com.adp.hackathon.model.Event;


@Repository
public class EventServiceImpl implements EventService{

	private EventDAO EventDAO;
	
	@Autowired
	public void setEventDAO(EventDAO EventDAO) {
		this.EventDAO = EventDAO;
	}
	
	@Override
	@Transactional
	public Event createEvent(Event Event) {
			Event employ=this.EventDAO.createEvent(Event);
			return employ;
	}

	@Override
	@Transactional
	public void updateEvent(Event Event) {
			this.EventDAO.updateEvent(Event);
	}
	

	@Override
	@Transactional
	public List<Event> listEvents() {
		return this.EventDAO.listEvents();
	}

	@Override
	@Transactional
	public Event getEventById(Long id) {
		return this.EventDAO.getEventById(id);
	}

	@Override
	@Transactional
	public boolean removeEvent(Long id) {
	if(this.EventDAO.isIdExists(id)) {
		this.EventDAO.removeEvent(id);
		return true;
		}
	return false;
	}


	@Override
	public List<Event> getEventByKeyword(String keyword) {

		return this.EventDAO.getEventByKeyword(keyword);
	}

	@Override
	public List<Event> getEventSUpcoming() {

		return this.EventDAO.getEventSUpcoming();
	
	}

}
