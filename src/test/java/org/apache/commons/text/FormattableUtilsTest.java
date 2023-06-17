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

import static java.util.FormattableFlags.LEFT_JUSTIFY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Formattable;
import java.util.Formatter;

import org.junit.jupiter.api.Test;

/**
 * Unit tests {@link FormattableUtils}.
 */
public class FormattableUtilsTest {

    static class SimplestFormattable implements Formattable {
        private final String text;

        SimplestFormattable(final String text) {
            this.text = text;
        }

        @Override
        public void formatTo(final Formatter formatter, final int flags, final int width, final int precision) {
            formatter.format(text);
        }
    }

    private Formatter createFormatter() {
        return new Formatter();
    }

    @Test
    public void testAlternatePadCharacter() {
        final char pad = '_';
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, -1, pad)).hasToString("foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, 2, pad)).hasToString("fo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 4, -1, pad)).hasToString("_foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 6, -1, pad)).hasToString("___foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 3, 2, pad)).hasToString("_fo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 5, 2, pad)).hasToString("___fo");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 4, -1, pad)).hasToString("foo_");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 6, -1, pad)).hasToString("foo___");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 3, 2, pad)).hasToString("fo_");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 5, 2, pad)).hasToString("fo___");
    }

    @Test
    public void testAlternatePadCharAndEllipsis() {
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, -1, '_', "*")).hasToString("foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, 2, '_', "*")).hasToString("f*");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 4, -1, '_', "*")).hasToString("_foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 6, -1, '_', "*")).hasToString("___foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 3, 2, '_', "*")).hasToString("_f*");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 5, 2, '_', "*")).hasToString("___f*");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 4, -1, '_', "*")).hasToString("foo_");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 6, -1, '_', "*")).hasToString("foo___");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 3, 2, '_', "*")).hasToString("f*_");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 5, 2, '_', "*")).hasToString("f*___");

        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, -1, '_', "+*")).hasToString("foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, 2, '_', "+*")).hasToString("+*");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 4, -1, '_', "+*")).hasToString("_foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 6, -1, '_', "+*")).hasToString("___foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 3, 2, '_', "+*")).hasToString("_+*");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 5, 2, '_', "+*")).hasToString("___+*");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 4, -1, '_', "+*")).hasToString("foo_");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 6, -1, '_', "+*")).hasToString("foo___");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 3, 2, '_', "+*")).hasToString("+*_");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 5, 2, '_', "+*")).hasToString("+*___");
    }

    @Test
    public void testAppendWithNullFormatterAndIntsThrowsNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> FormattableUtils.append("", null, 0, 0, 0, '}'));
    }

    @Test
    public void testDefaultAppend() {
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, -1)).hasToString("foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, 2)).hasToString("fo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 4, -1)).hasToString(" foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 6, -1)).hasToString("   foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 3, 2)).hasToString(" fo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 5, 2)).hasToString("   fo");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 4, -1)).hasToString("foo ");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 6, -1)).hasToString("foo   ");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 3, 2)).hasToString("fo ");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 5, 2)).hasToString("fo   ");
    }

    @Test
    public void testEllipsis() {
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, -1, "*")).hasToString("foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, 2, "*")).hasToString("f*");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 4, -1, "*")).hasToString(" foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 6, -1, "*")).hasToString("   foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 3, 2, "*")).hasToString(" f*");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 5, 2, "*")).hasToString("   f*");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 4, -1, "*")).hasToString("foo ");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 6, -1, "*")).hasToString("foo   ");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 3, 2, "*")).hasToString("f* ");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 5, 2, "*")).hasToString("f*   ");

        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, -1, "+*")).hasToString("foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, -1, 2, "+*")).hasToString("+*");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 4, -1, "+*")).hasToString(" foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 6, -1, "+*")).hasToString("   foo");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 3, 2, "+*")).hasToString(" +*");
        assertThat(FormattableUtils.append("foo", createFormatter(), 0, 5, 2, "+*")).hasToString("   +*");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 4, -1, "+*")).hasToString("foo ");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 6, -1, "+*")).hasToString("foo   ");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 3, 2, "+*")).hasToString("+* ");
        assertThat(FormattableUtils.append("foo", createFormatter(), LEFT_JUSTIFY, 5, 2, "+*")).hasToString("+*   ");
    }

    @Test
    public void testIllegalEllipsis() {
        assertThatIllegalArgumentException().isThrownBy(() -> FormattableUtils.append("foo", createFormatter(), 0, -1, 1, "xx"));
    }

    @Test
    public void testIllegalEllipsisWith7Args() {
        final String ellipsis = "xxxx";
        final int precisionLessThanEllipsisLength = ellipsis.length() - 1;
        assertThatIllegalArgumentException().isThrownBy(() -> FormattableUtils.append("foo", createFormatter(), 0, 0,
                precisionLessThanEllipsisLength, '}', ellipsis));
    }

    @Test
    public void testPublicConstructorExists() {
        assertDoesNotThrow(() -> new FormattableUtils());
    }

    @Test
    public void testSimplestFormat() {
        final Formattable formattable = new SimplestFormattable("foo");

        assertThat(FormattableUtils.toString(formattable)).isEqualTo("foo");
    }

}
