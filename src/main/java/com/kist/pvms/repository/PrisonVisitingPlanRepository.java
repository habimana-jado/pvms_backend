package com.kist.pvms.repository;

import com.kist.pvms.domain.PrisonVisitingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Repository
public interface PrisonVisitingPlanRepository extends JpaRepository<PrisonVisitingPlan, String> {
    public List<PrisonVisitingPlan> findByPrisonPrisonId(String prisonId);
}
