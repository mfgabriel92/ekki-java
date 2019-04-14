package com.ekki.transfer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LimitBalanceValidator implements ConstraintValidator<LimitBalance, Transfer> {
    @Override
    public void initialize(LimitBalance constraint) {
    }

    @Override
    public boolean isValid(Transfer object, ConstraintValidatorContext context) {
        return true;
    }
}