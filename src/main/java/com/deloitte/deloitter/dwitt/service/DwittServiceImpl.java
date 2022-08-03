package com.deloitte.deloitter.dwitt.service;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import com.deloitte.deloitter.dwitt.repository.DwittRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class DwittServiceImpl implements IDwittService {

    @Autowired
    DwittRepository dwittRepository;

    @Override
    public Dwitt findDwittById(Long id) {
        return dwittRepository.findDwittById(id);
    }

    @Override
    public List<Dwitt> findAllByUserId(Long user_id) {
        if (dwittRepository.findAllByUserId(user_id) != null) {
            return dwittRepository.findAllByUserId(user_id);
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
    public Dwitt updateDwitt(Dwitt dwitt) {
        Dwitt upDwitt = dwittRepository.findDwittById(dwitt.getId());
        if (upDwitt != null) {
            upDwitt.setContent(dwitt.getContent());
            return dwittRepository.save(upDwitt);
        }
        throw new ResponseStatusException(NOT_FOUND, "unable to find dwitt with given id");
    }

    @Override
    public String deleteDwittById(Long id) {
        if (dwittRepository.findDwittById(id) != null) {
            dwittRepository.delete(findDwittById(id));
            return "dwitt deleted";
        }
        throw new ResponseStatusException(NOT_FOUND, "unable to find dwitt with given id");
    }


}
