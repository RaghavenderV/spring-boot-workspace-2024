package com.vodapally.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ProductTypeValidator implements ConstraintValidator<ValidateProductType, String> {
    @Override
    public boolean isValid(String productType, ConstraintValidatorContext context) {
        List<String> productTypes = Arrays.asList("Electronics", "Education","Baby&Kids");
        return productTypes.contains(productType);
    }
}
