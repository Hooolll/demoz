package com.jdc.pos.model.repo;

import com.jdc.pos.model.BaseRepository;
import com.jdc.pos.model.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends BaseRepository<Category, Integer> {

}
