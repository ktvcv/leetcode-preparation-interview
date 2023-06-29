package leetcode.easy.test;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class CompetableFuture {

    private final static ScheduledExecutorService ec = Executors.newScheduledThreadPool(4);

    @Test
    public void callBackCompletableFuture() {
        final CompletableFuture<String> res = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 100_000_000_000L) {
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
                while (i < 1_000L) {
                    i++;
                }
                return "Java";
            });

        final CompletableFuture<Integer> resLength = res.thenApply(String::length);
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
                while (i < 1_000L) {
                    i++;
                }
                return "Java";
            });

        // final CompletableFuture<CompletableFuture<Integer>> resLength =  res.thenApply(res1 -> CompletableFuture.completedFuture(res1.length()));
        final CompletableFuture<Integer> resLength = res.thenCompose(res1 -> CompletableFuture.completedFuture(res1.length()));

        res.thenAccept(result -> {
            System.out.println(result + " 19");
        });
    }

    @Test
    public void thenCombileCompletableFuture() {
        final CompletableFuture<String> res1 = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 1_000L) {
                    i++;
                }
                return "Java";
            });

        final CompletableFuture<String> res2 = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 1_000L) {
                    i++;
                }
                return "Scala";
            });

        // final CompletableFuture<CompletableFuture<Integer>> resLength =  res.thenApply(res1 -> CompletableFuture.completedFuture(res1.length()));
        final CompletableFuture<Integer> res = res1.thenCombine(res2, (java, scala) -> java.length() + scala.length());

        res.thenAccept(System.out::println);
    }

    @Test
    public void applyToEitherCompletableFuture() {
        final CompletableFuture<String> res1 = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 1_000_000L) {
                    i++;
                }
                return "Java";
            });

        final CompletableFuture<String> res2 = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 1_000L) {
                    i++;
                }
                return "Scala";
            });

        // not interrupting second thread
        final CompletableFuture<Integer> res = res1
            .applyToEither(res2, first -> first.length());

        res.thenAccept(System.out::println);
    }

    @Test
    public void allOfCompletableFuture() {
        final CompletableFuture<String> res1 = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 1_000_000L) {
                    i++;
                }
                return "Java";
            });

        final CompletableFuture<String> res2 = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 1_000L) {
                    i++;
                }
                return "Scala";
            });

        // not interrupting second thread
        final CompletableFuture<Void> res = CompletableFuture.allOf(
            res1,
            res2
        );

        res.thenRun(() -> {
            try {
                System.out.println(res1.get());
                System.out.println(res2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }


    @Test
    public void handleCompletableFuture() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> res1 = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 1_000_000_000L) {
                    i++;
                }
                throw new RuntimeException();
            });

        CompletableFuture<String> res = res1
            .handle((result, throwable) -> {
                if (throwable != null) {
                    return "no result";
                } else {
                    return result;
                }
            });


        System.out.println(res.get());

    }

    @Test
    public void timeout() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> res1 = CompletableFuture
            .supplyAsync(() -> {
                long i = 0;
                while (i < 1_000_000L) {
                    i++;
                }
                return "Java";
            });

        final CompletableFuture<String> res2 = timeoutAfter(Duration.ofSeconds(1));
        CompletableFuture<CompletableFuture<String>> r = res1.applyToEither(
            res2, str -> res1
        );
        CompletableFuture<String> failure =  res2.exceptionally(ex -> "Recovered from \"" + ex.getMessage() + "\"");

        r.thenAccept(t -> {
            try {
                System.out.println(t.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

    public static <T> CompletableFuture<T> timeoutAfter(final Duration duration) {

        final CompletableFuture<T> promise = new CompletableFuture<>();
        ec.schedule(
            () -> promise.completeExceptionally(new RuntimeException()), duration.toMillis(),
            TimeUnit.MILLISECONDS);

        return promise;
    }
}