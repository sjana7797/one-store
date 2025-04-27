package dev.sanjayjana.one_store.repositories;


import dev.sanjayjana.one_store.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    public List<Product> findAllByOrganizationId(String organizationId, Pageable pageable);
}
