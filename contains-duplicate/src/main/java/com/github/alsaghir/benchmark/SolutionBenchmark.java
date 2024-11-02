package com.github.alsaghir.benchmark;

import com.github.alsaghir.solution.Solution;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.Collections;

@State(Scope.Thread)
public class SolutionBenchmark {

    private Integer[] input;
    private Solution solution;


    @Setup(Level.Iteration)
    public void setup() {
        solution = new Solution();
    }

    private Integer[] getInput() {
        int size = 10_000;
        ArrayList<Integer> arr = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr);
        return arr.toArray(new Integer[0]);
    }


    @Group
    @Benchmark
    public boolean containsDuplicateBruteForce() {
        input = getInput();
        return solution.containsDuplicateBruteForce(input);
    }

    @Group
    @Benchmark
    public boolean containsDuplicateSorting() {
        input = getInput();
        return solution.containsDuplicateSorting(input);
    }

    @Group
    @Benchmark
    public boolean containsDuplicateSet() {
        input = getInput();
        return solution.containsDuplicateSet(input);
    }
}
