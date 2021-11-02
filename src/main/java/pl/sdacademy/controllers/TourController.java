package pl.sdacademy.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.entities.Airport;
import pl.sdacademy.entities.Location;
import pl.sdacademy.entities.User;
import pl.sdacademy.services.AirportService;
import pl.sdacademy.services.LocationService;
import pl.sdacademy.services.TourService;
import pl.sdacademy.entities.Tour;
import pl.sdacademy.services.UserService;

import java.util.List;

@Controller
@AllArgsConstructor
public class TourController {

    private TourService tourService;
    private final LocationService locationService;
    private final UserService userService;
    private final AirportService airportService;


    @GetMapping("/tour")
    public String mainView() {
        return "tour";
    }

    @GetMapping("/list-tour")
    public String getList(ModelMap modelMap) {
        List<Tour> tours = tourService.getAll();
        modelMap.addAttribute("tours", tours);
        return "tour-list";
    }

    @GetMapping("/add-tour")
    public String getForm(ModelMap modelMap, @ModelAttribute("tour") Tour tour) {
        List<Location> locations = locationService.getAll();
        List<User> users = userService.getAll();
        List<Airport> airports = airportService.getAll();
        modelMap.addAttribute("locations", locations);
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("airports", airports);
        return "tour-form";
    }

    @PostMapping("/add-tour")
    public String create(Tour tour) {
        tourService.create(tour);
        return "redirect:/list-tour";
    }

    @GetMapping("/update-tour/{tourId}")
    public String getUpdateForm(@PathVariable("tourId") int id, ModelMap modelMap) {
        Tour tour = tourService.getById(id);
        List<Location> locations = locationService.getAll();
        List<User> users = userService.getAll();
        List<Airport> airports = airportService.getAll();
        modelMap.addAttribute("tour", tour);
        modelMap.addAttribute("locations", locations);
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("airports", airports);
        return "tour-update";
    }

    @PostMapping("/update-tour/{tourId}")
    public String update(Tour tour) {
        tourService.update(tour);
        return "redirect:/list-tour";
    }

    @GetMapping("/sell-tour/{tourId}")
    public String getSellForm(@PathVariable("tourId") int id, ModelMap modelMap) {
        Tour tour = tourService.getById(id);
        List<User> customers = userService.getAll();
        modelMap.addAttribute("customers", customers);
        modelMap.addAttribute("tour", tour);
        return "tour-sell";
    }

    @PostMapping("sell-tour/{tourId}")
    public String sell(Tour tour) {
        tourService.update(tour);
        tourService.sell(tour);
        return "redirect:/list-tour";
    }


    @GetMapping("/delete-tour/{tourId}")
    public String deleteTour(@PathVariable("tourId") int id, ModelMap modelMap) {
        Tour tour = tourService.getById(id);
        modelMap.addAttribute("tour", tour);
        return "tour-delete";
    }

    @PostMapping("delete-tour/{tourId}")
    public String delete(Tour tour) {
        tourService.delete(tour);
        return "redirect:/list-tour";
    }

    @GetMapping("/kontakt")
    public String kontakt() {
        return "kontakt";
    }

    @GetMapping("/opinie")
    public String opinie() {
        return "opinie";
    }

    @GetMapping("/onas")
    public String onas() {
        return "onas";
    }

}