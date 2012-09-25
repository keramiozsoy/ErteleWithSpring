package net.ertele.spring.service;

import java.util.List;

import net.ertele.spring.dao.IReadDao;
import net.ertele.spring.domain.Read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Fatih ISIK
 *
 */

@Service("readService")
public class ReadServiceImpl implements IReadService{

	@Autowired
	private IReadDao readDao;
	
	public void setReadDao(IReadDao readDao){
		this.readDao = readDao;
	}
	
	 @Transactional
	public void save(Read read) {
		readDao.save(read);
	}

	 @Transactional
	public void update(Read read) {
		readDao.update(read);
	}

	 @Transactional
	public void delete(Read read) {
		readDao.delete(read);
	}

	 @Transactional
	public Read findById(Integer id) {
		return readDao.findById(id);
	}

	 @Transactional
	public List<Read> findAll() {
		return readDao.findAll();
	}

	 @Transactional
	public List<Read> findByArchieve() {
		return readDao.findByArchieve();
	}

	 @Transactional
	public List<Read> searchByUrl(String url) {
		return readDao.searchByUrl(url);
	}

	 @Transactional
	public List<Read> searchByTitle(String title) {
		return readDao.searchByTitle(title);
	}

}
