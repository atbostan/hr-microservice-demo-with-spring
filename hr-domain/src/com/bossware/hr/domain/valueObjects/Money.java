package com.bossware.hr.domain.valueObjects;

import java.util.Objects;

import com.bossware.hr.domain.annotations.ValueObject;

@ValueObject
public class Money {
	private final double value;
	private final Currency currency;
	
	private Money(double value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}
	
	
	public static Money of (double value ,Currency currency) {
		if(value <= 0.0) throw new IllegalArgumentException("Money must be larger than 0");
		Objects.requireNonNull(currency);
		return new Money(value,currency);
	}
	
	public static Money of(double value) {
		return of(value, Currency.TL);
	}
	
	
	public Money plus(Money other) {
		if (this.currency != other.currency)
			throw new IllegalArgumentException("Money is in different currency.");
		return Money.of(this.value + other.value, this.currency);
	}

	public Money minus(Money other) {
		if (this.currency != other.currency)
			throw new IllegalArgumentException("Money is in different currency.");
		return Money.of(this.value - other.value, this.currency);
	}
	

	public Money multiply(double multiplyFactor) {
		return Money.of(this.value * multiplyFactor,this.currency);
	}

	
	public double getValue() {
		return value;
	}
	public Currency getCurrency() {
		return currency;
	}
	

	
	@Override
	public String toString() {
		return "Money [value=" + value + ", currency=" + currency + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(currency, value);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return currency == other.currency && Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}
	
	
	

}
