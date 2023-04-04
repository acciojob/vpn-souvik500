package com.driver.model;// Note: Do not write @Enumerated annotation above CountryName in this model.

import com.driver.model.CountryName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country
{
    private int id;

    private CountryName countryName;

    private String code;

    @OneToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    ServiceProvider serviceProvider;
}