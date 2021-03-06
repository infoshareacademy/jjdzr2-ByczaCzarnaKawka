package com.infoshare.service.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.infoshare.service.utils.Tools.isBornYearCorrect;

public class BornYearValidator implements ConstraintValidator<BornYear, Integer> {
   public void initialize(BornYear constraint) {
   }
   @Override
   public boolean isValid(Integer yearBorn, ConstraintValidatorContext context) {
      return isBornYearCorrect(yearBorn);
   }
}
