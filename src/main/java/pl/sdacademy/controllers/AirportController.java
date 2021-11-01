package pl.sdacademy.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sdacademy.entities.Airport;
import pl.sdacademy.entities.Location;
import pl.sdacademy.services.AirportService;
import pl.sdacademy.services.LocationService;

import java.util.List;

@AllArgsConstructor
@Controller
public class AirportController {

    private AirportService airportService;
    private LocationService locationService;

    @GetMapping("/list-airport")
    public String getList(ModelMap modelMap) {
        List<Airport> airports = airportService.getAll();
        modelMap.addAttribute("airports", airports);
        return "/airport-list";
    }
    @GetMapping("/add-airport")
    public String getForm(ModelMap modelMap, @ModelAttribute("airport") Airport airport) {
        List<Location> locations = locationService.getAll();
        modelMap.addAttribute("locations", locations);
        return "airport-form";
    }
    @PostMapping("/add-airport")
    public String create(Airport airport) {
        airportService.create(airport);
        return "redirect:/list-airport";
    }
}
