package com.in28minutes.springunittest.business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    private List mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);

        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);

        assertEquals(5, mock.size());
        assertEquals(10, mock.size());

    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("in28minutes");

        assertEquals("in28minutes", mock.get(0));
        assertNull(mock.get(1));

    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("in28minutes");

        assertEquals("in28minutes", mock.get(0));
        assertEquals("in28minutes", mock.get(1));

    }
}
