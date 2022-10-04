package com.testrig.simulator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testrig.simulator.Dto.RequestView;
import com.testrig.simulator.entity.Req;
import com.testrig.simulator.repo.ReqRepo;
import com.testrig.simulator.service.ReqService;

@RestController
public class ReqController {

    final String Header = "Basic S2FocmFtYWE6UEAkJHcwcmRfMDUyMDIw";

    @Autowired
    ReqRepo reqRepo;

    @Autowired
    ReqService service;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/addRequestResponse")
    public ResponseEntity<String> addRequestResponse(@RequestBody RequestView requestView)
            throws JsonProcessingException {

        service.addRequestResponse(requestView);

        return ResponseEntity.ok().body("Request Response Saved");

    }

    @GetMapping("/allRequestResponse")
    public ResponseEntity<List<Req>> addRequestResponse()
            throws JsonProcessingException {

        List<Req> list = service.allRequestResponse();

        return ResponseEntity.ok().body(list);

    }

    @DeleteMapping("/deleteRequestResponse")
    public ResponseEntity<String> deleteRequestResponse(@RequestBody Object object)
            throws JsonProcessingException {

        service.deleteRequestResponse(object);

        return ResponseEntity.ok().body("Request Response Deleted");

    }

    @PostMapping("/payments")
    public Object reqCon(@RequestBody Object obj) throws JsonMappingException, JsonProcessingException {

        String a = service.resFinder(obj);

        Object o = objectMapper.readValue(a, Object.class);
        return o;

    }

    // /CSTServices/NearestBrancheLists
    @PostMapping("/CSTServices/NearestBrancheLists")
    public ResponseEntity<Object> NearestBrancheLists(@RequestBody Object obj, HttpServletRequest servletRequest,
            HttpServletResponse servletResponse) throws JsonProcessingException {

        String AuthHeader = servletRequest.getHeader("Authorization");
        if (AuthHeader.equals(Header)) {

            System.out.println(AuthHeader);

            String a = service.resFinder(obj);

            Object o = objectMapper.readValue(a, Object.class);
            return ResponseEntity.ok().body(o);

        } else {

            servletResponse.setStatus(401);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        }

    }

}
