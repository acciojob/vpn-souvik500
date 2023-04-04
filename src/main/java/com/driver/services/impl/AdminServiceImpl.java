package com.driver.services.impl;

import com.driver.model.*;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin register(String username, String password)
    {
        Admin admin = Admin.builder()
                .userName(username)
                .password(password)
                .build();

        adminRepository1.save(admin);
        return admin;
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName)
    {
        Admin admin = adminRepository1.findById(adminId).get();

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setName(providerName);
        serviceProvider.setAdmin(admin);

        admin.getServiceProviderList().add(serviceProvider);

        adminRepository1.save(admin);

        return admin;
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{

        if (countryName.equalsIgnoreCase("IND") || countryName.equalsIgnoreCase("USA") || countryName.equalsIgnoreCase("JPN") || countryName.equalsIgnoreCase("CHI") || countryName.equalsIgnoreCase("AUS")) {
            ServiceProvider serviceProvider = serviceProviderRepository1.findById(serviceProviderId).get();

            Country country = new Country();

            if (countryName.equalsIgnoreCase("IND")) {
                country.setCountryName(CountryName.IND);
                country.setCode(CountryName.IND.toCode());
            }
            if (countryName.equalsIgnoreCase("usa")) {
                country.setCountryName(CountryName.USA);
                country.setCode(CountryName.USA.toCode());
            }
            if (countryName.equalsIgnoreCase("CHI")) {
                country.setCountryName(CountryName.CHI);
                country.setCode(CountryName.CHI.toCode());
            }
            if (countryName.equalsIgnoreCase("JPN")) {
                country.setCountryName(CountryName.JPN);
                country.setCode(CountryName.JPN.toCode());
            }

            country.setServiceProvider(serviceProvider);
            serviceProvider.getCountryList().add(country);

            serviceProviderRepository1.save(serviceProvider);

            return serviceProvider;
        }
        else throw new RuntimeException("Country not found");
    }
}
