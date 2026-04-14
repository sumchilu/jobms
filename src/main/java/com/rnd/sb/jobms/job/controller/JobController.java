package com.rnd.sb.jobms.job.controller;



import com.rnd.sb.jobms.job.model.Job;
import com.rnd.sb.jobms.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/")
    public List<Job> getJobs(){
        return jobService.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<String> setJobs(@RequestBody Job job){
        jobService.addJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJob(id);
        if(deleted){
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id){
        Job jobById = jobService.getJobById(id);
        if(jobById != null){
            return new ResponseEntity<>(jobById, HttpStatus.OK);
        }
        return new ResponseEntity<>(jobById, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@RequestBody Job job, @PathVariable Long id){
        boolean updated = jobService.updateJob(id, job);
        if(updated){
            return new ResponseEntity<>("Job Updated Sucessfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
