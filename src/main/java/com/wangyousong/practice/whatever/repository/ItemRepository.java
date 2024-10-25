package com.wangyousong.practice.whatever.repository;

import com.wangyousong.practice.whatever.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
