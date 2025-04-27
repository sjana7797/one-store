package dev.sanjayjana.one_store.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    private String id;

    private String name;

    private String slug;

    private String logo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
