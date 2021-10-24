package pl.sdacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.services.CountryService;
import pl.sdacademy.entities.Location;

import java.util.List;

@Controller
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country")
    public String mainView() {
        return "country";
    }

    @GetMapping("/country-list")
    public String getList(ModelMap modelMap) {
        List<Location> countries = countryService.getAll();
        modelMap.addAttribute("countries", countries);
        return "country-list";
    }

    @GetMapping("/country-add")
    public String getForm(@ModelAttribute("country") Location country) {
        return "country-form";
    }

    @PostMapping("/country-add")
    public String create(Location country) {
        countryService.create(country);
        return "redirect:/country-list";
    }

    @GetMapping("update-country/{countryId}")
    public String getUpdateForm(@PathVariable("countryId") int id, ModelMap modelMap) {
        Location country = countryService.getById(id);
        modelMap.addAttribute("country", country);
        return "country-update";
    }

    @PostMapping("update-country/{tourId}")
    public String update(Location country) {
        countryService.update(country);
        return "redirect:/country-list";
    }

    @GetMapping("delete-country/{countryId}")
    public String deleteTour(@PathVariable("countryId") int id, ModelMap modelMap) {
        Location country = countryService.getById(id);
        modelMap.addAttribute("country", country);
        return "country-delete";
    }

    @PostMapping("delete-country/{countryId}")
    public String delete(Location country) {
        countryService.delete(country);
        return "redirect:/country-list";
    }

}
