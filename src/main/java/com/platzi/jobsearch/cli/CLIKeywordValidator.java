package com.platzi.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

// Let's create a validator class to check that the keyword used in the command line is not empty or has symbols
public class CLIKeywordValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        // Check if the keyword is not empty, and only have letters and numbers
        if(!value.matches("^[a-zA-Z]+[0-9]*$")){
            System.err.println("The keyword is not valid.");
            throw new ParameterException("Use letters and numbers only");
        }
    }
}
