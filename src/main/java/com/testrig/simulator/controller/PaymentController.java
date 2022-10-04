package com.testrig.simulator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testrig.simulator.Dto.RequestView;
import com.testrig.simulator.entity.Req;
import com.testrig.simulator.repo.ReqRepo;
import com.testrig.simulator.service.ReqService;
import com.testrig.simulator.utils.JsonUtils;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    ReqRepo reqRepo;

    @Autowired
    ReqService service;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/test")
    public Object test() throws JSONException {
        return JsonUtils.readPaymentSuccessResponseJson();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRequestResponse(@RequestBody RequestView requestView)
            throws JsonProcessingException {

        service.addRequestResponse(requestView);

        return ResponseEntity.status(HttpStatus.CREATED).body("Request Response Saved");

    }

    @GetMapping("/getall")
    public ResponseEntity<List<Req>> addRequestResponse()
            throws JsonProcessingException {

        List<Req> list = service.allRequestResponse();

        return ResponseEntity.ok().body(list);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRequestResponse(@RequestBody Object object)
            throws JsonProcessingException {

        service.deleteRequestResponse(object);

        return ResponseEntity.ok().body("Request Response Deleted");

    }

    @PostMapping("/payments")
    public ResponseEntity<Object> Payment(@RequestBody Object obj)
            throws JsonMappingException, JsonProcessingException {
        return ResponseEntity.ok().body(objectMapper.readValue(service.resFinder(obj), Object.class));
    }

}
