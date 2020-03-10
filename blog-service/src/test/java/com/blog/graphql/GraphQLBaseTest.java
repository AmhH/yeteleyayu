package com.blog.graphql;

import com.blog.resolver.InputNote;
import com.blog.resolver.InputPerson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Slf4j
public class GraphQLBaseTest {
    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    public GraphQLResponse createNote(InputNote inputNote, InputPerson inputPerson) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.set("inputNote", mapper.convertValue(inputNote, JsonNode.class));
        rootNode.set("inputAuthor", mapper.convertValue(inputPerson, JsonNode.class));
        return create(rootNode, "queries/create-note.graphql");
    }

    private GraphQLResponse create(ObjectNode input, String graphQlQuery) throws IOException {
        GraphQLResponse createResponse = this.graphQLTestTemplate.perform(graphQlQuery, input);
        log.info(String.format("Response: %s", createResponse.getRawResponse().toString()));
        return createResponse;
    }
}