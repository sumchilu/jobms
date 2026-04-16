package com.rnd.sb.jobms.job.service.impl;


import com.rnd.sb.jobms.job.model.Company;
import com.rnd.sb.jobms.job.model.Job;
import com.rnd.sb.jobms.job.model.dto.JobCompanyDTO;
import com.rnd.sb.jobms.job.repository.JobRepository;
import com.rnd.sb.jobms.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    //private List<Job> jobs = new ArrayList<>();
    @Autowired
    private JobRepository jobRepository;

    //private Long nextId = 1L;
    @Override
    public List<JobCompanyDTO> getAll() {
        List<JobCompanyDTO> jobCompanyDTOS = new ArrayList<>();
        List<Job> jobs = jobRepository.findAll();
        RestTemplate restTemplate = new RestTemplate();
        for (Job job : jobs) {
            Company company = restTemplate.getForObject("http://localhost:8082/company/"+job.getCompanyId(), Company.class);
            jobCompanyDTOS.add(new JobCompanyDTO(job, company));
        }


        return jobCompanyDTOS;
    }

    @Override
    public void addJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        try {
            jobRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateJob(Long id, Job job) {
        Optional<Job> byId = jobRepository.findById(id);
        if (byId.isPresent()) {
            Job j = byId.get();
            j.setId(id);
            j.setName(job.getName());
            j.setDescription(job.getDescription());
            j.setStatus(job.getStatus());
            j.setStartTime(job.getStartTime());
            j.setEndTime(job.getEndTime());
            jobRepository.save(j);
            return true;
        }

        return false;
    }


}
