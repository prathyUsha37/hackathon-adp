package com.adp.hackathon.dao;

import java.util.List;

import com.adp.hackathon.model.EventParticipant;

public interface EventParticipantDAO {
	// user joins event
		public boolean joinEvent(EventParticipant eventParticipant);
		
		//user left the event using eventparticipant id
		public boolean leftEvent(Long id);
		
		//get event participants using eventid
		public List<EventParticipant> getParticipants(Long id);
		
		// get events user participated in using userid
		public List<EventParticipant> getEvents(Long id);
}
