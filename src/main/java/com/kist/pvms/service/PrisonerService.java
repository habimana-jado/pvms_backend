package com.kist.pvms.service;

import com.kist.pvms.domain.*;
import com.kist.pvms.dto.PrisonerDto;
import com.kist.pvms.repository.CrimeCaseRepository;
import com.kist.pvms.repository.LocationRepository;
import com.kist.pvms.repository.PrisonRepository;
import com.kist.pvms.repository.PrisonerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Service
public class PrisonerService {

    @Autowired
    private PrisonerRepository prisonerRepository;

    @Autowired
    private PrisonRepository prisonRepository;

    @Autowired
    private CrimeCaseRepository crimeCaseRepository;

    @Autowired
    private LocationRepository locationRepository;

    public PrisonerDto registerPrisoner(PrisonerDto prisonerDto){
        try {
            Prisoner prisoner = new Prisoner();
            CrimeCase crimeCase = new CrimeCase();

            BeanUtils.copyProperties(prisonerDto, prisoner);
            BeanUtils.copyProperties(prisonerDto, crimeCase);

            Prisoner prisoner1 = prisonerRepository.save(prisoner);

            crimeCase.setPrisoner(prisoner1);
            Prison prison = this.prisonRepository.findById(prisonerDto.getPrisonId()).orElseThrow(() -> new IllegalArgumentException("Invalid Prison ID: " + prisonerDto.getPrisonId()));
            crimeCase.setPrison(prison);
            crimeCaseRepository.save(crimeCase);

            return prisonerDto;

        }catch (Exception e){
            throw new IllegalArgumentException("An Error Occurred: "+e.getMessage());
        }
    }


    public List<CrimeCase> findPrisonersByPrison(String prisonId){
        List<CrimeCase> admins = new ArrayList<>();
        Iterable<CrimeCase> adminIterable = this.crimeCaseRepository.findByPrisonPrisonId(prisonId);
        adminIterable.forEach(admins::add);
        return admins;
    }

    public CrimeCase findOnePrisoner(String prisonerId){
        try {
            return  this.crimeCaseRepository.findByPrisonerNationalId(prisonerId);
        }catch (Exception e){
            throw new IllegalArgumentException("Prisoner ID Not Found: "+prisonerId);
        }
    }

}
