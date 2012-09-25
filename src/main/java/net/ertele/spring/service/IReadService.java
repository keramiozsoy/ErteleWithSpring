package net.ertele.spring.service;

import java.util.List;

import net.ertele.spring.domain.Read;

/**
 * @author Fatih ISIK
 *
 */

public interface IReadService {

	void save(Read read);
	void update(Read read);
	void delete(Read read);
	Read findById(Integer id);
	List<Read> findAll();
	List<Read> findByArchieve();
	List<Read> searchByUrl(String url);
	List<Read> searchByTitle(String title);
}
