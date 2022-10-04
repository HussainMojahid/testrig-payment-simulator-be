package com.testrig.simulator.service;


import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.testrig.simulator.Dto.RequestView;
import com.testrig.simulator.entity.Req;

public interface ReqService {

    public String resFinder(Object obj) throws JsonProcessingException;

    public void addRequestResponse(RequestView requestView) throws JsonProcessingException;

    public void deleteRequestResponse(Object object) throws JsonProcessingException;

    public List<Req> allRequestResponse();

    
}
