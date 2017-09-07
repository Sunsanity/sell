package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hasee on 2017/9/6.
 * 类目持久层
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

}
