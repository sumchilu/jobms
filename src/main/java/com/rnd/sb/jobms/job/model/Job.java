package com.rnd.sb.jobms.job.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//@Table(name = "job_table")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String status;
    private String startTime;
    private String endTime;
    private Long companyId;

}
