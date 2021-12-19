package com.bigbasket.repository;

import com.bigbasket.exceptions.ItemsNotFoundException;
import com.bigbasket.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IItemRepository extends JpaRepository<Items, Integer> {

    @Query("from Items i inner join i.details d where d.price <= ?1")
    List<Items> getByPrice(double price) throws ItemsNotFoundException;

    @Query("from Items i inner join i.details d where d.description LIKE %?1% ")
    List<Items> getByDesc(String description) throws ItemsNotFoundException;

    @Query("from Items i inner join i.details d where i.itemName=?1 and d.quantity=?2")
     List<Items>getByItemNameAndQuantity(String itemName,String quantity) throws ItemsNotFoundException;
//
    @Query("from Items i inner join i.brand b where b.brandName=?1")
    List<Items> getByBrand(String brandName) throws ItemsNotFoundException;

    @Query("from Items i inner join i.categories c where c.categoryName=?1")
    List<Items> getByCategory(String categoryName) throws ItemsNotFoundException;


    @Query("from Items i inner join i.categories c inner join i.brand b where c.categoryName=?1 and b.brandName =?2")
    List<Items> getByCategoryAndBrand(String category, String brandName) throws ItemsNotFoundException;

    @Query("from Items i inner join i.brand b where i.itemName=?1 and b.brandName=?2")
    List<Items> getByItemNameAndBrand(String itemName, String brandName) throws ItemsNotFoundException;


}
