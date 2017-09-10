package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hasee on 2017/9/10.
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{

    //根据买家openid分页查询买家订单列表
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);

}
