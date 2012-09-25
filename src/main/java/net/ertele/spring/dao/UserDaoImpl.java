package net.ertele.spring.dao;

import java.util.List;

import net.ertele.spring.domain.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Fatih ISIK
 *
 */

@Repository("UserDao")
public class UserDaoImpl extends CustomHibernateDaoSupport implements IUserDao{
 
	@Autowired
    private SessionFactory sessionFactory;
	
	Session session;
	
	public void save(User user){
		session = sessionFactory.getCurrentSession();
		session.save(user);
	}
 
	public void update(User user){
		session = sessionFactory.getCurrentSession();
		session.update(user);
	}
 
	public void delete(User user){
		session = sessionFactory.getCurrentSession();
		session.delete(user);
	}

	public User findByEmail(String email) {
		List list = session.createQuery("from User where email=? limit 1").setString(0, email).list();
		return (User)list.get(0);
	}

	public User findByUserName(String userName) {
		List list = session.createQuery("from User where user_name=? limit 1").setString(0, userName).list();
		return (User)list.get(0);
	}

	public User findByEmailAndPassword(String email, String password) {
		session = sessionFactory.getCurrentSession();
		List list = session.createQuery("from User where email=? and password=?").setString(0, email).setString(1, password).list();
		if (list.isEmpty()) {
			return null;
		}
		return (User)list.get(0);
	}
 
}