package com.in28minutes.springunittest.business;

import com.in28minutes.springunittest.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}