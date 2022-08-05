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
        return new ResponseEntity<>(
                dwittService.findDwittById(id),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "")
    public ResponseEntity<List<DwittDto>> getDwittsByUser(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(
                dwittService.findAllByUserId(userId),
                HttpStatus.OK
        );
    }

    @PostMapping(value = "")
    public ResponseEntity<Dwitt> postDwitt(@Valid @RequestBody Dwitt dwitt) {
        return new ResponseEntity<>(
                dwittService.saveDwitt(dwitt),
                HttpStatus.OK
        );
    }
}
