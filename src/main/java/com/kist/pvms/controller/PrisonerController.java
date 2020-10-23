package com.kist.pvms.controller;

import com.kist.pvms.domain.CrimeCase;
import com.kist.pvms.domain.Prisoner;
import com.kist.pvms.dto.PrisonerDto;
import com.kist.pvms.service.PrisonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@RestController
@RequestMapping(value = "/pvms/api/v1/prisoners")
public class PrisonerController {

    @Autowired
    private PrisonerService prisonerService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> registerPrisoner(@RequestBody PrisonerDto prisonerDto){
        return new ResponseEntity<PrisonerDto>(prisonerService.registerPrisoner(prisonerDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/prison/{prisonId}")
    public ResponseEntity<?> getPrisonersByPrison(@PathVariable String prisonId){
        return new ResponseEntity<List<CrimeCase>>(prisonerService.findPrisonersByPrison(prisonId), HttpStatus.OK);
    }

    @GetMapping(value = "/{prisonerId}")
    public ResponseEntity<?> getPrisoner(@PathVariable String prisonerId){
        return new ResponseEntity<CrimeCase>(prisonerService.findOnePrisoner(prisonerId), HttpStatus.OK);
    }
}
