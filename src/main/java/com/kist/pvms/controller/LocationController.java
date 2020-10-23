package com.kist.pvms.controller;

import com.kist.pvms.domain.ELocationType;
import com.kist.pvms.domain.Location;
import com.kist.pvms.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by nizey on 7/31/2020.
 */
@RestController
@RequestMapping(value = "/pvms/api/v1/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<List<Location>>(this.locationService.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping(value = "/provinces")
    public ResponseEntity<?> getAllProvinces(){
        return new ResponseEntity<List<Location>>(this.locationService.getAllProvince(), HttpStatus.OK);
    }

    @GetMapping(value = "/districts/{provinceId}")
    public ResponseEntity<?> getDistrictsByProvince(@PathVariable UUID provinceId){
        return new ResponseEntity<List<Location>>(this.locationService.getAllLocationsByParent(ELocationType.DISTRICT, provinceId), HttpStatus.OK);
    }

    @GetMapping(value = "/sectors/{districtId}")
    public ResponseEntity<?> getSectorsByDistrict(@PathVariable UUID districtId){
        return new ResponseEntity<List<Location>>(this.locationService.getAllLocationsByParent(ELocationType.SECTOR, districtId), HttpStatus.OK);
    }

    @GetMapping(value = "/cells/{sectorId}")
    public ResponseEntity<?> getCellsByDistrict(@PathVariable UUID sectorId){
        return new ResponseEntity<List<Location>>(this.locationService.getAllLocationsByParent(ELocationType.CELL, sectorId), HttpStatus.OK);
    }

    @GetMapping(value = "/villages/{cellId}")
    public ResponseEntity<?> getVillagesByCell(@PathVariable UUID cellId){
        return new ResponseEntity<List<Location>>(this.locationService.getAllLocationsByParent(ELocationType.VILLAGE, cellId), HttpStatus.OK);
    }
}
