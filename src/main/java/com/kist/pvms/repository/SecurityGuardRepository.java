package com.kist.pvms.repository;

import com.kist.pvms.domain.SecurityGuard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Repository
public interface SecurityGuardRepository extends JpaRepository<SecurityGuard, String> {
    public List<SecurityGuard> findByPrisonPrisonId(String prisonId);
}
