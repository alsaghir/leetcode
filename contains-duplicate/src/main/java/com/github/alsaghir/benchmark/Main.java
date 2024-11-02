package com.github.alsaghir.benchmark;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

/**
 * This method runs the provided benchmark using the OpenJDK Java Microbenchmark Harness (JMH).
 * It sets up the options for the benchmark run, including the benchmark class to include,
 * the number of measurement iterations, the mode for benchmarking, the number of forks,
 * the number of threads, the time unit, the timeout, the warmup time, the warmup iterations,
 * the measurement time, and the result format type.
 */
public class Main {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SolutionBenchmark.class.getSimpleName())
                .measurementIterations(5)
                .mode(Mode.AverageTime)
                .forks(1)
                .threads(10)
                .timeUnit(TimeUnit.NANOSECONDS)
                .timeout(TimeValue.seconds(10))
                .warmupTime(TimeValue.seconds(5))
                .warmupIterations(1)
                .measurementTime(TimeValue.seconds(5))
                .resultFormat(ResultFormatType.TEXT)
                .build();

        new Runner(opt).run();
    }
}
