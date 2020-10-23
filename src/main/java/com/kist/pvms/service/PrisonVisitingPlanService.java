package com.kist.pvms.service;

import com.kist.pvms.domain.Prison;
import com.kist.pvms.domain.PrisonVisitingPlan;
import com.kist.pvms.dto.PrisonVisitingPlanDto;
import com.kist.pvms.repository.PrisonRepository;
import com.kist.pvms.repository.PrisonVisitingPlanRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Service
public class PrisonVisitingPlanService {

    @Autowired
    private PrisonVisitingPlanRepository prisonVisitingPlanRepository;

    @Autowired
    private PrisonRepository prisonRepository;

    public PrisonVisitingPlan registerPrisonVisitingPlan(PrisonVisitingPlanDto plan){
        try {
            PrisonVisitingPlan visitingPlan = new PrisonVisitingPlan();
            BeanUtils.copyProperties(plan, visitingPlan);
            visitingPlan.setPrison(this.prisonRepository.findById(plan.getPrisonId()).orElseThrow(() -> new IllegalArgumentException("Invalid Prison ID: " + plan.getPrisonId())));
            return this.prisonVisitingPlanRepository.save(visitingPlan);
        }catch (Exception e){
            throw new IllegalArgumentException("An Error Occurred: "+e.getMessage());
        }
    }

    public List<PrisonVisitingPlan> findByPrison(String prisonId){
        List<PrisonVisitingPlan> plans = new ArrayList<>();
        Iterable<PrisonVisitingPlan> prisonVisitingPlanIterable = this.prisonVisitingPlanRepository.findByPrisonPrisonId(prisonId);
        prisonVisitingPlanIterable.forEach(plans::add);
        return plans;
    }
}
