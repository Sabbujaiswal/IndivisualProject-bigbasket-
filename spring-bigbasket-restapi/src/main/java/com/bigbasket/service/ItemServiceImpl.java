package com.bigbasket.service;

import com.bigbasket.controllers.ItemResponseControllers;
import com.bigbasket.exceptions.ItemsNotFoundException;
import com.bigbasket.model.Items;
import com.bigbasket.repository.IItemRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements IItemsService {
    private IItemRepository itemRepository;
    private Logger logger= LoggerFactory.getLogger(ItemResponseControllers.class);


    @Autowired
    public void setItemRepository(IItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Items addItems(Items items) {
        return itemRepository.save(items);
    }

    @Override
    public void updateItems(Items items) {
        itemRepository.save(items);
    }

    @Override
    public void deleteItems(int itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public Items getById(int itemId) throws ItemsNotFoundException {
        logger.debug("inside get items by id method in service layer");
        logger.info("calling get items by id method");
        return itemRepository.findById(itemId).orElseThrow(
                ()->{
                    logger.error("items not found");
                    throw new ItemsNotFoundException("not found");
                }
        );
    }

    @Override
    public List<Items> getAll() {
        logger.info("calling get all method ");
        return itemRepository.findAll();
    }

    @Override
    public List<Items> getByPrice(double price) throws ItemsNotFoundException {
        List<Items> items = itemRepository.getByPrice(price);
        logger.info("calling  items by price method");
        if (items.isEmpty()) throw new ItemsNotFoundException();
        return items;
    }

    @Override
    public List<Items> getByDesc(String description) throws ItemsNotFoundException {
        List<Items> items = itemRepository.getByDesc(description);
        logger.info("calling  items by Desc method");
        if (items.isEmpty()) throw new ItemsNotFoundException();
        return items;
    }

    @Override
    public List<Items> getByItemNameAndQuantity(String itemName, String quantity) throws ItemsNotFoundException {
        List<Items> items = itemRepository.getByItemNameAndQuantity(itemName, quantity);
        logger.info("calling items by ItemNameAndQuantity method");
        if (items.isEmpty()) throw new ItemsNotFoundException();
        return items;
    }


    @Override
    public List<Items> getByBrand(String brandName) throws ItemsNotFoundException {
        logger.info("calling items by brand method");
        List<Items> items = itemRepository.getByBrand(brandName);
        if (items.isEmpty()) throw new ItemsNotFoundException();
        return items;
    }

    @Override
    public List<Items> getByCategory(String categoryName) throws ItemsNotFoundException {
        logger.info("calling items by category method");
        List<Items> items = itemRepository.getByCategory(categoryName);
        if (items.isEmpty()) throw new ItemsNotFoundException();
        return items;
    }

    @Override
    public List<Items> getByCategoryAndBrand(String category, String brandName) throws ItemsNotFoundException {
        logger.info("calling items by CategoryAndBrand method");
        List<Items> items = itemRepository.getByCategoryAndBrand(category, brandName);
        if (items.isEmpty()) throw new ItemsNotFoundException();
        return items;
    }

    @Override
    public List<Items> getByItemNameAndBrand(String itemName, String brandName) throws ItemsNotFoundException {
        logger.info("calling items by ItemNameAndBrand method");
        List<Items> items = itemRepository.getByItemNameAndBrand(itemName, brandName);
        if (items.isEmpty()) throw new ItemsNotFoundException();
        return items;
    }
}


