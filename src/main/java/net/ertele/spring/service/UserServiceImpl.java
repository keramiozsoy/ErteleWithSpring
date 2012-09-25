package net.ertele.spring.service;

import net.ertele.spring.dao.IUserDao;
import net.ertele.spring.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Fatih ISIK
 *
 */

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao){
		this.userDao = userDao;
	}
	
	 @Transactional
	public void save(User user) {
		userDao.save(user);
	}

	 @Transactional
	public void update(User user) {
		userDao.update(user);
	}

	 @Transactional
	public void delete(User user) {
		userDao.delete(user);
	}
	 @Transactional
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	 @Transactional
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}
	 @Transactional
	public User findByEmailAndPassword(String email, String password) {
		return userDao.findByEmailAndPassword(email, password);
	}

}
