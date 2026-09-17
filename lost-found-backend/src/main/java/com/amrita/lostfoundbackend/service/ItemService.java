package com.amrita.lostfoundbackend.service;

import com.amrita.lostfoundbackend.entity.Item;
import com.amrita.lostfoundbackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Save Item
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    // Get All Items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Delete Item
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    // Update Item
    public Item updateItem(Long id, Item updatedItem) {

        Item item = itemRepository.findById(id).orElse(null);

        if (item != null) {
            item.setItemName(updatedItem.getItemName());
            item.setCategory(updatedItem.getCategory());
            item.setDescription(updatedItem.getDescription());
            item.setLocation(updatedItem.getLocation());
            item.setType(updatedItem.getType());
            item.setStatus(updatedItem.getStatus());

            return itemRepository.save(item);
        }

        return null;
    }
}
