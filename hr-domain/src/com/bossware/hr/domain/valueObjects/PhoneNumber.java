package com.bossware.hr.domain.valueObjects;

import java.util.Objects;

import com.bossware.hr.domain.annotations.ValueObject;

@ValueObject
public class PhoneNumber {
	
	private final String value ;

	
	private PhoneNumber(String value) {
		super();
		this.value = value;
	}

	public static PhoneNumber of(String value) {
		return new PhoneNumber(value);
	}

	public String getValue() {
		return value;
	}


	@Override
	public String toString() {
		return "PhoneNumber []";
	}


	@Override
	public int hashCode() {
		return Objects.hash(value);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneNumber other = (PhoneNumber) obj;
		return Objects.equals(value, other.value);
	}
	
	
	

}
