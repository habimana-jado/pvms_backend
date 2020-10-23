package com.kist.pvms.repository;

import com.kist.pvms.domain.CrimeCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Repository
public interface CrimeCaseRepository extends JpaRepository<CrimeCase, String> {
    public List<CrimeCase> findByPrisonPrisonId(String prisonId);
    public CrimeCase findByPrisonerNationalId(String nationalId);
}
