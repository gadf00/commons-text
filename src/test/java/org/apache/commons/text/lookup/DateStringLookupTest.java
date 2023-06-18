/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */

package org.apache.commons.text.lookup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * Tests {@link DateStringLookup}.
 */
class DateStringLookupTest {

    @Test
    void testBadFormat() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> DateStringLookup.INSTANCE.lookup("this-is-a-bad-format-dontcha-know"));
    }

    @Test
    void testDefault() throws ParseException {
        String formatted = DateStringLookup.INSTANCE.lookup(null);
        Assertions.assertNotNull(formatted);

        DateFormat df = DateFormat.getInstance();
        df.parse(formatted);
    }

    @Test
    void testFormat() {
        final String format = "yyyy-MM-dd";
        final String value = DateStringLookup.INSTANCE.lookup(format);
        // System.out.println(value);
        Assertions.assertNotNull(value, "No Date");
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        final String today = simpleDateFormat.format(new Date());
        Assertions.assertEquals(value, today);

    }

    @Test
    void testToString() {
        // does not blow up and gives some kind of string.
        Assertions.assertFalse(DateStringLookup.INSTANCE.toString().isEmpty());
    }

}
