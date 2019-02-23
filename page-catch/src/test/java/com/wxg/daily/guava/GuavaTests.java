package com.wxg.daily.guava;

import com.google.common.base.Objects;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class GuavaTests {


    /**
     * https://github.com/google/guava/wiki/CommonObjectUtilitiesExplained
     */
    @Test
    public void test_Objects() {
        Assert.assertTrue(Objects.equal("a", "a"));
    }


    /**
     * https://github.com/google/guava/wiki/UsingAndAvoidingNullExplained#optional
     */
    @Test
    public void test_Optional() {
        Optional<Integer> possible = Optional.of(5);
        Assert.assertTrue(possible.isPresent());
        int integer = possible.get();
        Assert.assertEquals(5, integer);
    }
}
