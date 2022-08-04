package com.deloitte.deloitter.dwitt.controller;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import com.deloitte.deloitter.dwitt.service.IDwittService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/dwitts")
public class DwittController {

    @Autowired
    IDwittService dwittService;

    @GetMapping(value = "/{id}")
    public Dwitt getDwitt(@PathVariable Long id) {
        return dwittService.findDwittById(id);
    }

    @GetMapping(value = "")
    public List<Dwitt> getDwittsByUser(@RequestParam("userId") Long userId) {
        return dwittService.findAllByUserId(userId);
    }

    @PostMapping(value = "")
    public Dwitt postDwitt(@Valid @RequestBody Dwitt dwitt) {
        return dwittService.saveDwitt(dwitt);
    }
}
