package com.in28minutes.springunittest.business;

import com.in28minutes.springunittest.data.ItemRepository;
import com.in28minutes.springunittest.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService service;

    @Mock
    private ItemRepository repository;

    @Test
    public void retrieveHardcodedItem_basic() {
        Item result = service.retrieveHardcodedItem();
        Item expectedItem = new Item(1, "Ball", 10, 100);

        assertEquals(expectedItem, result);
    }

    @Test
    public void retrieveAllItems_basic() {
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Item(1, "Item1", 5, 2),
                new Item(2, "Item2", 10, 2)
        ));

        List<Item> items = service.retrieveAllItems();

        int expectedValueFromFistItem = 10;
        int expectedValueFromSecondItem = 20;

        assertEquals(expectedValueFromFistItem, items.get(0).getValue());
        assertEquals(expectedValueFromSecondItem, items.get(1).getValue());
    }

    @Test
    public void retrieveAllItems_withNoItem() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        List<Item> items = service.retrieveAllItems();

        int expectedListSize = 0;

        assertEquals(expectedListSize, items.size());
    }
}