package com.bigbasket;

import com.bigbasket.model.Brand;
import com.bigbasket.model.Category;
import com.bigbasket.model.Details;
import com.bigbasket.model.Items;
import com.bigbasket.service.IBrandService;
import com.bigbasket.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class SpringBigbasketRestapiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBigbasketRestapiApplication.class, args);
    }

    @Autowired
    private IItemsService itemsService;

    @Autowired
    private IBrandService brandService;


    @Override
    public void run(String... args) throws Exception {

//        Brand brand = new Brand("Red-label");
//
//
//       Category categories1 = new Category("Beverages");
//
//        Set<Category> categoriesSet = new HashSet<>(Arrays.asList(categories1));
//        Details details = new Details("1kg", 600, "for mind-fresh");
//        Items items = new Items("tea", brand, categoriesSet, details);
//
//        System.out.println(itemsService.addItems(items));


    }
}

