package com.trabalho.api.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.trabalho.api.domain.Aluno;
import com.trabalho.api.dto.AlunoDTO;
import com.trabalho.api.repository.AlunoRepository;
import com.trabalho.api.resources.exception.FieldMessage;
import com.trabalho.api.services.validation.util.Rga;

import org.springframework.beans.factory.annotation.Autowired;

public class AlunoInsertValidator implements ConstraintValidator<AlunoInsert, AlunoDTO> {

    @Autowired
    private AlunoRepository alunoRepository;

   @Override
	public void initialize(AlunoInsert ann) {
	}

    @Override
    public boolean isValid(AlunoDTO value, ConstraintValidatorContext context) {
       
        List<FieldMessage> errors = new ArrayList<>();
     
        if (Rga.rgaIsValid(value.getRga())) {
            Aluno aux = alunoRepository.findByRga(value.getRga());
            if (aux != null) {
                errors.add(new FieldMessage("rga", "Rga já existente!"));
            }
        }
        else {
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
