package com.adp.hackathon.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.adp.hackathon.service.EventService;
import com.adp.hackathon.model.Event;
import java.util.List;





@RestController
@CrossOrigin
public class EventController {	
	
	EventService eventSerive;
	
	
	@Autowired(required=true)
	EventController(EventService eventSerive){
		this.eventSerive=eventSerive;
	}
	
	
	@RequestMapping(value = "/event/create", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public Event createEvent(@RequestBody Event Event) {
		return this.eventSerive.createEvent(Event);
	}


	@RequestMapping(value="/event/remove/{id}", method = RequestMethod.DELETE,
			headers = "Accept=application/json")
	@ResponseBody
    public String removeEvent(@PathVariable("id") Long id){	
        if(this.eventSerive.removeEvent(id)) {
        	return "Event removed";
        }
        return "Invalid request";
    }
 
	
	
    @RequestMapping(value="/event/update",method = RequestMethod.PUT,
			headers = "Accept=application/json")
    public void updateEvent(@RequestBody Event event){
    	this.eventSerive.updateEvent(event);
    }

    
    
    @RequestMapping(value="/event/all",method = RequestMethod.GET,
			headers = "Accept=application/json")
    @ResponseBody
    public List<Event> listEvents(){
    	List<Event> Events= this.eventSerive.listEvents();
        return Events;
    }
	
    
    
    @RequestMapping(value="/event/{id}",method = RequestMethod.GET,
			headers = "Accept=application/json")
    @ResponseBody
    public Event getEvent(@PathVariable("id") Long id){
    	Event Event= this.eventSerive.getEventById(id);
        return Event;
    }
	
    @RequestMapping(value="/event/keyword/{keyword}",method = RequestMethod.GET,
			headers = "Accept=application/json")
    @ResponseBody
    public List<Event> getEventByKeyword(@PathVariable("keyword") String keyword){
        List<Event> events= this.eventSerive.getEventByKeyword(keyword);
        return events;
    }
    
    
    @RequestMapping(value="/event/upcoming",method = RequestMethod.GET,
			headers = "Accept=application/json")
    @ResponseBody
    public List<Event> getEventsUpcoming(){
        List<Event> events= this.eventSerive.getEventSUpcoming();
        return events;
    }

	
}

