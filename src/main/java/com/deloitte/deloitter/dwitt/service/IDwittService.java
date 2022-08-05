package com.deloitte.deloitter.dwitt.service;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import com.deloitte.deloitter.mapstruct.dtos.DwittDto;

import java.util.List;

public interface IDwittService {

    DwittDto findDwittById(Long id);

    List<DwittDto> findAllByUserId(Long user_id);

    Dwitt saveDwitt(Dwitt dwitt);

    Dwitt updateDwitt(Dwitt dwitt);

//    String deleteDwittById(Long id);
}
