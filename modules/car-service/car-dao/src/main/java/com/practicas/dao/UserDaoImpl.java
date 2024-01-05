package com.practicas.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practicas.model.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findById(int id) {
		User user = getByKey(id);
		if(user!=null){
			initializeCollection(user.getUserProfiles());
		}
		return user;
	}

	public User findByEmail(String email) {
		System.out.println("email : "+email);
		try{
			User user = (User) getEntityManager()
					.createQuery("SELECT u FROM User u WHERE u.email = :email")
					.setParameter("email", email)
					.getSingleResult();
			
			if(user!=null){
				initializeCollection(user.getUserProfiles());
			}
			return user; 
		}catch(NoResultException ex){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> users = getEntityManager()
				.createQuery("SELECT u FROM User u ORDER BY u.firstName ASC")
				.getResultList();
		return users;
	}

	public void save(User user) {
		persist(user);
	}

	public void deleteByEmail(String email) {
		User user = (User) getEntityManager()
				.createQuery("SELECT u FROM User u WHERE u.email = :email")
				.setParameter("email", email)
				.getSingleResult();
		delete(user);
	}
	
	//An alternative to Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
	    if(collection == null) {
	        return;
	    }
	    collection.iterator().hasNext();
	}

}
