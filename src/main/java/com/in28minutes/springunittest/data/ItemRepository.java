package com.in28minutes.springunittest.data;

import com.in28minutes.springunittest.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
