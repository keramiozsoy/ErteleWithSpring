package net.ertele.spring.dao;

import java.util.List;

import net.ertele.spring.domain.Read;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Fatih ISIK
 *
 */

@Repository("readDao")
public class ReadDaoImpl extends CustomHibernateDaoSupport implements IReadDao{
 
	@Autowired
    private SessionFactory sessionFactory;
	
	Session session;

	public void save(Read read) {
		session = sessionFactory.getCurrentSession();
		session.save(read);
	}

	public void update(Read read) {
		session = sessionFactory.getCurrentSession();
		session.update(read);
	}

	public void delete(Read read) {
		session = sessionFactory.getCurrentSession();
		session.update(read);
	}

	public Read findById(Integer id) {
		return (Read) session.get(Read.class, id);
	}

	public List<Read> findAll() {
		Query q = session.createQuery("from Read");
		q.setFirstResult(20);
		q.setMaxResults(10);
		return q.list();
	}
	
	public List<Read> findByArchieve() {
		Query q = session.createQuery("from Read where archieve=?").setInteger(0, 1);
		q.setFirstResult(20);
		q.setMaxResults(10);
		return q.list();
	}
	
	public List<Read> searchByUrl(String url) {
		List<Read> list = session.createQuery("from Read where full_url like ? limit 1").setString(0, url).list();
		return list;
	}

	public List<Read> searchByTitle(String title) {
		List<Read> list = session.createQuery("from Read where title like ? limit 1").setString(0, title).list();
		return list;
	}



 
}