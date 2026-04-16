package com.rnd.sb.jobms.job.model;

import lombok.Data;

@Data
public class Company {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String website;
}
