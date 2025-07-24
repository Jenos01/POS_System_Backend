package com.example.demo.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Products> products;


    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference(value = "category-parent")
    private Category parent;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "category-parent")
    private List<Category> children;
}
