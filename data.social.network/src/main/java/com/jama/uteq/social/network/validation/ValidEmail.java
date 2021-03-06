package com.jama.uteq.social.network.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailValidator.class)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidEmail {
	String message() default "El correo debe de pertenecer a la UTEQ";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
