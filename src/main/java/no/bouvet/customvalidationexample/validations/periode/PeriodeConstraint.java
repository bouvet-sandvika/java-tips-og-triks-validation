package no.bouvet.customvalidationexample.validations.periode;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PeriodeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PeriodeConstraint {
    String message() default "Til og med dato kan ikke være før fra og med dato";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fraOgMedDato();
    String tilOgMedDato();
}
