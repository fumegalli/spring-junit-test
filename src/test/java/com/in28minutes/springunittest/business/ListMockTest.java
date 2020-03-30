package com.in28minutes.springunittest.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    private List<String> mock = mock(List.class);

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

    @Test
    public void verificationBasics() {
        //SUT System Under Test
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        // SUT
        mock.add("Some String");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("Some String", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        // SUT
        mock.add("Some String 1");
        mock.add("Some String 2");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> values = captor.getAllValues();

        assertEquals("Some String 1", values.get(0));
        assertEquals("Some String 2", values.get(1));
    }


    // Não guarda o comportamento anterior
    @Test
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        arrayListMock.get(0); // Null
        arrayListMock.size(); // 0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        arrayListMock.size(); // 0
        when(arrayListMock.size()).thenReturn(5);
        arrayListMock.size(); // 5
    }


    // Guarda o comportamento anterior
    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        arrayListSpy.get(0); // Test0
        arrayListSpy.size(); // 1
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        arrayListSpy.size(); // 3

        when(arrayListSpy.size()).thenReturn(5);
        arrayListSpy.size(); // 5

        arrayListSpy.add("Test3");
        arrayListSpy.size(); // 5

        verify(arrayListSpy).add("Test3");
    }


}
