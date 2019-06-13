package com.example.SimulacroParcial.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

@Service
public class TestService {

    @Async("Executor")
     public CompletableFuture<Integer> metodo1(){
        try{
            sleep(10);
        }
        catch (InterruptedException e){
            System.out.println("Se ha interrumpido el hilo");
        }

        return CompletableFuture.completedFuture(10);
    }

    @Async("Executor")
    public CompletableFuture<Integer> metodo2(){
        try{
            sleep(10);
        }
        catch (InterruptedException e){
            System.out.println("Se ha interrumpido el hilo");
        }

        return CompletableFuture.completedFuture(5);
    }
}
