package com.vintagevault.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vintagevault.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}