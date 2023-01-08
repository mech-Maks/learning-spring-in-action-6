package com.example.learning.repo;

import com.example.learning.entity.TacoOrder;
import com.example.learning.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    @Query("select o from TacoOrder o where o.deliveryCity='Seattle'")
    List<TacoOrder> readOrdersDeliveredInSeattle();

    List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
