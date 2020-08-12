package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class CategoryRepository {
	public List<Category> getAll() {
		try(Session session=HibernateUtil.getSessionFactory().openSession();) {
			
			return session.createQuery("From Category").list();
		} 
	}
	public boolean add(Category obj) {
		Transaction tran= null;
		try(Session session=HibernateUtil.getSessionFactory().openSession() ){
			tran=session.beginTransaction();
			session.save(obj);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) {
				tran.rollback();
				}
				return false;
		}
		
	}
	public boolean edit(Category obj) {
		Transaction tran= null;
		try(Session session=HibernateUtil.getSessionFactory().openSession() ){
			tran=session.beginTransaction();
			session.merge(obj);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) {
				tran.rollback();
				}
				return false;
		}
		
	}
	public boolean deleteById(int id) {
		Transaction tran= null;
		try(Session session=HibernateUtil.getSessionFactory().openSession() ){
			tran=session.beginTransaction();
			Category obj= this.findById(id);
			session.delete(obj);
			tran.commit();
			return true;
		}catch (Exception e) {
			if(tran != null) {
				tran.rollback();
				}
				return false;
		}
		
	}
	public Category findById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		return session.find(Category.class, id);
	}
}
