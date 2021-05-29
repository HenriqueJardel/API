package com.trabalho.api.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.trabalho.api.dto.AlunoUpdateDTO;
import com.trabalho.api.resources.exception.FieldMessage;
import com.trabalho.api.services.validation.util.Rga;

public class AlunoUpdateValidation implements ConstraintValidator<AlunoUpdate, AlunoUpdateDTO> {

    @Override
    public boolean isValid(AlunoUpdateDTO value, ConstraintValidatorContext context) {
        List<FieldMessage> errors = new ArrayList<>();

        if(!Rga.rgaIsValid(value.getRga())) {
            errors.add(new FieldMessage("rga", "Rga invalido!"));
        }

        for (FieldMessage error : errors) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(error.getMessage()).addPropertyNode(error.getFieldName())
					.addConstraintViolation();
		}
        
        return errors.isEmpty();
    }
    
}
