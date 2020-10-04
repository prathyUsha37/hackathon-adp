package com.adp.hackathon.dao;

import java.util.List;
import javax.transaction.Transactional;
import com.adp.hackathon.model.Employee;
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
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	@Transactional
	@Override
	public Employee createEmployee(Employee e) {
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
		logger.info("Employee saved successfully, Employee Details="+e);
		return e;
	}

	
	@Transactional
	@Override
	public void updateEmployee(Employee e) {
		
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
		logger.info("Employee updated successfully, Employee Details="+ e);
	}

	
	@Transactional
	@Override
	public List<Employee> listEmployees() {
//		Session session = this.sessionFactory.getCurrentSession();
//		@SuppressWarnings("unchecked")
//		List<Employee> employeeList = session.createQuery("FROM Employee E ").list();
//		for(Employee e : employeeList){
//			logger.info("Employee List::"+e);
//		}
//		return employeeList;
		return null;
	}

	
	@Transactional
	@Override
	public Employee getEmployeeById(Long id) {
		Employee employee=null;
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            employee = sessionObj.get(Employee.class, id);
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
	     System.out.println("*****************"+employee.getEmail()+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+id);
	     logger.info("Employee loaded by Id successfully, Employee details="+employee);
	     return employee;
	}

	
	@Transactional
	@Override
	public void removeEmployee(Long id) {
//		Session session = this.sessionFactory.getCurrentSession();
//		Employee e = session.get(Employee.class, id);
//		session.delete(e);
//		logger.info("Employee deleted successfully, Employee details="+e);	
	
	}

	
	@Transactional
	@Override
	public boolean isIdExists(Long id) {
		Employee employee=null;
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            employee = sessionObj.get(Employee.class, id);
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
		
		logger.info("Employee: is Id "+ id+" exists, Employee details="+employee);	
		if(null != employee){
		return true;
		}
    	return false;
	}

	
	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public boolean isEmailExists(String Email) {
		
		Employee employee=null;
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            String sqlQuery="from Employee where email = :Email";
            Query<Employee> query = sessionObj.createQuery(sqlQuery);
  		    query.setParameter("Email", Email);
  		    employee=query.uniqueResult();
  		    logger.info("Employee: is Email "+ Email+" exists, Employee details="+employee);	  
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
        if(null != employee){
			return true;
		}
		return false;
		
	}

	
	@Transactional
	@Override
	public String getType(Long id) {
		Employee employee=null;
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            employee = sessionObj.get(Employee.class, id);
            logger.info("Employee: type of Id "+ id+" Employee details="+employee);		  
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
		
		return employee.getType();
	}


	
	@Transactional
	@SuppressWarnings({ "unchecked"})
	@Override
	public Employee getEmployeeByEmail(String Email) {
		Employee employee=null;
        Transaction transObj = null;
        Session sessionObj = null;
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            String sqlQuery="select id,email,name,image,password,managerId,type from Employee where email =:Email";
            Query<Employee> query = sessionObj.createQuery(sqlQuery);
  		    //query.setString("Email", Email);
  		    query.setParameter("Email",Email,StringType.INSTANCE);
  		    employee=query.uniqueResult();
  		    logger.info("Employee: with Email "+ Email+" exists, Employee details="+employee);	  
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

		return employee;
	}
}

