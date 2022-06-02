package jungsaesidae.capstone.controller;

import jungsaesidae.capstone.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/location")
public class LocationApiController {

    private final LocationService locationService;

    @GetMapping("/city")
    public List<String> findAllCity() {
        return locationService.findAllCity();
    }

    @GetMapping("/state/{state}")
    public List<String> findAllStateByCity(@PathVariable(name = "state") String state) {
        return locationService.findAllStateByCity(state);
    }
}
