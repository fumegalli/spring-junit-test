package com.in28minutes.springunittest.controller;

import com.in28minutes.springunittest.business.ItemBusinessService;
import com.in28minutes.springunittest.controller.request.ItemRequest;
import com.in28minutes.springunittest.controller.response.ItemResponse;
import com.in28minutes.springunittest.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return businessService.retrieveHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems() {
        return businessService.retrieveAllItems();
    }

    @PostMapping("/post-item")
    public ResponseEntity<ItemResponse> createItem(@RequestBody @Valid ItemRequest request) {
        ItemResponse dale = businessService.createItem(request);
        return new ResponseEntity<ItemResponse>(dale, HttpStatus.CREATED);
    }
}
