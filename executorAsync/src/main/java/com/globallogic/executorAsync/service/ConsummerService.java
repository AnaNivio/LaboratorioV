package com.globallogic.executorAsync.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ConsummerService {

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<Integer> methodOne() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(5);
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<Integer> methodTwo() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(2);
    }
}
