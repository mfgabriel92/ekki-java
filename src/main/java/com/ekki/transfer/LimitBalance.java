package com.ekki.transfer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LimitBalanceValidator.class)
public @interface LimitBalance {
    String message() default "Limite de saldo de R$ 500,00 atingido para este beneficiário";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}