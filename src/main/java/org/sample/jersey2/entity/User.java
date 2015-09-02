package org.sample.jersey2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "m_user")
public class User {

	@Id
	@Column(name = "user_seq")
	public Integer userSeq;

	@Column(name = "user_id")
	public String userId;

	@Column(name = "password")
	public String password;

	@Column(name = "first_name")
	public String firstName;

	@Column(name = "last_name")
	public String lastName;

	@Column(name = "birthday")
	@Temporal(TemporalType.DATE)
	public Date birthday;

	@Column(name = "last_access_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Date lastAccessDatetime;

	@Column(name = "age")
	public Integer age;

	@Column(name = "update_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	public Date updateDatetime;

	@Column(name = "update_user_seq")
	public Integer updateUserSeq;

	@Column(name = "disable_flag")
	public Integer disableFlag;

}
