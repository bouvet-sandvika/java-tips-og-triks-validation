package no.bouvet.customvalidationexample.models;

import java.time.LocalDate;

import no.bouvet.customvalidationexample.validations.periode.PeriodeConstraint;

@PeriodeConstraint(fraOgMedDato = "fraOgMedDato", tilOgMedDato = "tilOgMedDato")
public class CustomClassLevelValidation {

    private LocalDate fraOgMedDato;
    private LocalDate tilOgMedDato;

    public CustomClassLevelValidation() {
    }

    public LocalDate getFraOgMedDato() {
        return fraOgMedDato;
    }

    public LocalDate getTilOgMedDato() {
        return tilOgMedDato;
    }
}
