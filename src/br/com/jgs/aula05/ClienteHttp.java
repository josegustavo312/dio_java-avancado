package br.com.jgs.aula05;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ClienteHttp {

    static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            System.out.println("Nova Thread criada: " + (thread.isDaemon() ? "daemon" : "") + " Thread Group: " + thread.getThreadGroup());
            return thread;
        }
    });

    public static void main(String[] args) throws Exception {
        //connectAndPrintURLJavaOracle();
        connectAkamaiHttpCliente();
    }

    private static void connectAndPrintURLJavaOracle() throws Exception{
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://docs.oracle.com/javase/10/language/"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Headers response: " + response.headers());
        System.out.println(response.body());

    }

    private static void connectAkamaiHttpCliente() throws Exception {
        //System.out.println("Running HTTP/1.1 example ..."); //HTTP 1.1
        System.out.println("Running HTTP/2 example ...");

        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    //.version(HttpClient.Version.HTTP_1_1) //HTTP 1.1
                    .version(HttpClient.Version.HTTP_2)
                    .proxy(ProxySelector.getDefault())
                    .build();

            long start = System.currentTimeMillis();

            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();

            HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Headers: " + response.headers());
            String responseBody = response.body();
            System.out.println(responseBody);

            List<Future<?>> future = new ArrayList<>();

            responseBody
                    .lines()
                    .filter(line -> line.trim().startsWith("<img height"))
                    .map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
                    .forEach(image -> {
                        Future<?> imgFuture = executor.submit(() -> {
                            HttpRequest imgRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("https://http2.akamai.com" + image))
                                    .build();

                            try {
                                HttpResponse<String> imageResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                                System.out.println("Imagem Carregada: "+image+", status code: "+imageResponse.statusCode());
                            } catch (IOException | InterruptedException e) {
                                System.out.println("Erro durante a requisição para recuperar a imagem " + image);
                            }

                        });

                        future.add(imgFuture);
                        System.out.println("Submetido um futuro para imagem: " + image);

                    });

            future.forEach(f -> {
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Erro ao esperar o carregamento da imagem futura");
                }
            });

            long end = System.currentTimeMillis();
            System.out.println("Tempo de carregamento total: " + (end - start) + " ms");

        }finally {
            executor.shutdown();
        }

    }

}
