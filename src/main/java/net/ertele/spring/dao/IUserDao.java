package net.ertele.spring.dao;

import net.ertele.spring.domain.User;

/**
 * @author Fatih ISIK
 *
 */

public interface IUserDao {

	void save(User user);
	void update(User user);
	void delete(User user);
	User findByEmail(String email);
	User findByUserName(String userName);
	User findByEmailAndPassword(String email, String password);
}
