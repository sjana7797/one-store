package dev.sanjayjana.one_store.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(description = "Product Data Transfer Object")
public class ProductDTO {
    @Schema(description = "Unique identifier of the product")
    private String id;
    @Schema(description = "Name of the product", example = "Laptop")
    private String name;
    private String description;
    private LocalDateTime createdAt;
}
