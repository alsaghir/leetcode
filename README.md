# leetcode

## Benchmark Run

- Run `mvn clean test -pl contains-duplicate` for building specific module.
- Run
  `mvn exec:exec -pl contains-duplicate "-Dexec.executable=java" "-Dexec.args=-classpath target/classes;target/lib/* -Dfile.encoding=UTF-8 com.github.alsaghir.benchmark.Main"`
  for executing benchmarking using JMH and see the result of specific solution.