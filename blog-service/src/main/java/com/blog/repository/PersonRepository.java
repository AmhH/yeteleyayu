package com.blog.repository;

import com.blog.model.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    @NotNull
    List<Person> findAll();

    List<Person> findByName(String name);
}