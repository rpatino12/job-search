package com.platzi.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

// Let's create a validator class to execute help when the user need it, and it doesn't execute as a normal parameter
public class CLIHelpValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        // So we check the actual value of isHelp attribute of the class CLIArguments
        boolean actualValue = Boolean.parseBoolean(value);
        if (actualValue){
            throw new ParameterException("Help solicited");
        }
    }
}
