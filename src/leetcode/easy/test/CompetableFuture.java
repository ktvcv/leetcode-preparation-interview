package leetcode.easy.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

class CompetableFuture {

    private final static ExecutorService ec = new ForkJoinPool(2);

    @Test
    public void callBackCompletableFuture() {
        final CompletableFuture<String> res = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 100_000_000_000L){
                    i++;
                }
                return "Java";
            });

        res.join();
        res.thenAccept(result -> System.out.println(result + " 19"));
    }

    @Test
    public void thenApplyCompletableFuture() {
        final CompletableFuture<String> res = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 1_000L){
                    i++;
                }
                return "Java";
            });

        final CompletableFuture<Integer> resLength =  res.thenApply(String::length);
        res.thenAccept(result -> {
            try {
                System.out.println(resLength.get() + " 19");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void thenComposeCompletableFuture() {
        final CompletableFuture<String> res = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 1_000L){
                    i++;
                }
                return "Java";
            });

       // final CompletableFuture<CompletableFuture<Integer>> resLength =  res.thenApply(res1 -> CompletableFuture.completedFuture(res1.length()));
         final CompletableFuture<Integer> resLength =  res.thenCompose(res1 -> CompletableFuture.completedFuture(res1.length()));

        res.thenAccept(result -> {
            try {
                System.out.println(resLength.get() + " 19");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}