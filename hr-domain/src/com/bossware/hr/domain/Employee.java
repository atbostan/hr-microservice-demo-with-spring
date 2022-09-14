package com.bossware.hr.domain;


import com.bossware.hr.domain.annotations.Aggregate;
import com.bossware.hr.domain.annotations.DomainEntity;
import com.bossware.hr.domain.valueObjects.BiometricPhoto;
import com.bossware.hr.domain.valueObjects.BirthYear;
import com.bossware.hr.domain.valueObjects.Currency;
import com.bossware.hr.domain.valueObjects.Department;
import com.bossware.hr.domain.valueObjects.Email;
import com.bossware.hr.domain.valueObjects.FullName;
import com.bossware.hr.domain.valueObjects.Iban;
import com.bossware.hr.domain.valueObjects.JobStyle;
import com.bossware.hr.domain.valueObjects.Money;
import com.bossware.hr.domain.valueObjects.PhoneNumber;
import com.bossware.hr.domain.valueObjects.TcKimlikNo;

@DomainEntity(identity = "tcKimlikNo")
@Aggregate 	
public class Employee extends User {
	
	private Money salary;
	private Currency currency;
	private Department department;
	private BiometricPhoto photo; 
	private JobStyle jobStyle;
	private Iban iban;
	
	private Employee(Builder builder) {
		this.identity=builder.identity;
		this.fullName=builder.fullName;
		this.birthYear=builder.birthYear;
		this.email=builder.email;
		this.phoneNumber=builder.phoneNumber;
		this.salary = builder.salary;
		this.currency = builder.currency;
		this.department = builder.department;
		this.photo = builder.photo;
		this.jobStyle = builder.jobStyle;
		this.iban = builder.iban;

	}
	
	
	
	public Money getSalary() {
		return salary;
	}



	public Currency getCurrency() {
		return currency;
	}



	public Department getDepartment() {
		return department;
	}



	public BiometricPhoto getPhoto() {
		return photo;
	}



	public JobStyle getJobStyle() {
		return jobStyle;
	}



	public Iban getIban() {
		return iban;
	}



	public static class Builder extends User {
		
		private Money salary;
		private Currency currency;
		private Department department;
		private BiometricPhoto photo; 
		private JobStyle jobStyle;
		private Iban iban;
		
		public Builder(String identity) {
			this.identity = TcKimlikNo.of(identity);
		}
		
		public Builder fullName(String firstName, String lastName) {
			this.fullName = FullName.of(firstName, lastName);
			return this;
		}
		
		public Builder email(String email) {
			this.email = Email.of(email);
			return this;
		}
		
		public Builder phoneNumber(String phoneNumber) {
			this.phoneNumber = PhoneNumber.of(phoneNumber);
			return this;
		}

		public Builder birthYear(int value) {
			this.birthYear = BirthYear.of(value);
			return this;
		}
		
		public Builder iban(String value) {
			this.iban = Iban.of(value);
			return this;
		}
		
		public Builder photo(String base64Values) {
			this.photo = BiometricPhoto.valueOf(base64Values);
			return this;
		}

		public Builder photo(byte[] values) {
			this.photo = BiometricPhoto.valueOf(values);
			return this;
		}


		public Builder department(Department department) {
			this.department = department;
			return this;
		}

		public Builder jobStyle(JobStyle jobStyle) {
			this.jobStyle = jobStyle;
			return this;
		}

		
		public Builder salary(double value, Currency currency) {
			this.salary = Money.of(value, currency);
			return this;
		}

		public Builder salary(double value) {
			this.salary = Money.of(value);
			return this;
		}
		
		public Employee build() {
			// Business Rule
			// Policy
			if (jobStyle == JobStyle.FULL_TIME && salary.lessThan(Money.of(5500)))
				throw new IllegalArgumentException("Salary is less than minimum wage for full-time employee.");
			// Invariants
			// Constraint
			// Validation
			return new Employee(this);
		}
		
	}
	
	

}
