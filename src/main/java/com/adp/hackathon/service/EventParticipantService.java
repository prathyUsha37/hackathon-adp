package com.adp.hackathon.service;

import java.util.List;
import com.adp.hackathon.model.EventParticipant;


public interface EventParticipantService{
	public boolean joinEvent(EventParticipant eventParticipant);
	public boolean leftEvent(Long id);
	public List<EventParticipant> getParticipants(Long id);
	public List<EventParticipant> getEvents(Long id);
}
