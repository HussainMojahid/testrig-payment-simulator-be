package com.testrig.simulator.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testrig.simulator.entity.Req;

@Repository
public interface ReqRepo extends JpaRepository<Req,Integer> {


    Req findByRequest(String req);



    
}
