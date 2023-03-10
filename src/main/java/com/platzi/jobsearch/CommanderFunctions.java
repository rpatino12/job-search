package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunctions {
    // This function can read the arguments from the terminal
    public static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentSupplier) {
        JCommander jcommander = JCommander.newBuilder()
                .addCommand(argumentSupplier.get())
                .build();

        jcommander.setProgramName(cliName);

        return jcommander;
    }

    // This function helps us to transform the arguments from terminal to Java objects
    // The JCommander usage is needed if the user call an invalid option
    static Optional<List<Object>> parseArguments(
            JCommander jCommander,
            String[] arguments,
            Consumer<JCommander> onError
    ){
        try{
            jCommander.parse(arguments);
            return Optional.of(jCommander.getObjects());
        } catch (ParameterException paramEx){
            onError.accept(jCommander);
        }
        return Optional.empty();
    }
}
