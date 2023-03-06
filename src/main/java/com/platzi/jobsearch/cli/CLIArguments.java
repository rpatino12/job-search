package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

// Let's create a class to work with the JCommander library
public class CLIArguments {
    // Let's have a constructor with default package visibility to prevent anyone else create instance of the class
    CLIArguments() {
    }

    // These attributes are the arguments that we have to pass through command line
    // Let's JCommander to declare the parameters, with the @Parameter annotation
    @Parameter(
            required = true,
            validateWith = CLIKeywordValidator.class,
            descriptionKey = "KEYWORD",
            description = "KEYWORD"
    )
    private String keyword;

    @Parameter(
            names = {"--location", "-l"},
            description = "All searches can be filtered including a location"
    )
    private String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "The API shows only 50 results, use a number to change of page"
    )
    private int page = 0;

    @Parameter(
            names = "--full-time",
            description = "Add this parameter if you want only full time jobs"
    )
    private boolean isFullTime = false;

    @Parameter(
            names = "--markdown",
            description = "Get the results in markdown"
    )
    private boolean isMarkdown = false;

    @Parameter(
            help = true,
            validateWith = CLIHelpValidator.class,
            names = "--help",
            description = "Show this help"
    )
    private boolean isHelp;

    // Method newInstance() that works like a supplier
    public static CLIArguments newInstance(){
        return new CLIArguments();
    }

    // Getters and Setters
    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    // toString method
    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }
}
