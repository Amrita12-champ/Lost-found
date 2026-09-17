package com.amrita.lostfoundbackend.controller;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import com.amrita.lostfoundbackend.entity.Item;
import com.amrita.lostfoundbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin("*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Add Item
    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    // Get All Items
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // Delete Item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    // Update Item
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id,
                           @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {

        String uploadDir = System.getProperty("user.dir") + "/uploads/";
        File directory = new File(uploadDir);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        File destination = new File(uploadDir + fileName);
        file.transferTo(destination);

        return fileName;

    }
}