package com.ticketsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.ticketsystem.model.Flight;
import com.ticketsystem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping("all")
    public List<Flight> getAllFlight(){
        return flightService.getAllFlight();
    }

    @RequestMapping("flightId")
    public Flight getFlightById(@RequestBody Map<String,String> map){
        int flightId = Integer.parseInt(map.get("flightId"));
        return flightService.getFlightById(flightId);
    }

    @RequestMapping("altFlight")
    public void altFlight(@RequestBody JSONObject jsonObject){
        Flight flight = JSONObject.parseObject(jsonObject.toJSONString(),Flight.class);
        flightService.altFlight(flight);
    }
}
