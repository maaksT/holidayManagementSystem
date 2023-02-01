package pl.makstokarz.holidayManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.makstokarz.holidayManagementSystem.repository.LocationRepo;


@RestController
public class LocationController {

    @Autowired
    private LocationRepo locationRepo;
}
