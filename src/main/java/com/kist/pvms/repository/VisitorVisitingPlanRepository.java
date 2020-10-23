package com.kist.pvms.repository;

import com.kist.pvms.domain.VisitorVisitingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Repository
public interface VisitorVisitingPlanRepository extends JpaRepository<VisitorVisitingPlan, String> {
    public List<VisitorVisitingPlan> findByVisitDateAndPrisonVisitingPlanPrisonPrisonId(Date vDate, String prisonId);
}
