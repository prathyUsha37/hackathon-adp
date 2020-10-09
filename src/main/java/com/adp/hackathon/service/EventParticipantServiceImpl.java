package com.adp.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adp.hackathon.model.EventParticipant;


@Repository
public class EventParticipantServiceImpl implements EventParticipantService{

	@Override
	public boolean joinEvent(EventParticipant eventParticipant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean leftEvent(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EventParticipant> getParticipants(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EventParticipant> getEvents(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
