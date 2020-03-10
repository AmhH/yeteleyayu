package com.me.demo.pluralsight.httpclient;

// import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

public class Async {

    public static void main(String[] args) /*throws IOException, InterruptedException*/ {
        HttpClient.Builder builder = HttpClient.newBuilder();

        builder.version((HttpClient.Version.HTTP_2))
                .followRedirects(HttpClient.Redirect.ALWAYS);

        HttpClient client = builder.build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .header("User-Agent", "Java")
                .timeout(Duration.ofMillis(700))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        response.thenAccept(r -> {
            System.out.println("Version: " + r.version());
            System.out.println((r.body()));
        });
        response.join();


        StackWalker stackWalker = StackWalker.getInstance();
        stackWalker.forEach(System.out::println);
        stackWalker.walk(stackStream ->
                stackStream
                        .filter(f -> f.getMethodName().startsWith("m"))
                        .map(StackWalker.StackFrame::getLineNumber)
                        .collect(toList())
        );
    }
}
