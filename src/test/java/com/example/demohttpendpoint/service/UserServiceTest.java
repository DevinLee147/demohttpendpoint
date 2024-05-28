package com.example.demohttpendpoint.service;

import com.example.demohttpendpoint.model.User;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testReadWritePerformance() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        StopWatch stopWatch = new StopWatch();

        // Write test
        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            final long id = i;
            executor.submit(() -> {
                User user = new User(id,"user" + id, 12345678, "java");
                userService.createUser(user);
            });
        }

        // Read test
        for (int i = 0; i < 100000; i++) {
            final int id = i;
            executor.submit(() -> {
                User user = userService.getUserByUsername("user" + id);
                assertNotNull(user);
                assertEquals("user" + id, user.getUsername());
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES); // 等待所有任务执行完毕
        stopWatch.stop();
        System.out.println("Total time: " + stopWatch.getTime() + " ms");
    }
}
