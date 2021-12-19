package com.bigbasket.controllers;

import com.bigbasket.model.Items;
import com.bigbasket.service.IItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items-response-api")
public class ItemResponseControllers {
    private IItemsService itemsService;
    private Logger logger= LoggerFactory.getLogger(ItemResponseControllers.class);


    @Autowired

    public void setItemsService(IItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @PostMapping("/items/add")

    ResponseEntity<Items> addItems(@RequestBody Items items) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding new items");
        Items nItems = itemsService.addItems(items);
        logger.info("Items added successfully" +nItems);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(nItems);
    }

    @PutMapping("/items/update")
    ResponseEntity<Void> updateItems(@RequestBody Items items) {
        itemsService.updateItems(items);

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding new items");
        itemsService.updateItems(items);

        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }


    @DeleteMapping("/items/del/{itemId}")
    ResponseEntity<Void>deleteItems(@PathVariable("itemId") int itemId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting Items");
        itemsService.deleteItems(itemId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }


    @GetMapping("/items/itemId/{itemId}")
    public ResponseEntity<Items>getById(@PathVariable("itemId") int itemId) {
        logger.debug("inside get items by id method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All items");
        headers.add("info", "Item details");
        List<Items> items = itemsService.getAll();
        Items item = itemsService.getById(itemId);
        logger.info("Got one item "+item);
        return ResponseEntity.ok().headers(headers).body(item);
    }


    @GetMapping("/items")
   ResponseEntity<List<Items>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");
        List<Items> items = itemsService.getAll();

        ResponseEntity<List<Items>> itemResponse = new ResponseEntity(items, headers, HttpStatus.OK);

        return itemResponse;
    }

    @GetMapping("/items/price/{price}")
   ResponseEntity<List<Items>> getByPrice(@PathVariable("price") double price) {
        List<Items> items = itemsService.getByPrice(price);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All items");
        headers.add("info", "Item details");

        return ResponseEntity.ok().headers(headers).body(items);
    }


    @GetMapping("/items/desc/{desc}")
    ResponseEntity<List<Items>> getByDesc(@PathVariable("desc") String description) {
        List<Items> items = itemsService.getByDesc(description);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All items");
        headers.add("info", "Item details");

        return ResponseEntity.ok().headers(headers).body(items);
    }

    @GetMapping("/items/itemName/{itemName}/quantity/{quantity}")
    ResponseEntity<List<Items>> getByItemNameAndQuantity(@PathVariable("itemName") String itemName, @PathVariable("quantity") String quantity) {
        List<Items> items = itemsService.getByItemNameAndQuantity(itemName, quantity);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All items");
        headers.add("info", "Item details");

        return ResponseEntity.ok().headers(headers).body(items);
    }

    @GetMapping("/items/brand/{brand}")
    ResponseEntity<List<Items>> getByBrand(@PathVariable("brand") String brandName) {
        List<Items> items = itemsService.getByBrand(brandName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All items");
        headers.add("info", "Item details");

        return ResponseEntity.ok().headers(headers).body(items);
    }


    @GetMapping("/items/category/{category}")
   ResponseEntity<List<Items>> getByCategory(@PathVariable("category") String categoryName) {
        List<Items> items = itemsService.getByCategory(categoryName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All items");
        headers.add("info", "Item details");

        return ResponseEntity.ok().headers(headers).body(items);
    }



    @GetMapping("items/category/{category}/brand/{brand}")
   ResponseEntity<List<Items>> getByCategoryAndBrand(@PathVariable("category") String category, @PathVariable("brand") String brandName) {
        List<Items> items = itemsService.getByCategoryAndBrand(category, brandName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All items");
        headers.add("info", "Item details");

        return ResponseEntity.ok().headers(headers).body(items);
    }


    @GetMapping("/items/itemName/{itemName}/brand/{brandName}")
   ResponseEntity<List<Items>> getByItemNameAndBrand(@PathVariable("itemName") String itemName, @PathVariable("brandName") String brandName) {
        List<Items> items = itemsService.getByItemNameAndBrand(itemName, brandName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All items");
        headers.add("info", "Item details");

        return ResponseEntity.ok().headers(headers).body(items);
    }
    }


