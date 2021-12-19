package com.bigbasket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Items {
    @Id
    @GeneratedValue(generator = "items_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "items_seq", sequenceName = "items_sequence", initialValue = 100, allocationSize = 1)
    private Integer itemId;

    @Column(length = 20)
    private String itemName;      //sugar,powder

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    Brand brand;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Category> categories;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    Details details;

    public Items(String itemName, Brand brand, Set<Category> categories, Details details) {
        this.itemName = itemName;
        this.categories = categories;
        this.details = details;
        this.brand = brand;
    }

}

