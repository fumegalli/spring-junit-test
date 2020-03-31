package com.in28minutes.springunittest.business;

import com.in28minutes.springunittest.controller.request.ItemRequest;
import com.in28minutes.springunittest.controller.response.ItemResponse;
import com.in28minutes.springunittest.data.ItemRepository;
import com.in28minutes.springunittest.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = repository.findAll();

        for (Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }

        return items;
    }

    public ItemResponse createItem(ItemRequest request) {
        Item lastItemCreated = repository.findFirstByOrderById();
        int id = lastItemCreated.getId() + 1;

        Item item = new Item(id, request.getName(), request.getPrice(), request.getQuantity());

        repository.save(item);

        ItemResponse response = new ItemResponse(item);
        response.setValue(item.getPrice() * item.getQuantity());

        return response;
    }
}
