package com.bossware.hr.application.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.bossware.hr.application.validation.validators.TcKimlikNoValidator;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=TcKimlikNoValidator.class)
public @interface TcKimlikNo {
	String message() default "{validation.identityNo}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	

}
