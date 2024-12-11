package com.cyberwolf.JobApp.job;

import org.springframework.data.jpa.repository.JpaRepository;

//JPARepository<name of class, type of primary key>
public interface JobRepository extends JpaRepository<Job, Long> {

    //we don't need to write any implementation the rest is done by the compiler
}
