package dev.sanjayjana.one_store.services.product;

import dev.sanjayjana.one_store.dto.ProductDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProducts(String organizationId, Pageable pageable);

    ProductDTO getProduct(String id, String organizationId);
}
