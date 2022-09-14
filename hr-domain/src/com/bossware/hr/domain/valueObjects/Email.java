package com.bossware.hr.domain.valueObjects;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bossware.hr.domain.annotations.ValueObject;

@ValueObject
public class Email {

	private  final String value;
	private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	private Email(String value) {
		this.value = value;
	}

	public static Email of (String value) {
		if(!isValid(value)) throw new IllegalArgumentException("%s is an invalid email address.".formatted(value));
		return new Email(value);
	}
	public String getValue() {
		return value;
	}


	private static boolean isValid(final String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	@Override
	public String toString() {
		return "Email [value=" + value + "]";
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
		Email other = (Email) obj;
		return Objects.equals(value, other.value);
	}

	
}
