package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioItemService {

    @Autowired
    private PortfolioItemRepository repository;

    public List<PortfolioItem> getAllItems() {
        return repository.findAll();
    }

    public Optional<PortfolioItem> getItemById(Long id) {
        return repository.findById(id);
    }

    public PortfolioItem createItem(PortfolioItem item) {
        return repository.save(item);
    }

    public PortfolioItem updateItem(Long id, PortfolioItem updatedItem) {
        return repository.findById(id).map(item -> {
            item.setTitle(updatedItem.getTitle());
            item.setDescription(updatedItem.getDescription());
            item.setImageUrl(updatedItem.getImageUrl());
            item.setLink(updatedItem.getLink());
            return repository.save(item);
        }).orElseGet(() -> {
            updatedItem.setId(id);
            return repository.save(updatedItem);
        });
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public List<PortfolioItem> searchItems(String query) {
        return repository.findByTitleContainingOrDescriptionContaining(query, query);
    }
}
