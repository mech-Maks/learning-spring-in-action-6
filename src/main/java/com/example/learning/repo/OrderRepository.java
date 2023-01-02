package com.example.learning.repo;

import com.example.learning.entity.TacoOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    @Query("select o from TacoOrder o where o.deliveryCity='Seattle'")
    List<TacoOrder> readOrdersDeliveredInSeattle();
}
