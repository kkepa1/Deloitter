package com.deloitte.deloitter.dwitt.controller;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import com.deloitte.deloitter.dwitt.service.IDwittService;
import com.deloitte.deloitter.mapstruct.dtos.DwittDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/dwitts")
public class DwittController {

    @Autowired
    IDwittService dwittService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DwittDto> getDwitt(@PathVariable Long id) {
        DwittDto foundDwitt = dwittService.findDwittById(id);
        if (foundDwitt == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundDwitt, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<DwittDto>> getDwittsByUser(@RequestParam("userId") Long userId) {
        List<DwittDto> foundDwitts = dwittService.findAllByUserId(userId);
        if (foundDwitts.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundDwitts, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Dwitt> postDwitt(@Valid @RequestBody Dwitt dwitt) {
        return new ResponseEntity<>(
                dwittService.saveDwitt(dwitt),
                HttpStatus.OK
        );
    }

    @PutMapping(value = "")
    public ResponseEntity<DwittDto> updateDwitt(@Valid @RequestBody Dwitt dwitt) {
        return new ResponseEntity<>(
                dwittService.updateDwitt(dwitt),
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/{id}")
    public String deleteDwitt(@PathVariable Long id) {
        return dwittService.deleteDwittById(id);
    }
}
