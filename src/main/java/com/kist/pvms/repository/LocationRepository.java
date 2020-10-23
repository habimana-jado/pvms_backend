package com.kist.pvms.repository;

import com.kist.pvms.domain.ELocationType;
import com.kist.pvms.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by nizey on 8/14/2020.
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    public List<Location> findByLocationType(ELocationType locationType);
    public List<Location> findByLocationTypeAndParentIdId(ELocationType locationType, UUID parentId);
}
