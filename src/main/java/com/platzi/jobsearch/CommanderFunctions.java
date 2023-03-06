package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;

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
}
