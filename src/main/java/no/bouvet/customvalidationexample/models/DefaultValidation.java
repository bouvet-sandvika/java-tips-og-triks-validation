package no.bouvet.customvalidationexample.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class DefaultValidation {

    @Max(value = 42)
    @Min(0)
    private Integer number;

    public DefaultValidation() {
    }

    public Integer getNumber() {
        return number;
    }
}
