package com.adp.hackathon.dao;

import java.util.List;
import javax.transaction.Transactional;
import com.adp.hackathon.model.Event;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.adp.hackathon.HibernateUtil;



@Repository
@Service
public class EventDAOImpl implements EventDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(EventDAOImpl.class);
	
	@Transactional
	@Override
	public Event createEvent(Event e) {
		//e.setId(null);
		Long Id = null;        
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            Id=(Long) sessionObj.save(e);
            //Perform Some Operation Here
            transObj.commit();
            System.out.println("commited");
        } catch (HibernateException exObj) {
            if(transObj!=null){
                transObj.rollback();
            }
            exObj.printStackTrace(); 
        } finally {
            sessionObj.close(); 
        }
        e.setId(Id);
		logger.info("Event saved successfully, Event Details="+e);
		return e;
	}

	
	@Transactional
	@Override
	public void updateEvent(Event e) {
		
		 Transaction transObj = null;
	        Session sessionObj = null;
	        try {
	            sessionObj = HibernateUtil.getSessionFactory().openSession();
	            transObj = sessionObj.beginTransaction();
	            sessionObj.update(e);
	            //Perform Some Operation Here
	            transObj.commit();
	            System.out.println("commited");
	        } catch (HibernateException exObj) {
	            if(transObj!=null){
	                transObj.rollback();
	            }
	            exObj.printStackTrace(); 
	        } finally {
	            sessionObj.close(); 
	        }
		logger.info("Event updated successfully, Event Details="+ e);
	}

	
	@Transactional
	@Override
	public List<Event> listEvents() {
		Transaction transObj = null;
        Session sessionObj = null;
        List<Event> events=null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            String query="from Event e";
            Query<Event> qry = sessionObj.createQuery(query);
            events =qry.list();
            //Perform Some Operation Here
            transObj.commit();
            System.out.println("commited");
        } catch (HibernateException exObj) {
            if(transObj!=null){
                transObj.rollback();
            }
            exObj.printStackTrace(); 
        } finally {
            sessionObj.close(); 
        }
		logger.info("Event, Event Details=");
		return events;
	}

	
	@Transactional
	@Override
	public Event getEventById(Long id) {
		Event Event=null;
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            Event = sessionObj.get(Event.class, id);
            //Perform Some Operation Here
            transObj.commit();
            System.out.println("commited");
        } catch (HibernateException exObj) {
            if(transObj!=null){
                transObj.rollback();
            }
            exObj.printStackTrace(); 
        } finally {
            sessionObj.close(); 
        }
	     logger.info("Event loaded by Id successfully, Event details="+Event);
	     return Event;
	}

	
	@Transactional
	@Override
	public void removeEvent(Long id) {
//		Session session = this.sessionFactory.getCurrentSession();
//		Event e = session.get(Event.class, id);
//		session.delete(e);
//		logger.info("Event deleted successfully, Event details="+e);	
	
	}

	
	@Transactional
	@Override
	public boolean isIdExists(Long id) {
		Event Event=null;
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            Event = sessionObj.get(Event.class, id);
            //Perform Some Operation Here
            transObj.commit();
            System.out.println("commited");
        } catch (HibernateException exObj) {
            if(transObj!=null){
                transObj.rollback();
            }
            exObj.printStackTrace(); 
        } finally {
            sessionObj.close(); 
        }
		
		logger.info("Event: is Id "+ id+" exists, Event details="+Event);	
		if(null != Event){
		return true;
		}
    	return false;
	}

	


	

	@Override
	public List<Event> getEventByKeyword(String keyword) {
		Transaction transObj = null;
        Session sessionObj = null;
        List<Event> events=null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            @SuppressWarnings("unchecked")
			Query<Event> qruey = sessionObj.createQuery("From Event as e where e.topic like :sf");
            qruey.setString("sf",'%'+keyword+'%');
            events =qruey.list();
            //Perform Some Operation Here
            transObj.commit();
            System.out.println("commited");
        } catch (HibernateException exObj) {
            if(transObj!=null){
                transObj.rollback();
            }
            exObj.printStackTrace(); 
        } finally {
            sessionObj.close(); 
        }
		logger.info("Event, Event Details=");
		return events;
	}


	@Override
	public List<Event> getEventSUpcoming() {
		Transaction transObj = null;
        Session sessionObj = null;
        List<Event> events=null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            String query="from Event e";
            Query<Event> qry = sessionObj.createQuery(query);
            events =qry.list();
            //Perform Some Operation Here
            transObj.commit();
            System.out.println("commited");
        } catch (HibernateException exObj) {
            if(transObj!=null){
                transObj.rollback();
            }
            exObj.printStackTrace(); 
        } finally {
            sessionObj.close(); 
        }
		logger.info("Event, Event Details=");
		return events;
	}
}

