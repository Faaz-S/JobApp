package com.cyberwolf.JobApp.job.impl;
import com.cyberwolf.JobApp.job.Job;
import com.cyberwolf.JobApp.job.JobRepository;
import com.cyberwolf.JobApp.job.JobService;
import com.fasterxml.jackson.databind.type.IterationType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImplementation implements JobService {
    //private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;
    //private long nextId = 1L;  [dont need to do this anymore as JobRepository class handles it]

    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        //return jobs;
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        //setting and incrementing id by default
        //job.setId(nextId++);  [dont need to do this anymore as JobRepository class handles it]
        //jobs.add(job);
        jobRepository.save(job);

    }

    @Override
    public Job getJobById(Long id) {
//        for (Job job : jobs){
//            if (job.getId().equals(id)){
//                return job;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deleteJobById(Long id){
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
//        Iterator<Job> iterator = jobs.iterator();
//        while(iterator.hasNext()){
//            Job job  = iterator.next();
//            if(job.getId().equals(id)){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
     }

     @Override
    public boolean updateJobById(Long id, Job updatedJob){
        Optional<Job> jobOptional = jobRepository.findById(id);

             if(jobOptional.isPresent()){
                 Job job = jobOptional.get();
                 job.setTitle(updatedJob.getTitle());
                 job.setDescription(updatedJob.getDescription());
                 job.setMinSalary(updatedJob.getMinSalary());
                 job.setMaxSalary(updatedJob.getMaxSalary());
                 job.setLocation(updatedJob.getLocation());
                 jobRepository.save(job);
                 return true;
             }

         return false;
     }
}
