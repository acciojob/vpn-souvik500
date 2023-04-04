package com.driver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User
{
    private int id;

    private String userName;

    private String password;

    private String originalIp;

    private String maskedId;

    private boolean connected;


    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    List<Connection> connectionList = new ArrayList<>();

    @ManyToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    List<ServiceProvider> serviceProviderList = new ArrayList<>();


    @OneToOne (mappedBy = "user", cascade = CascadeType.ALL)
    Country country;
}
