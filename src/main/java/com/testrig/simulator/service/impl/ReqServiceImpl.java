package com.testrig.simulator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testrig.simulator.Dto.RequestView;
import com.testrig.simulator.entity.Req;
import com.testrig.simulator.repo.ReqRepo;
import com.testrig.simulator.service.ReqService;

@Service
public class ReqServiceImpl implements ReqService {

    @Autowired
    ReqRepo reqRepo;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public String resFinder(Object obj) throws JsonProcessingException {

        String s = objectMapper.writeValueAsString(obj);
        Req req = reqRepo.findByRequest(s);
        return req.getResponse();
    }

    @Override
    public void addRequestResponse(RequestView requestView) throws JsonProcessingException {

        Req req = new Req();
        req.setRequest(objectMapper.writeValueAsString(requestView.getRequest()));
        req.setResponse(objectMapper.writeValueAsString(requestView.getResponse()));

        reqRepo.save(req);

    }

    @Override
    public void deleteRequestResponse(Object object) throws JsonProcessingException {

        Req r = reqRepo.findByRequest(objectMapper.writeValueAsString(object));
        reqRepo.delete(r);

    }

    @Override
    public List<Req> allRequestResponse() {

        return reqRepo.findAll();
    }

}
