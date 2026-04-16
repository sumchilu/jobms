package com.rnd.sb.jobms.job.model.dto;

import com.rnd.sb.jobms.job.model.Company;
import com.rnd.sb.jobms.job.model.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobCompanyDTO {
    private Job job;
    private Company company;
}
