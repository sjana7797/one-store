package dev.sanjayjana.one_store.services.product;

import dev.sanjayjana.one_store.dto.ProductDTO;
import dev.sanjayjana.one_store.exceptions.NotFoundException;
import dev.sanjayjana.one_store.model.Product;
import dev.sanjayjana.one_store.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts(String organizationId, Pageable pageable) {
        List<Product> productList = productRepository.findAllByOrganizationId(organizationId, pageable);

        return productList.stream()
                .map(this::convertToDTO)
                .toList();

    }

    @Override
    public ProductDTO getProduct(String id, String organizationId) {
        var product = productRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        return this.convertToDTO(product);
    }


    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCreatedAt()
        );
    }
}
