package com.example.learning.repo;

import com.example.learning.model.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
