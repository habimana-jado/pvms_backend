package com.kist.pvms.service;

import com.kist.pvms.domain.*;
import com.kist.pvms.dto.AdminDto;
import com.kist.pvms.dto.SecurityGuardDto;
import com.kist.pvms.repository.AccountRepository;
import com.kist.pvms.repository.AdminRepository;
import com.kist.pvms.repository.PrisonRepository;
import com.kist.pvms.repository.SecurityGuardRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Service
public class PrisonService {

    @Autowired
    private PrisonRepository prisonRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SecurityGuardRepository securityGuardRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Prison registerPrison(Prison prison){
        try {
            Prison prison1 = prisonRepository.save(prison);

            Admin admin = new Admin();
            admin.setEmail(prison1.getEmail());
            admin.setFirstName(prison1.getPrisonName());
            admin.setLastName(prison1.getPrisonName());
            admin.setGender(EGender.MALE);
            admin.setNationalId(prison1.getPrisonId());
            admin.setPrison(prison1);
            adminRepository.save(admin);

            Account account = new Account();
            account.setAccess("Admin");
            account.setStatus("Active");
            account.setUsername(prison1.getEmail());
            String password = generateRandomSpecialCharacters(6);
            account.setPassword(password);
            account.setAdmin(admin);
            accountRepository.save(account);


            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(prison1.getEmail());
            message.setSubject("Prison(Inmate) Visitors Management system Account-Notification");
            message.setText("Dear " + prison1.getPrisonName() + " " + "," + "\n \n"
                    + "Your Account has been registered," + " " + "kindly use the following credentials for signing in"
                    + "\n" + "Username: " + prison1.getEmail() + "\nPassword: " + password
                    + " \n \n Regards, \n\n\n P.V.M.S Administration.");
            mailSender.send(message);

            return prison1;

        }catch (Exception e){
            throw new IllegalArgumentException("An Error Occurred: "+e.getMessage());
        }
    }

    public List<Prison> findAllPrisons(){
        List<Prison> prisons = new ArrayList<>();
        Iterable<Prison> prisonIterable = prisonRepository.findAll();
        prisonIterable.forEach(prisons::add);
        return prisons;
    }

    public AdminDto registerAdmin(AdminDto adminDto){
        try {
            Admin admin = new Admin();
            BeanUtils.copyProperties(adminDto, admin);

            admin.setPrison(this.prisonRepository.findById(adminDto.getPrisonId()).orElseThrow(()-> new IllegalArgumentException("Invalid Prison ID: "+adminDto.getPrisonId())));

            Admin admin1 = adminRepository.save(admin);

            Account account = new Account();
            account.setAccess("Admin");
            account.setStatus("Active");
            account.setUsername(admin1.getEmail());
            String password = generateRandomSpecialCharacters(6);
            account.setPassword(password);
            account.setAdmin(admin);
            accountRepository.save(account);


            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(admin1.getEmail());
            message.setSubject("Prison(Inmate) Visitors Management system Account-Notification");
            message.setText("Dear " + admin1.getFirstName() + " " + "," + "\n \n"
                    + "Your Account has been registered," + " " + "kindly use the following credentials for signing in"
                    + "\n" + "Username: " + admin1.getEmail() + "\nPassword: " + password
                    + " \n \n Regards, \n\n\n P.V.M.S Administration.");
            mailSender.send(message);

            return adminDto;
        }catch (Exception e){
            throw new IllegalArgumentException("An error Occurred: "+e.getMessage());
        }
    }

    public List<Admin> findAllAdmins(){
        List<Admin> admins = new ArrayList<>();
        Iterable<Admin> adminIterable = adminRepository.findAll();
        adminIterable.forEach(admins::add);
        return admins;
    }

    public List<Admin> findAdminsByPrison(String prisonId){
        List<Admin> admins = new ArrayList<>();
        Iterable<Admin> adminIterable = adminRepository.findByPrisonPrisonId(prisonId);
        adminIterable.forEach(admins::add);
        return admins;
    }

    public void registerSecurityGuard(SecurityGuardDto securityGuardDto){
        try {
            SecurityGuard securityGuard = new SecurityGuard();
            BeanUtils.copyProperties(securityGuardDto, securityGuard);
            securityGuard.setPrison(this.prisonRepository.findById(securityGuardDto.getPrisonId()).orElseThrow(()-> new IllegalArgumentException("Invalid Prison ID: "+securityGuardDto.getPrisonId())));
            securityGuard.setPersonType("SecurityGuard");
            SecurityGuard securityGuard1 = securityGuardRepository.save(securityGuard);

            Account account = new Account();
            account.setAccess("SecurityGuard");
            account.setStatus("Active");
            account.setUsername(securityGuard1.getEmail());
            String password = generateRandomSpecialCharacters(6);
            account.setPassword(password);
            account.setSecurityGuard(securityGuard);
            accountRepository.save(account);


            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(securityGuard1.getEmail());
            message.setSubject("Prison(Inmate) Visitors Management system Account-Notification");
            message.setText("Dear " + securityGuard1.getFirstName() + " " + "," + "\n \n"
                    + "Your Account has been registered," + " " + "kindly use the following credentials for signing in"
                    + "\n" + "Username: " + securityGuard1.getEmail() + "\nPassword: " + password
                    + " \n \n Regards, \n\n\n P.V.M.S Administration.");
            mailSender.send(message);

//            return securityGuard1;
        }catch (Exception e){
            throw new IllegalArgumentException("An error Occurred: "+e.getMessage());
        }
    }

    public List<SecurityGuard> findAllSecurityGuards(){
        List<SecurityGuard> securityGuards = new ArrayList<>();
        Iterable<SecurityGuard> securityGuardIterable = securityGuardRepository.findAll();
        securityGuardIterable.forEach(securityGuards::add);
        return securityGuards;
    }

    public List<SecurityGuard> findSecurityGuardsByPrison(String prisonId){
        List<SecurityGuard> securityGuards = new ArrayList<>();
        Iterable<SecurityGuard> securityGuardIterable = securityGuardRepository.findByPrisonPrisonId(prisonId);
        securityGuardIterable.forEach(securityGuards::add);
        return securityGuards;
    }



    public String generateRandomSpecialCharacters(int length) {

        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        System.out.println(generatedString);

        return generatedString;

    }
}
