package com.bigbasket.model;

import lombok.*;


import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@Entity
@ToString
public class Details {
    @Id
    @GeneratedValue(generator = "details_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "details_seq", sequenceName = "details_sequence", initialValue = 1000, allocationSize = 10)
    private Integer detailsId;
    @Column(length = 20) //1kg,500gm etc
    private String quantity;

   private double price;

    @Column(length = 20,name="description")
  private String description;

    public Details(String quantity, double price, String description) {
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }
}
