package com.kist.pvms.repository;

import com.kist.pvms.domain.Prisoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nizey on 8/14/2020.
 */
@Repository
public interface PrisonerRepository extends JpaRepository<Prisoner, String> {

}
