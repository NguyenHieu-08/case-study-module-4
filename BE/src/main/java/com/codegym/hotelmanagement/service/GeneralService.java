package com.codegym.hotelmanagement.service;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void deleteById(Long id);
}
