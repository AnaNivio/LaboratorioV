package com.globallogic.executorAsync.controller;

import com.globallogic.executorAsync.service.ConsummerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/consummer")
public class Consummer {

    @Autowired
    private ConsummerService consummerService;

    @GetMapping("/async")
    public ResponseEntity<?> getAsync() {
        CompletableFuture<Integer> resultMethodOne = consummerService.methodOne();
        CompletableFuture<Integer> resultMethodTwo = consummerService.methodTwo();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMethodOne.join() + resultMethodTwo.join());
    }
}
