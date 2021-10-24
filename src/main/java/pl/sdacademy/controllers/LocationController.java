package pl.sdacademy.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.services.LocationService;
import pl.sdacademy.entities.Location;
import pl.sdacademy.services.TourService;

import java.util.List;

@Controller
@AllArgsConstructor
public class LocationController {
    private LocationService locationService;



    @GetMapping("/location")
    public String mainView() {
        return "location";
    }

    @GetMapping("/location-list")
    public String getList(ModelMap modelMap) {
        List<Location> locations = locationService.getAll();
        modelMap.addAttribute("locations", locations);
        return "location-list";
    }

    @GetMapping("/location-add")
    public String getForm(@ModelAttribute("location") Location location) {
        return "location-form";
    }

    @PostMapping("/location-add")
    public String create(Location location) {
        locationService.create(location);
        return "redirect:/location-list";
    }

    @GetMapping("update-location/{locationId}")
    public String getUpdateForm(@PathVariable("locationId") int id, ModelMap modelMap) {
        Location location = locationService.getById(id);
        modelMap.addAttribute("location", location);
        return "location-update";
    }

    @PostMapping("update-location/{tourId}")
    public String update(Location location) {
        locationService.update(location);
        return "redirect:/location-list";
    }

    @GetMapping("delete-location/{locationId}")
    public String deleteTour(@PathVariable("locationId") int id, ModelMap modelMap) {
        Location location = locationService.getById(id);
        modelMap.addAttribute("location", location);
        return "location-delete";
    }

    @PostMapping("delete-location/{locationId}")
    public String delete(Location location) {
        locationService.delete(location);
        return "redirect:/location-list";
    }

}
