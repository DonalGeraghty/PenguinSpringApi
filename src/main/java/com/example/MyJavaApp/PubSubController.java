package com.example.MyJavaApp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

import static com.example.MyJavaApp.PublisherExample.publisherExample;
import static com.example.MyJavaApp.SubscribeAsyncExample.subscribeAsyncExample;

@RestController
public class PubSubController {

    String projectId = "myproject-314421";
    String subscriptionId = "my-sub";
    String topicId = "my-topic";

    @GetMapping("/pubsub")
    List<AtomicReference<String>> getPenguins() {
        List<AtomicReference<String>> messsages = subscribeAsyncExample(projectId, subscriptionId);
        return messsages;
    }


    @PostMapping("/pubsub/{name}")
    String postPenguin(@PathVariable String name) throws IOException, ExecutionException, InterruptedException {
        String messsage = publisherExample(projectId, topicId, name);
        return messsage;
    }
}
