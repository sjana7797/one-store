package dev.sanjayjana.one_store.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    private String id;

    private String name;
    private String description;

    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    @ManyToOne
    private Organization organization;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
