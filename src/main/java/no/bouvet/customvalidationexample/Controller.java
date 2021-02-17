package no.bouvet.customvalidationexample;

import javax.validation.Valid;

import no.bouvet.customvalidationexample.models.DefaultValidation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping("/default-validation")
    public DefaultValidation defaulValidation(@Valid @RequestBody DefaultValidation validation) {
        return validation;
    }
}
