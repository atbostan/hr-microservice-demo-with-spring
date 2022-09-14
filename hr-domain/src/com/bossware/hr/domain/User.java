package com.bossware.hr.domain;


import com.bossware.hr.domain.valueObjects.BirthYear;
import com.bossware.hr.domain.valueObjects.Email;
import com.bossware.hr.domain.valueObjects.FullName;
import com.bossware.hr.domain.valueObjects.PhoneNumber;
import com.bossware.hr.domain.valueObjects.TcKimlikNo;

public class User {
	protected TcKimlikNo identity;
	protected FullName fullName;
	protected BirthYear birthYear;
	protected Email email;
	protected PhoneNumber phoneNumber;
	public TcKimlikNo getIdentity() {
		return identity;
	}
	public FullName getFullName() {
		return fullName;
	}
	public BirthYear getBirthYear() {
		return birthYear;
	}
	public Email getEmail() {
		return email;
	}
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	
	
	
}
