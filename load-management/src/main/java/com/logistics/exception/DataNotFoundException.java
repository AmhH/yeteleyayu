package com.logistics.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataNotFoundException extends RuntimeException implements GraphQLError {


    private Map<String, Object> extensions = new HashMap<>();


    public DataNotFoundException(String message, Long identifier) {
        super(message);
        extensions.put("Identifier",identifier);
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
