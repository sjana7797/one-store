package dev.sanjayjana.one_store.repository;


import dev.sanjayjana.one_store.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    public List<Product> findAllByOrganizationId(String organizationId, Pageable pageable);

    public Optional<Product> findByIdAndOrganizationId(String id, String organizationId);
}
