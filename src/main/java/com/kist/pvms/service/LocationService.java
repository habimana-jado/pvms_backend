package com.kist.pvms.service;

import com.kist.pvms.domain.ELocationType;
import com.kist.pvms.domain.Location;
import com.kist.pvms.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by nizey on 7/31/2020.
 */
@Service
public class LocationService implements Serializable {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations(){
        List<Location> locations = new ArrayList<>();
        Iterable<Location> iterableLocations = locationRepository.findAll();
        iterableLocations.forEach(locations::add);
        return locations;
    }


    public List<Location> getAllLocationsByParent(ELocationType locationType, UUID parentId){
        List<Location> locations = new ArrayList<>();
        Iterable<Location> iterableLocations = locationRepository.findByLocationTypeAndParentIdId(locationType, parentId);
        iterableLocations.forEach(locations::add);
        return locations;
    }

    public List<Location> getAllProvince(){
        List<Location> locations = new ArrayList<>();
        Iterable<Location> iterableLocations = locationRepository.findByLocationType(ELocationType.PROVINCE);
        iterableLocations.forEach(locations::add);
        return locations;
    }




}
