package com.kist.pvms.service;

import com.kist.pvms.domain.CrimeCase;
import com.kist.pvms.domain.PrisonVisitingPlan;
import com.kist.pvms.domain.Visitor;
import com.kist.pvms.domain.VisitorVisitingPlan;
import com.kist.pvms.dto.PrisonerDto;
import com.kist.pvms.dto.VisitorVisitingPlanDto;
import com.kist.pvms.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Service
public class VisitorService {

    @Autowired
    private VisitorVisitingPlanRepository visitorVisitingPlanRepository;

    @Autowired
    private PrisonerRepository prisonerRepository;

    @Autowired
    private PrisonVisitingPlanRepository prisonVisitingPlanRepository;

    @Autowired
    private VisitorRepository visitorRepository;

    public Visitor registerVisitor(Visitor visitor){
        try {
            if(this.visitorRepository.findById(visitor.getNationalId()).isPresent()){
                throw new IllegalArgumentException("National ID Already Used: "+visitor.getNationalId());
            }else {
                return this.visitorRepository.save(visitor);
            }
        }catch (Exception e){
            throw new IllegalArgumentException("National ID Already Used: "+visitor.getNationalId());
        }
    }


    public VisitorVisitingPlanDto registerVisitorVisitingPlan(VisitorVisitingPlanDto visitorVisitingPlanDto){
        try {
            VisitorVisitingPlan visitorVisitingPlan = new VisitorVisitingPlan();
            BeanUtils.copyProperties(visitorVisitingPlanDto, visitorVisitingPlan);

            visitorVisitingPlan.setPrisonVisitingPlan(this.prisonVisitingPlanRepository.findById(visitorVisitingPlanDto.getPrisonVisitingPlanId()).orElseThrow(() -> new IllegalArgumentException("Invalid Prison Visiting Plan ID: " + visitorVisitingPlanDto.getPrisonVisitingPlanId())));
            visitorVisitingPlan.setVisitor(this.visitorRepository.findById(visitorVisitingPlanDto.getVisitorId()).orElseThrow(()-> new IllegalArgumentException("Invalid Visitor ID: "+visitorVisitingPlanDto.getVisitorId())));
            visitorVisitingPlan.setPrisoner(this.prisonerRepository.findById(visitorVisitingPlanDto.getPrisonerId()).orElseThrow(()-> new IllegalArgumentException("Invalid Prisoner ID: "+visitorVisitingPlanDto.getPrisonerId())));

            this.visitorVisitingPlanRepository.save(visitorVisitingPlan);

            return visitorVisitingPlanDto;

        }catch (Exception e){
            throw new IllegalArgumentException("An Error Occurred: "+e.getMessage());
        }
    }


    public List<Visitor> findAllVisitors(){
        List<Visitor> admins = new ArrayList<>();
        Iterable<Visitor> adminIterable = this.visitorRepository.findAll();
        adminIterable.forEach(admins::add);
        return admins;
    }

    public List<Visitor> findVisitorsByPrison(String prisonId){
        List<Visitor> admins = new ArrayList<>();
        Iterable<Visitor> adminIterable = this.visitorRepository.findByVisitorVisitingPlanPrisonVisitingPlanPrisonPrisonId(prisonId);
        adminIterable.forEach(admins::add);
        return admins;
    }

    public List<VisitorVisitingPlan> findVisitPlanByVisitDateAndPrison(String visitDate, String prisonId) throws ParseException {
        List<VisitorVisitingPlan> plans = new ArrayList<>();
        Date vDate1 = new SimpleDateFormat("dd-MM-yyyy").parse(visitDate);
        Iterable<VisitorVisitingPlan> planIterable = this.visitorVisitingPlanRepository.findByVisitDateAndPrisonVisitingPlanPrisonPrisonId(vDate1, prisonId);
        planIterable.forEach(plans::add);
        return plans;
    }

}
