package com.in28minutes.springunittest.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);

        assertThat(numbers)
                .hasSize(3)
                .contains(45, 12)
                .allMatch(number -> number > 10)
                .allMatch(number -> number < 100)
                .noneMatch(number -> number < 0);

        assertThat("").isEmpty();
        assertThat("ABCDE")
                .contains("BC")
                .startsWith("AB")
                .endsWith("E");

    }
}
