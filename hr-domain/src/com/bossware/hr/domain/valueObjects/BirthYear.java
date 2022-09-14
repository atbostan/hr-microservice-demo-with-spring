package com.bossware.hr.domain.valueObjects;

import java.util.Objects;

import com.bossware.hr.domain.annotations.ValueObject;

@ValueObject
public class BirthYear {
	private final int value;

	
	private BirthYear(int value) {
		this.value = value;
	}
	
	public static BirthYear of(int value) {
		if(!isValid(value)) throw new IllegalArgumentException("Birth year must be larger than 1940");
		return new BirthYear(value);
	}
	
		
	public int getValue() {
		return value;
	}
	
	private static boolean isValid(int value) {
		if(value < 1940) {
			return false;
		}
		else return true;
	}

	@Override
	public String toString() {
		return "BirthYear [value=" + value + "]";
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
		BirthYear other = (BirthYear) obj;
		return value == other.value;
	}
	
	

}
