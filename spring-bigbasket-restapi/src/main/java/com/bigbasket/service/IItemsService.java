package com.bigbasket.service;

import com.bigbasket.exceptions.ItemsNotFoundException;
import com.bigbasket.model.Items;

import java.util.List;
import java.util.Optional;

public interface IItemsService {
    Items addItems(Items items);

    void updateItems(Items items);

    void deleteItems(int itemId);

    Items getById(int itemId) throws ItemsNotFoundException;


    //query table
    List<Items> getAll();

    List<Items> getByPrice(double price) throws ItemsNotFoundException;

    List<Items> getByDesc(String description) throws ItemsNotFoundException;

    List<Items> getByItemNameAndQuantity(String itemName, String quantity) throws ItemsNotFoundException;

    List<Items> getByBrand(String brandName) throws ItemsNotFoundException;

    List<Items> getByCategory(String categoryName) throws ItemsNotFoundException;

    List<Items> getByCategoryAndBrand(String category, String brandName) throws ItemsNotFoundException;
    List<Items> getByItemNameAndBrand(String itemName, String brandName) throws ItemsNotFoundException;

}
