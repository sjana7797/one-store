package dev.sanjayjana.one_store.services.product;

import dev.sanjayjana.one_store.entities.Product;
import dev.sanjayjana.one_store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(String organizationId, Pageable pageable) {
        return productRepository.findAllByOrganizationId(organizationId, pageable);
    }

    @Override
    public Product getProduct(String id) {
        return null;
    }
}
