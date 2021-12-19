package com.bigbasket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(generator = "category_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "category_seq", sequenceName = "category_sequence", initialValue = 51, allocationSize = 1)
    private Integer categoryId;

    private String categoryName;    //foodgrains,masala,bakingNeeds,dairy;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    Set<Items> items;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }
}


