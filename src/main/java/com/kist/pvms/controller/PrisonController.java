package com.kist.pvms.controller;

import com.kist.pvms.domain.*;
import com.kist.pvms.dto.AdminDto;
import com.kist.pvms.dto.PrisonVisitingPlanDto;
import com.kist.pvms.dto.SecurityGuardDto;
import com.kist.pvms.service.AccountService;
import com.kist.pvms.service.PrisonService;
import com.kist.pvms.service.PrisonVisitingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@RestController
@RequestMapping(value = "/pvms/api/v1/prisons")
public class PrisonController {

    @Autowired
    private PrisonService prisonService;

    @Autowired
    private PrisonVisitingPlanService prisonVisitingPlanService;

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/")
    public ResponseEntity<?> registerPrison(@RequestBody Prison prison){
        return new ResponseEntity<Prison>(prisonService.registerPrison(prison), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllPrisons(){
        return new ResponseEntity<List<Prison>>(prisonService.findAllPrisons(), HttpStatus.OK);
    }

    @PostMapping(value = "/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminDto adminDto){
        return new ResponseEntity<AdminDto>(prisonService.registerAdmin(adminDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/admins/{prisonId}")
    public ResponseEntity<?> getAdminsByPrison(@PathVariable String prisonId){
        return new ResponseEntity<List<Admin>>(prisonService.findAdminsByPrison(prisonId), HttpStatus.OK);
    }

    @PostMapping(value = "/security-guard")
    public ResponseEntity registerSecurityGuard(@RequestBody SecurityGuardDto securityGuardDto){
        this.prisonService.registerSecurityGuard(securityGuardDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/security-guards/{prisonId}")
    public ResponseEntity<?> getGuardsByPrison(@PathVariable String prisonId){
        return new ResponseEntity<List<SecurityGuard>>(prisonService.findSecurityGuardsByPrison(prisonId), HttpStatus.OK);
    }

    @PostMapping(value = "/prison-visit-plan")
    public ResponseEntity<?> rergisterVisitPlan(@RequestBody PrisonVisitingPlanDto prisonVisitingPlan){
        return new ResponseEntity<PrisonVisitingPlan>(this.prisonVisitingPlanService.registerPrisonVisitingPlan(prisonVisitingPlan), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{prisonId}/prison-visit-plans/")
    public ResponseEntity<?> getPlansByPrison(@PathVariable String prisonId){
        return new ResponseEntity<List<PrisonVisitingPlan>>(this.prisonVisitingPlanService.findByPrison(prisonId), HttpStatus.OK);
    }

    @GetMapping(value = "/account/{username}/{password}")
    public ResponseEntity<?> getUser(@PathVariable String username, @PathVariable String password){
        return new ResponseEntity<List<Account>>(this.accountService.findByUsernameAndPassword(username, password), HttpStatus.OK);
    }

}
