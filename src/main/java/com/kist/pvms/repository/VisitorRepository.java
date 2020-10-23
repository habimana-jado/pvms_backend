package com.kist.pvms.repository;

import com.kist.pvms.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Repository
public interface VisitorRepository extends JpaRepository<Visitor, String> {
    public List<Visitor> findByVisitorVisitingPlanPrisonVisitingPlanPrisonPrisonId(String prisonId);
//    public List<Visitor> findByVisitorVisitingPlanVisitDateAndPrisonVisitingPlanPrisonPrisonId(Date visitDate, String prisonId);
}
