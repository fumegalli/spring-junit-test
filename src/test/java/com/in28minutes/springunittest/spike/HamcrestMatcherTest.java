package com.in28minutes.springunittest.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatcherTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);

        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(12, 15));
        assertThat(numbers, everyItem(greaterThan(10)));

        assertThat("", emptyString());
        assertThat("ABC", containsString("B"));
    }
}
