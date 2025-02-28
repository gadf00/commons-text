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
package org.apache.commons.text.similarity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Tests {@link LongestCommonSubsequence}.
 */
public class LongestCommonSubsequenceTest {

    private static LongestCommonSubsequence subject;

    @BeforeAll
    public static void setup() {
        subject = new LongestCommonSubsequence();
    }

    @Test
    @SuppressWarnings("deprecation")
    void testGettingLogestCommonSubsequenceNullNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> subject.logestCommonSubsequence(null, null));
    }

    @Test
    @SuppressWarnings("deprecation")
    void testGettingLogestCommonSubsequenceNullString() {
        assertThatIllegalArgumentException().isThrownBy(() -> subject.logestCommonSubsequence(null, "right"));
    }

    @Test
    @SuppressWarnings("deprecation")
    void testGettingLogestCommonSubsequenceStringNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> subject.logestCommonSubsequence(" ", null));
    }

    @Test
    void testGettingLongestCommonSubsequenceApplyNullNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> subject.apply(null, null));
    }

    @Test
    void testGettingLongestCommonSubsequenceApplyNullString() {
        assertThatIllegalArgumentException().isThrownBy(() -> subject.apply(null, "right"));
    }

    @Test
    void testGettingLongestCommonSubsequenceApplyStringNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> subject.apply(" ", null));
    }

    @Test
    void testGettingLongestCommonSubsequenceNullNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> subject.longestCommonSubsequence(null, null));
    }

    @Test
    void testGettingLongestCommonSubsequenceNullString() {
        assertThatIllegalArgumentException().isThrownBy(() -> subject.longestCommonSubsequence(null, "right"));
    }

    @Test
    void testGettingLongestCommonSubsequenceStringNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> subject.longestCommonSubsequence(" ", null));
    }

    @Test
    @Deprecated
    void testLogestCommonSubsequence() {
        assertThat(subject.logestCommonSubsequence("", "")).isEmpty();
        assertThat(subject.logestCommonSubsequence("left", "")).isEmpty();
        assertThat(subject.logestCommonSubsequence("", "right")).isEmpty();
        assertThat(subject.logestCommonSubsequence("frog", "fog")).isEqualTo("fog");
        assertThat(subject.logestCommonSubsequence("fly", "ant")).isEmpty();
        assertThat(subject.logestCommonSubsequence("elephant", "hippo")).isEqualTo("h");
        assertThat(subject.logestCommonSubsequence("ABC Corporation", "ABC Corp")).isEqualTo("ABC Corp");
        assertThat(subject.logestCommonSubsequence("D N H Enterprises Inc", "D & H Enterprises, Inc."))
            .isEqualTo("D  H Enterprises Inc");
        assertThat(subject.logestCommonSubsequence("My Gym Children's Fitness Center", "My Gym. Childrens Fitness"))
            .isEqualTo("My Gym Childrens Fitness");
        assertThat(subject.logestCommonSubsequence("PENNSYLVANIA", "PENNCISYLVNIA")).isEqualTo("PENNSYLVNIA");
        assertThat(subject.logestCommonSubsequence("left", "right")).isEqualTo("t");
        assertThat(subject.logestCommonSubsequence("leettteft", "ritttght")).isEqualTo("tttt");
        assertThat(subject.logestCommonSubsequence("the same string", "the same string")).isEqualTo("the same string");
    }

    @Test
    void testLongestCommonSubsequence() {
        assertThat(subject.longestCommonSubsequence("", "")).isEmpty();
        assertThat(subject.longestCommonSubsequence("left", "")).isEmpty();
        assertThat(subject.longestCommonSubsequence("", "right")).isEmpty();
        assertThat(subject.longestCommonSubsequence("frog", "fog")).isEqualTo("fog");
        assertThat(subject.longestCommonSubsequence("fly", "ant")).isEmpty();
        assertThat(subject.longestCommonSubsequence("elephant", "hippo")).isEqualTo("h");
        assertThat(subject.longestCommonSubsequence("ABC Corporation", "ABC Corp")).isEqualTo("ABC Corp");
        assertThat(subject.longestCommonSubsequence("D N H Enterprises Inc", "D & H Enterprises, Inc."))
            .isEqualTo("D  H Enterprises Inc");
        assertThat(subject.longestCommonSubsequence("My Gym Children's Fitness Center", "My Gym. Childrens Fitness"))
            .isEqualTo("My Gym Childrens Fitness");
        assertThat(subject.longestCommonSubsequence("PENNSYLVANIA", "PENNCISYLVNIA")).isEqualTo("PENNSYLVNIA");
        assertThat(subject.longestCommonSubsequence("left", "right")).isEqualTo("t");
        assertThat(subject.longestCommonSubsequence("leettteft", "ritttght")).isEqualTo("tttt");
        assertThat(subject.longestCommonSubsequence("the same string", "the same string")).isEqualTo("the same string");
    }

    @Test
    void testLongestCommonSubsequenceApply() {
        assertThat(subject.apply("", "")).isZero();
        assertThat(subject.apply("left", "")).isZero();
        assertThat(subject.apply("", "right")).isZero();
        assertThat(subject.apply("frog", "fog")).isEqualTo(3);
        assertThat(subject.apply("fly", "ant")).isZero();
        assertThat(subject.apply("elephant", "hippo")).isEqualTo(1);
        assertThat(subject.apply("ABC Corporation", "ABC Corp")).isEqualTo(8);
        assertThat(subject.apply("D N H Enterprises Inc", "D & H Enterprises, Inc.")).isEqualTo(20);
        assertThat(subject.apply("My Gym Children's Fitness Center", "My Gym. Childrens Fitness")).isEqualTo(24);
        assertThat(subject.apply("PENNSYLVANIA", "PENNCISYLVNIA")).isEqualTo(11);
        assertThat(subject.apply("left", "right")).isEqualTo(1);
        assertThat(subject.apply("leettteft", "ritttght")).isEqualTo(4);
        assertThat(subject.apply("the same string", "the same string")).isEqualTo(15);
    }
}
