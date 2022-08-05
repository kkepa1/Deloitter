package com.deloitte.deloitter.dwitt.service;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import com.deloitte.deloitter.dwitt.repository.DwittRepository;
import com.deloitte.deloitter.mapstruct.dtos.DwittDto;
import com.deloitte.deloitter.mapstruct.mapper.MapStructMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class DwittServiceImpl implements IDwittService {

    private DwittRepository dwittRepository;

    private MapStructMapper mapStructMapper;

    @Autowired
    public DwittServiceImpl(DwittRepository dwittRepository, MapStructMapper mapStructMapper) {
        this.dwittRepository = dwittRepository;
        this.mapStructMapper = mapStructMapper;
    }


    @Override
    public DwittDto findDwittById(Long id) {
        return mapStructMapper.dwittToDwittDto(dwittRepository.findDwittById(id));
    }

    @Override
    public List<DwittDto> findAllByUserId(Long user_id) {
        if (dwittRepository.findAllByUserId(user_id) != null) {
            return mapStructMapper.dwittsToDwittDtoList(dwittRepository.findAllByUserId(user_id));
        }
        throw new ResponseStatusException(NOT_FOUND, "unable to find dwitts with given user_id");
    }

    @Override
    public Dwitt saveDwitt(Dwitt dwitt) {
        if (dwittRepository.findDwittById(dwitt.getId()) == null) {
            return dwittRepository.save(dwitt);
        } else {
            throw new ResponseStatusException(NOT_FOUND, "unable to find dwitt with given id");
        }
    }

    @Override
    public DwittDto updateDwitt(Dwitt dwitt) {
        Dwitt upDwitt = dwittRepository.findDwittById(dwitt.getId());
        if (upDwitt != null) {
            upDwitt.setContent(dwitt.getContent());
            return mapStructMapper.dwittToDwittDto(dwittRepository.save(upDwitt));
        }
        throw new ResponseStatusException(NOT_FOUND, "unable to find dwitt with given id");
    }

    @Override
    public String deleteDwittById(Long id) {
        if (dwittRepository.findDwittById(id) != null) {
            dwittRepository.delete(dwittRepository.findDwittById(id));
            return "dwitt deleted";
        }
        throw new ResponseStatusException(NOT_FOUND, "unable to find dwitt with given id");
    }


}
