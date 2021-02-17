package no.bouvet.customvalidationexample;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import no.bouvet.customvalidationexample.models.CustomClassLevelValidation;
import no.bouvet.customvalidationexample.models.CustomFieldValidation;
import no.bouvet.customvalidationexample.models.DefaultValidation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerWithCustomExceptionHandle {

    @PostMapping("/custom-handle/default-validation")
    public DefaultValidation defaulValidation(@Valid @RequestBody DefaultValidation defaultValidation) {
        return defaultValidation;
    }

    @PostMapping("/custom-handle/custom-field-validation")
    public CustomFieldValidation customFieldValidation(@Valid @RequestBody CustomFieldValidation customFieldValidation) {
        return customFieldValidation;
    }

    @PostMapping("/custom-handle/custom-class-level-validation")
    public CustomClassLevelValidation customClassLevelValidation(@Valid @RequestBody CustomClassLevelValidation customClassLevelValidation) {
        return customClassLevelValidation;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            if(error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            } else {
                String objectName = error.getObjectName();
                String errorMessage = error.getDefaultMessage();
                errors.put(objectName, errorMessage);
            }
        });
        return errors;
    }
}
