/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.text.jmh;

import org.apache.commons.text.TextStringBuilder;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(value = 1)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class TextStringBuilderBenchmark {

    private TextStringBuilder textStringBuilder;

    @Setup(Level.Iteration)
    public void setup() {

        textStringBuilder = new TextStringBuilder("This is a Performance Test for the class TextStringBuilder:");
    }

    @Benchmark
    public void appendBenchMark() {
        for (int i = 0; i < 1000; i++) {
            textStringBuilder.append("Append Text");
        }
    }

    @Benchmark
    public void appendlnBenchMark() {
        for (int i = 0; i < 1000; i++) {
            textStringBuilder.appendln("Append Line");
        }
    }

    @Benchmark
    public void deleteBenchmark() {
        textStringBuilder.delete(0, 9);
    }

    @Benchmark
    public void deleteCharAtBenchmark() {
        textStringBuilder.deleteCharAt(58);
    }

    @Benchmark
    public void insertBenchmark() {

        textStringBuilder.insert(59, "Inserted Text");
    }

    @Benchmark
    public void insertCharBenchmark() {
        textStringBuilder.insert(58, '.');
    }

    @Benchmark
    public void replaceBenchmark() {
        textStringBuilder.replace(0, 8, "This is a super");
    }




    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
