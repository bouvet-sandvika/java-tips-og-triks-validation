package no.bouvet.customvalidationexample.models;

import no.bouvet.customvalidationexample.validations.fnr.FnrConstraint;

public class CustomFieldValidation {

    @FnrConstraint
    private String fnr;

    public CustomFieldValidation() {
    }

    public String getFnr() {
        return fnr;
    }
}
