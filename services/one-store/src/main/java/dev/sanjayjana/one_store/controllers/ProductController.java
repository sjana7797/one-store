package dev.sanjayjana.one_store.controllers;


import dev.sanjayjana.one_store.entities.Product;
import dev.sanjayjana.one_store.responses.ApiResponse;
import dev.sanjayjana.one_store.responses.SuccessApiResponse;
import dev.sanjayjana.one_store.routes.ProductRoute;
import dev.sanjayjana.one_store.services.product.IProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(ProductRoute.BASE_URL)
@Tag(name = "Product")
@Validated
public class ProductController {
    private final IProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProduct(
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "10", name = "size") int size,
            @RequestParam(defaultValue = "id,asc", name = "sort") String[] sort,
            @RequestParam(name = "organizationId") @NotNull @NotBlank String organizationId
    ) {
        System.out.println("data" + page + sort.toString() + organizationId + size);
        Sort.Direction direction = sort[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));
        List<Product> products = productService.getAllProducts(organizationId, pageable);

        ApiResponse<List<Product>> apiResponse = new SuccessApiResponse<List<Product>>(
                products, "Product has been fetched successfully"
        );

        return ResponseEntity.ok(apiResponse);
    }
}
