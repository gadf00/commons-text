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
import org.openjdk.jmh.annotations.*;


import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(value = 1)
@Warmup(iterations = 2)
@Measurement(iterations = 3)
public class TextStringBuilderBenchmark {

    private TextStringBuilder textStringBuilder;

    @Setup
    public void setup() {
        textStringBuilder = new TextStringBuilder(100);
    }

    @Benchmark
    public String buildString() {
        textStringBuilder.clear();
        for (int i = 0; i < 1000; i++) {
            textStringBuilder.append("Text");
        }
        return textStringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
