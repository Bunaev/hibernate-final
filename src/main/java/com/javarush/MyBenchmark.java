package com.javarush;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Slf4j
public class MyBenchmark {
    Main main = new Main();
    List<Integer> ids = List.of(3, 2545, 123, 4, 189, 89, 3458, 1189, 10, 102);

    @Benchmark
    public void benchmarkMethodForRedis() {
        main.testRedisData(ids);
    }
    @Benchmark
    public void benchmarkMethodForMySQL() {
        main.testMysqlData(ids);
    }

}
