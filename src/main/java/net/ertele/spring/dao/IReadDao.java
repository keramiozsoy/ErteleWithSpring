package net.ertele.spring.dao;

import java.util.List;

import net.ertele.spring.domain.Read;


/**
 * @author Fatih ISIK
 *
 */

public interface IReadDao {

	void save(Read read);
	void update(Read read);
	void delete(Read read);
	Read findById(Integer id);
	List<Read> findAll();
	List<Read> findByArchieve();
	List<Read> searchByUrl(String url);
	List<Read> searchByTitle(String title);
}
