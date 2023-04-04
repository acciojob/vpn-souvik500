package com.driver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin
{
    private int id;

    private String userName;

    private String password;

    // 1 : many b/w Admin and ServiceProvider
    @OneToMany (mappedBy = "admin", cascade = CascadeType.ALL)
    List<ServiceProvider> serviceProviderList = new ArrayList<>();
}
