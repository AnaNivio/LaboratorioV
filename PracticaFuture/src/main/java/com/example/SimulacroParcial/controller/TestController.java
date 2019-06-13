package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.lang.Integer.sum;

@RestController
@RequestMapping("/suma")
public class TestController {
    @Autowired
    TestService suma;

    @GetMapping("")
    public ResponseEntity<?> getSuma() {
        CompletableFuture<Integer> valor1=suma.metodo1();
        CompletableFuture<Integer> valor2=suma.metodo2();

        return ResponseEntity.status(200).body(sum(valor1.join(),valor2.join()));
    }

}
