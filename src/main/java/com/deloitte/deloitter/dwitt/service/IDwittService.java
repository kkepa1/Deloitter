package com.deloitte.deloitter.dwitt.service;

import com.deloitte.deloitter.dwitt.entity.Dwitt;

import java.util.List;

public interface IDwittService {

    Dwitt findDwittById(Long id);

    List<Dwitt> findAllByUserId(Long user_id);

    Dwitt saveDwitt(Dwitt dwitt);

    Dwitt updateDwitt(Dwitt dwitt);

    String deleteDwittById(Long id);
}
