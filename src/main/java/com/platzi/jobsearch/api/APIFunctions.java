package com.platzi.jobsearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;

// Let's create an interface with a function that generate objects of API type
public interface APIFunctions {
    // static Generic<T> method, that generates an API object, an object that is going to be consumed as an API
    static <T> T buildAPI(Class<T> classGenerated, String url){
        // Using Feign
        return Feign.builder() // build the web client
                .decoder(new GsonDecoder()) // decode the results with gson
                .target(classGenerated, url); // and target to an API in the specified url
    }
}
