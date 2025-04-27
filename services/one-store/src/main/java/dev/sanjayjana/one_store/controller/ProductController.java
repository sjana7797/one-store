package dev.sanjayjana.one_store.controller;


import dev.sanjayjana.one_store.dto.ProductDTO;
import dev.sanjayjana.one_store.enums.route.ProductRoute;
import dev.sanjayjana.one_store.response.ApiResponse;
import dev.sanjayjana.one_store.response.SuccessApiResponse;
import dev.sanjayjana.one_store.services.product.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(ProductRoute.BASE_URL)
@Tag(name = "Product")
@Validated
public class ProductController {
    private final IProductService productService;

    @GetMapping
    @Operation(summary = "Find Products", description = "Retrieves a products")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProduct(
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "10", name = "size") int size,
            @RequestParam(defaultValue = "id,asc", name = "sort") String[] sort,
            @RequestParam(name = "organizationId") @NotNull @NotBlank String organizationId
    ) {
        Sort.Direction direction = sort[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));
        List<ProductDTO> products = productService.getAllProducts(organizationId, pageable);

        ApiResponse<List<ProductDTO>> apiResponse = new SuccessApiResponse<>(
                products, "Product has been fetched successfully"
        );

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a Product by ID", description = "Retrieves a product based on their unique identifier")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductDetail(@PathVariable(name = "id") String id, @RequestParam String organizationId) {
        var product = productService.getProduct(id, organizationId);
        ApiResponse<ProductDTO> apiResponse = new SuccessApiResponse<>(product, "Product fetched successfully");

        return ResponseEntity.ok(apiResponse);
    }
}
