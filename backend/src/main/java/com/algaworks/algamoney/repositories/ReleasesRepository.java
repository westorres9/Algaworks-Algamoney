package com.algaworks.algamoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algamoney.entities.Releases;

@Repository
public interface ReleasesRepository extends JpaRepository<Releases, Long> {
}
