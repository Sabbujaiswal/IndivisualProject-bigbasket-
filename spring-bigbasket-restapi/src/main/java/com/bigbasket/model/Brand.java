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
@Entity

public class Brand {
    @Id
    @GeneratedValue(generator = "brand_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "brand_seq", sequenceName = "brand_sequence", initialValue = 100, allocationSize = 1)
    private Integer brandId;

    @Column(length = 20)
    private String brandName;

    @OneToMany (cascade = CascadeType.ALL)   //this is a foreign key that will be added to items table;
    @JoinColumn(name = "brand_id")
    @JsonIgnore
    private Set<Items> items;


    public Brand(String brandName) {
        this.brandName = brandName;

    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandName='" + brandName + '\'' +
                ", items=" + items +
                '}';
    }
}
