package com.platzi.jobsearch.api;

import com.platzi.jobsearch.JobPosition;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

// Let's use Feign library to indicate that this interface is an API that connects with a web service
@Headers("Accept: application/json")
public interface APIJobs {

    // Now with Feign we indicate how the request has to be sent
    @RequestLine("GET /positions.json")
    List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);
    // With @QueryMap we define a query with the parameters needed by the web service, to get a list of jobs
}
