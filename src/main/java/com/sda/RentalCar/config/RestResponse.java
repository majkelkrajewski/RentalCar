package com.sda.RentalCar.config;

import lombok.Data;

@Data
public class RestResponse {

    public Long id;
    public String model;
    public Long year;
    public String mark;
}
