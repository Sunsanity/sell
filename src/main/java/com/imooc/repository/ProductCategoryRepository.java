package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hasee on 2017/9/6.
 * 类目持久层
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
