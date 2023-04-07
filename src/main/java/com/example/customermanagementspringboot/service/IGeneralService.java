package com.example.customermanagementspringboot.service;

import com.example.customermanagementspringboot.model.Customer;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    Customer save(T t);

    void remove(Long id);
}