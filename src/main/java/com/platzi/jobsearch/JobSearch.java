package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.api.APIFunctions;
import com.platzi.jobsearch.api.APIJobs;
import com.platzi.jobsearch.cli.CLIArguments;
import com.platzi.jobsearch.cli.CLIFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.platzi.jobsearch.CommanderFunctions.buildCommanderWithName;
import static com.platzi.jobsearch.CommanderFunctions.parseArguments;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("Hello job search in Gradle");
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        // Now we are going to work with the arguments passed by terminal
        // Create a Stream of arguments
        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage) // Parse the arguments
                .orElse(Collections.emptyList())// If there is no arguments, return an empty list
                .stream() // Transform the list to a Stream
                .map(obj -> (CLIArguments) obj); // Transform the stream elements to CLIArguments objects

        // Next we are going to get the arguments that are valid (is not a help case and have a valid keyword)
        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI.filter(cli -> !cli.isHelp()) // Arguments that are not help (for this we call JCommander usage)
                .filter(cli -> cli.getKeyword() != null) // Arguments that have a valid keyword
                .findFirst(); // This returns the first valid argument

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params){
        APIJobs api = APIFunctions.buildAPI(APIJobs.class, "https://jobs.github.com");

        return Stream.of(params).map(api::jobs).flatMap(Collection::stream);
    }
}
