package com.kist.pvms.controller;

import com.kist.pvms.domain.Visitor;
import com.kist.pvms.domain.VisitorVisitingPlan;
import com.kist.pvms.dto.VisitorVisitingPlanDto;
import com.kist.pvms.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@RestController
@RequestMapping(value = "/pvms/api/v1/visitors")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;


    @PostMapping(value = "/")
    public ResponseEntity<?> registerVisitor(@RequestBody Visitor visitor){
        return new ResponseEntity<Visitor>(this.visitorService.registerVisitor(visitor), HttpStatus.CREATED);
    }

    @PostMapping(value = "/add-visit-request")
    public ResponseEntity<?> registerVisitorVisitingPlan(@RequestBody VisitorVisitingPlanDto visitorVisitingPlanDto){
        return new ResponseEntity<VisitorVisitingPlanDto>(this.visitorService.registerVisitorVisitingPlan(visitorVisitingPlanDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/prison/{prisonId}")
    public ResponseEntity<?> getVisitorsPerPrison(@PathVariable String prisonId){
        return new ResponseEntity<List<Visitor>>(this.visitorService.findVisitorsByPrison(prisonId),HttpStatus.OK);
    }

    @GetMapping(value = "/visit-requests/prison/{prisonId}/date/{vDate}")
    public ResponseEntity<?> getVisitorsPerPrison(@PathVariable String vDate, @PathVariable String prisonId) throws ParseException {
        return new ResponseEntity<List<VisitorVisitingPlan>>(this.visitorService.findVisitPlanByVisitDateAndPrison(vDate, prisonId),HttpStatus.OK);
    }

}
