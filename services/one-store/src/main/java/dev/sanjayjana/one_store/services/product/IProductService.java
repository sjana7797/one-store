package dev.sanjayjana.one_store.services.product;

import dev.sanjayjana.one_store.entities.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts(String organizationId, Pageable pageable);

    Product getProduct(String id);
}
