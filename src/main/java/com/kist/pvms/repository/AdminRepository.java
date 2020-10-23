package com.kist.pvms.repository;

import com.kist.pvms.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    public List<Admin> findByPrisonPrisonId(String prisonId);
}
