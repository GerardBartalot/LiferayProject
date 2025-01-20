package com.example.test.validator;

import com.liferay.training.gradebook.exception.TestValidationException;
import java.util.Date;
public interface TestValidator {
    /**
     * Validates an Assignment
     *
     * @param title
     * @param description
     * @param dueDate
     * @throws TestValidationException
     */
    public void validate(
            String title, String description, Date dueDate)
            throws TestValidationException;
}
