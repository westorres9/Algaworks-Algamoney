package com.algaworks.algamoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algamoney.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
