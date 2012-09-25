package net.ertele.spring.domain;
 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Fatih ISIK
 *
 */
 
@Entity
@Table(name = "user", catalog = "test", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL"),
		@UniqueConstraint(columnNames = "USER_NAME") })
public class User implements java.io.Serializable {
 
	@Id
    @GeneratedValue
    @Column(name="USER_ID")
	private Integer id;
	
	@NotEmpty
	@Column(name="FULL_NAME")
	private String fullName;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@NotEmpty
	@Email
	@Column(name="EMAIL")
	private String email;
	
	@NotEmpty
	@Column(name="PASSWORD")
	private String password;
	
	@OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="READ_ID")
    @IndexColumn(name="IDX")
	private List<Read> readList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Read> getReadList() {
		return readList;
	}

	public void setReadList(List<Read> readList) {
		this.readList = readList;
	}
 

 

}