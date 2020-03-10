package com.logistics;

import com.coxautodev.graphql.tools.SchemaParserOptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.logistics.exception.GraphQLErrorAdapter;
import com.logistics.publisher.LocationPublisher;
import com.logistics.repository.LoadRepository;
import com.logistics.repository.LocationRepository;
import com.logistics.repository.OrderRepository;
import com.logistics.resolver.LoadResolver;
import com.logistics.resolver.Mutation;
import com.logistics.resolver.OrderResolver;
import com.logistics.resolver.Query;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import graphql.servlet.ObjectMapperConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public LoadResolver loadResolver(LocationRepository locationRepository, OrderRepository orderRepository) {
        return new LoadResolver(locationRepository, orderRepository);
    }

    @Bean
    public OrderResolver orderResolver(LocationRepository locationRepository){
        return new OrderResolver(locationRepository);
    }

    @Bean
    public Query query(LocationRepository locationRepository, OrderRepository orderRepository, LoadRepository loadRepository){
        return new Query(locationRepository,orderRepository,loadRepository);
    }

    @Bean
    public Mutation mutation(LocationRepository locationRepository, OrderRepository orderRepository,
                             LoadRepository loadRepository, LocationPublisher locationPublisher){
        return new Mutation(locationRepository,orderRepository,loadRepository, locationPublisher);
    }

    @Bean
    ObjectMapperConfigurer objectMapperConfigurer() {
        return (ObjectMapper mapper) -> mapper.registerModule(new JavaTimeModule());
    }

    @Bean
    public SchemaParserOptions schemaParserOptions(){
        return SchemaParserOptions.newOptions().objectMapperConfigurer((mapper, context) -> {
            mapper.registerModule(new JavaTimeModule());
        }).build();
    }

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(GraphQLErrorAdapter::new)
                        .collect(Collectors.toList());

                List<GraphQLError> e = new ArrayList<>();
                e.addAll(clientErrors);
                e.addAll(serverErrors);
                return e;
            }

            protected boolean isClientError(GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }
}