package com.adp.hackathon.dao;
import java.util.List;
import javax.transaction.Transactional;
import com.adp.hackathon.model.Photo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.adp.hackathon.HibernateUtil;



@Repository
@Service
public class PhotoDAOImpl implements PhotoDAO{
	private static final Logger logger = LoggerFactory.getLogger(PhotoDAOImpl.class);
	
	@Transactional
	@Override
	public Photo createPhoto(Photo e) {
		Long Id = null;        
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            Id=(Long) sessionObj.save(e);
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
		logger.info("Photo saved successfully, Photo Details="+e);
		return e;
	}

	
	@Transactional
	@Override
	public void updatePhoto(Photo e) {
		
		 Transaction transObj = null;
	        Session sessionObj = null;
	        try {
	            sessionObj = HibernateUtil.getSessionFactory().openSession();
	            transObj = sessionObj.beginTransaction();
	            sessionObj.update(e);
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
		logger.info("Photo updated successfully, Photo Details="+ e);
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Photo> getPhotos() {
		
		List<Photo> PhotoList=null;
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
    		PhotoList = sessionObj.createQuery("FROM Photo E ").list();
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
	     logger.info("Photos loaded successfully, Photo details");
	     return PhotoList;
	}

	
	@Transactional
	@Override
	public Photo getPhotoById(Long id) {
		Photo Photo=null;
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            Photo = sessionObj.get(Photo.class, id);
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
	     logger.info("Photo loaded by Id successfully, Photo details="+Photo);
	     return Photo;
	}

	
	
	
	@Transactional
	@Override
	public boolean isIdExists(Long id) {
		Photo Photo=null;
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            Photo = sessionObj.get(Photo.class, id);
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
		
		logger.info("Photo: is Id "+ id+" exists, Photo details="+Photo);	
		if(null != Photo){
		return true;
		}
    	return false;
	}

	
}

