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
package org.apache.commons.text;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests {@link StrMatcher}.
 *
 * @deprecated This class will be removed in 2.0.
 */
@Deprecated
class StrMatcherTest  {

    private static final char[] BUFFER1 = "0,1\t2 3\n\r\f\u0000'\"".toCharArray();

    private static final char[] BUFFER2 = "abcdef".toCharArray();


    @Test
    void testCharMatcher_char() {
        final StrMatcher matcher = StrMatcher.charMatcher('c');
        assertThat(matcher.isMatch(BUFFER2, 0)).isZero();
        assertThat(matcher.isMatch(BUFFER2, 1)).isZero();
        assertThat(matcher.isMatch(BUFFER2, 2)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER2, 3)).isZero();
        assertThat(matcher.isMatch(BUFFER2, 4)).isZero();
        assertThat(matcher.isMatch(BUFFER2, 5)).isZero();
    }

    @Test
    void testCharSetMatcher_charArray() {
        final StrMatcher matcher = StrMatcher.charSetMatcher("ace".toCharArray());
        assertThat(matcher.isMatch(BUFFER2, 0)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER2, 1)).isZero();
        assertThat(matcher.isMatch(BUFFER2, 2)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER2, 3)).isZero();
        assertThat(matcher.isMatch(BUFFER2, 4)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER2, 5)).isZero();
        assertThat(StrMatcher.charSetMatcher()).isSameAs(StrMatcher.noneMatcher());
        assertThat(StrMatcher.charSetMatcher((char[]) null)).isSameAs(StrMatcher.noneMatcher());
        assertThat(StrMatcher.charSetMatcher("a".toCharArray())).isInstanceOf(StrMatcher.CharMatcher.class);
    }

    @Test
    void testCharSetMatcher_String() {
        final StrMatcher matcher = StrMatcher.charSetMatcher("ace");
        assertThat(matcher.isMatch(BUFFER2, 0)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER2, 1)).isZero();
        assertThat(matcher.isMatch(BUFFER2, 2)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER2, 3)).isZero();
        assertThat(matcher.isMatch(BUFFER2, 4)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER2, 5)).isZero();
        assertThat(StrMatcher.charSetMatcher("")).isSameAs(StrMatcher.noneMatcher());
        assertThat(StrMatcher.charSetMatcher((String) null)).isSameAs(StrMatcher.noneMatcher());
        assertThat(StrMatcher.charSetMatcher("a")).isInstanceOf(StrMatcher.CharMatcher.class);
    }

    @Test
    void testCommaMatcher() {
        final StrMatcher matcher = StrMatcher.commaMatcher();
        assertThat(StrMatcher.commaMatcher()).isSameAs(matcher);
        assertThat(matcher.isMatch(BUFFER1, 0)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 1)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 2)). isZero();
    }

    @Test
    void testDoubleQuoteMatcher() {
        final StrMatcher matcher = StrMatcher.doubleQuoteMatcher();
        assertThat(StrMatcher.doubleQuoteMatcher()).isSameAs(matcher);
        assertThat(matcher.isMatch(BUFFER1, 11)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 12)).isEqualTo(1);
    }

    @Test
    void testMatcherIndices() {
        // remember that the API contract is tight for the isMatch() method
        // all the onus is on the caller, so invalid inputs are not
        // the concern of StrMatcher, and are not bugs
        final StrMatcher matcher = StrMatcher.stringMatcher("bc");
        assertThat(matcher.isMatch(BUFFER2, 1, 1, BUFFER2.length)).isEqualTo(2);
        assertThat(matcher.isMatch(BUFFER2, 1, 0, 3)).isEqualTo(2);
        assertThat(matcher.isMatch(BUFFER2, 1, 0, 2)). isZero();
    }

    @Test
    void testNoneMatcher() {
        final StrMatcher matcher = StrMatcher.noneMatcher();
        assertThat(StrMatcher.noneMatcher()).isSameAs(matcher);
        assertThat(matcher.isMatch(BUFFER1, 0)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 1)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 2)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 3)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 4)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 5)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 6)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 7)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 8)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 9)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 10)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 11)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 12)). isZero();
    }

    @Test
    void testQuoteMatcher() {
        final StrMatcher matcher = StrMatcher.quoteMatcher();
        assertThat(StrMatcher.quoteMatcher()).isSameAs(matcher);
        assertThat(matcher.isMatch(BUFFER1, 10)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 11)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 12)).isEqualTo(1);
    }

    @Test
    void testSingleQuoteMatcher() {
        final StrMatcher matcher = StrMatcher.singleQuoteMatcher();
        assertThat(StrMatcher.singleQuoteMatcher()).isSameAs(matcher);
        assertThat(matcher.isMatch(BUFFER1, 10)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 11)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 12)). isZero();
    }

    @Test
    void testSpaceMatcher() {
        final StrMatcher matcher = StrMatcher.spaceMatcher();
        assertThat(StrMatcher.spaceMatcher()).isSameAs(matcher);
        assertThat(matcher.isMatch(BUFFER1, 4)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 5)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 6)). isZero();
    }

    @Test
    void testSplitMatcher() {
        final StrMatcher matcher = StrMatcher.splitMatcher();
        assertThat(StrMatcher.splitMatcher()).isSameAs(matcher);
        assertThat(matcher.isMatch(BUFFER1, 2)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 3)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 4)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 5)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 6)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 7)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 8)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 9)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 10)). isZero();
    }

    @Test
    void testStringMatcher_String() {
        final StrMatcher matcher = StrMatcher.stringMatcher("bc");
        assertThat(matcher.isMatch(BUFFER2, 0)). isZero();
        assertThat(matcher.isMatch(BUFFER2, 1)).isEqualTo(2);
        assertThat(matcher.isMatch(BUFFER2, 2)). isZero();
        assertThat(matcher.isMatch(BUFFER2, 3)). isZero();
        assertThat(matcher.isMatch(BUFFER2, 4)). isZero();
        assertThat(matcher.isMatch(BUFFER2, 5)). isZero();
        assertThat(StrMatcher.stringMatcher("")).isSameAs(StrMatcher.noneMatcher());
        assertThat(StrMatcher.stringMatcher((String) null)).isSameAs(StrMatcher.noneMatcher());
    }

    @Test
    void testTabMatcher() {
        final StrMatcher matcher = StrMatcher.tabMatcher();
        assertThat(StrMatcher.tabMatcher()).isSameAs(matcher);
        assertThat(matcher.isMatch(BUFFER1, 2)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 3)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 4)). isZero();
    }

    @Test
    void testTrimMatcher() {
        final StrMatcher matcher = StrMatcher.trimMatcher();
        assertThat(StrMatcher.trimMatcher()).isSameAs(matcher);
        assertThat(matcher.isMatch(BUFFER1, 2)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 3)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 4)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 5)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 6)). isZero();
        assertThat(matcher.isMatch(BUFFER1, 7)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 8)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 9)).isEqualTo(1);
        assertThat(matcher.isMatch(BUFFER1, 10)).isEqualTo(1);
    }

}
