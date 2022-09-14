package com.bossware.hr.application.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.bossware.hr.application.validation.validators.IbanValidator;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=IbanValidator.class)
public @interface Iban {
	String message() default "{validation.iban}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
