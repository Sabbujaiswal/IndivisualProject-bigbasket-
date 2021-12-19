package com.bigbasket.service;

import com.bigbasket.exceptions.BrandNotFoundException;
import com.bigbasket.model.Brand;

public interface IBrandService {
    Brand addBrand(Brand brand);
    void updateBrand(Brand brand);
    void deleteBrand(int brandId);

}
