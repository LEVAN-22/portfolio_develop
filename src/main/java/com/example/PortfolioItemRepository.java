package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
	List<PortfolioItem> findByTitleContainingOrDescriptionContaining(String title, String description);
}
