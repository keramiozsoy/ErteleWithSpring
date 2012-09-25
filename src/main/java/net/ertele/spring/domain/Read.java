package net.ertele.spring.domain;
 
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 * @author Fatih ISIK
 *
 */

@Entity
@Table(name = "read", catalog = "test")
public class Read implements java.io.Serializable {
 
	@Id
    @GeneratedValue
    @Column(name="READ_ID")
	private Integer id;
	
	@Column(name="FULL_URL")
	private String fullUrl;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="ARCHIEVE")
	private Integer archieve; // 0,1
	
	@ManyToOne
    @JoinColumn(name="USER_ID", insertable=false, updatable=false, nullable=false)
	private User user;
 

}