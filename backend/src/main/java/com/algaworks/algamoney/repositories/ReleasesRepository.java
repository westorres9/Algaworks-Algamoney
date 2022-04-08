package com.algaworks.algamoney.repositories;

import com.algaworks.algamoney.entities.Releases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleasesRepository extends JpaRepository<Releases, Long> {
}
