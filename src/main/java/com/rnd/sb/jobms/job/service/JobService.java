package com.rnd.sb.jobms.job.service;


import com.rnd.sb.jobms.job.model.Job;
import com.rnd.sb.jobms.job.model.dto.JobCompanyDTO;

import java.util.List;

public interface JobService {
    List<JobCompanyDTO> getAll();
    void addJob(Job job);

    Job getJobById(Long id);

    boolean deleteJob(Long id);

    boolean updateJob(Long id, Job job);
}
