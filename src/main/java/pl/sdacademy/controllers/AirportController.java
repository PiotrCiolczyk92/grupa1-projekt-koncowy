package pl.sdacademy.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sdacademy.entities.Airport;
import pl.sdacademy.entities.Location;
import pl.sdacademy.entities.Tour;
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
    public String getForm(ModelMap modelMap, @ModelAttribute("airport") Airport airport, BindingResult bindingResult) {
        List<Location> locations = locationService.getAll();
        modelMap.addAttribute("locations", locations);
        return "airport-form";
    }
    @PostMapping("/add-airport")
    public String create(@Validated Airport airport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "airport-form";
        }
        airportService.create(airport);
        return "redirect:/list-airport";
    }
    @GetMapping("delete-airport/{airportId}")
    public String deleteAirport(@PathVariable("airportId") int id, ModelMap modelMap) {
        Airport airport = airportService.getById(id);
        modelMap.addAttribute("airport", airport);
        return "airport-delete";
    }

    @PostMapping("delete-airport/{airportId}")
    public String delete(Airport airport) {
        airportService.delete(airport);
        return "redirect:/list-airport";
    }
}
