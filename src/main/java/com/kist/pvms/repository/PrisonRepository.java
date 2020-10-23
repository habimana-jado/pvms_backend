package com.kist.pvms.repository;

import com.kist.pvms.domain.Prison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nizey on 8/14/2020.
 */
@Repository
public interface PrisonRepository extends JpaRepository<Prison, String> {
}
