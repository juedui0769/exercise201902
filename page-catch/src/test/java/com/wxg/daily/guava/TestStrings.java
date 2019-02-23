package com.wxg.daily.guava;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import static org.junit.Assert.*;

import com.google.common.primitives.Bytes;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * 2019年2月24日03:56:56
 * guava
 *
 * {@link Charsets#UTF_8}
 * {@link Strings#isNullOrEmpty(String)}
 *
 */
public class TestStrings {


    @Test
    public void test02() {
        String str = "123";
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        assertEquals("[49, 50, 51]", Arrays.toString(bytes));
    }

    @Test
    public void test_isNullOrEmpty() {
        assertTrue(Strings.isNullOrEmpty(""));
        assertTrue(Strings.isNullOrEmpty(null));
        assertTrue(Strings.isNullOrEmpty("  ".trim()));
    }

}
