package com.ekki.transaction;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LimitBalanceValidator implements ConstraintValidator<LimitBalance, Transaction> {
    @Override
    public void initialize(LimitBalance constraint) {
    }

    @Override
    public boolean isValid(Transaction object, ConstraintValidatorContext context) {
        return true;
    }
}