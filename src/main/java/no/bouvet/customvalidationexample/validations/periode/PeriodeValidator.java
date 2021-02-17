package no.bouvet.customvalidationexample.validations.periode;

import java.lang.reflect.Field;
import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.ReflectionUtils;

public class PeriodeValidator
        implements ConstraintValidator<PeriodeConstraint, Object> {

    private String fraOgMedDato;
    private String tilOgMedDato;

    public void initialize(PeriodeConstraint constraintAnnotation) {
        this.fraOgMedDato = constraintAnnotation.fraOgMedDato();
        this.tilOgMedDato = constraintAnnotation.tilOgMedDato();
    }

    public boolean isValid(Object clazz,
                           ConstraintValidatorContext context) {

        LocalDate fraOgMedDato = null;
        LocalDate tilOgMedDato = null;

        Field fieldFOM = ReflectionUtils.findField(clazz.getClass(), this.fraOgMedDato);
        Field fieldTOM = ReflectionUtils.findField(clazz.getClass(), this.tilOgMedDato);

        if (fieldFOM != null && fieldFOM.getType().isAssignableFrom(LocalDate.class)) {
            ReflectionUtils.makeAccessible(fieldFOM);
            try {
                fraOgMedDato = (LocalDate) fieldFOM.get(clazz);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("Could not convert field " + this.fraOgMedDato + " to LocalDate");
            }
        }

        if (fieldTOM != null && fieldTOM.getType().isAssignableFrom(LocalDate.class)) {
            ReflectionUtils.makeAccessible(fieldTOM);
            try {
                tilOgMedDato = (LocalDate) fieldTOM.get(clazz);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("Could not convert field " + this.tilOgMedDato + " to LocalDate");
            }
        }

        return fraOgMedDato == null || tilOgMedDato == null || !tilOgMedDato.isBefore(fraOgMedDato);
    }
}
