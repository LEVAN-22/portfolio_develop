package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioItemController {

    @Autowired
    private PortfolioItemService service;

    @GetMapping
    public List<PortfolioItem> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<PortfolioItem> getItemById(@PathVariable Long id) {
        return service.getItemById(id);
    }

    @PostMapping
    public PortfolioItem createItem(@RequestBody PortfolioItem item) {
        return service.createItem(item);
    }

    @PutMapping("/{id}")
    public PortfolioItem updateItem(@PathVariable Long id, @RequestBody PortfolioItem updatedItem) {
        return service.updateItem(id, updatedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
    }

    @GetMapping("/search")
    public List<PortfolioItem> searchItems(@RequestParam String query) {
        return service.searchItems(query);
    }
}
