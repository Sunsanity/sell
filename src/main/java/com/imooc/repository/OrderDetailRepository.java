package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hasee on 2017/9/10.
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    //根据订单id查询订单项
    List<OrderDetail> findByOrderId(String orderId);
}
