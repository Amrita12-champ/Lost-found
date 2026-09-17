package com.amrita.lostfoundbackend.repository;

import com.amrita.lostfoundbackend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}