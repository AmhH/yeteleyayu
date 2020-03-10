package com.hackerrank.user.service;

import com.hackerrank.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="jsonplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface UserClient {

    @GetMapping(path = "users")
    List<User> getUserFromPlaceholder(@RequestParam("username") String username);
}
