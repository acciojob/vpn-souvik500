package com.driver.services.impl;

import com.driver.model.CountryName;
import com.driver.model.User;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserService {

    @Autowired
    UserRepository userRepository3;
    @Autowired
    ServiceProviderRepository serviceProviderRepository3;
    @Autowired
    CountryRepository countryRepository3;

    @Override
    public User register(String username, String password, String countryName) throws Exception{
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.getCountry().setCountryName(CountryName.valueOf(countryName));

        userRepository3.save(user);
    }

    @Override
    public User subscribe(Integer userId, Integer serviceProviderId) {

    }
}
