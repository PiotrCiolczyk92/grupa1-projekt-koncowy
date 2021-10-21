package pl.sdacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.services.CountryService;
import pl.sdacademy.entities.Country;

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
        List<Country> countries = countryService.getAll();
        modelMap.addAttribute("countries", countries);
        return "country-list";
    }

    @GetMapping("/country-add")
    public String getForm(@ModelAttribute("country") Country country) {
        return "country-form";
    }

    @PostMapping("/country-add")
    public String create(Country country) {
        countryService.create(country);
        return "redirect:/country-list";
    }

    @GetMapping("update-country/{countryId}")
    public String getUpdateForm(@PathVariable("countryId") int id, ModelMap modelMap) {
        Country country = countryService.getById(id);
        modelMap.addAttribute("country", country);
        return "country-update";
    }

    @PostMapping("update-country/{tourId}")
    public String update(Country country) {
        countryService.update(country);
        return "redirect:/country-list";
    }

    @GetMapping("delete-country/{countryId}")
    public String deleteTour(@PathVariable("countryId") int id, ModelMap modelMap) {
        Country country = countryService.getById(id);
        modelMap.addAttribute("country", country);
        return "country-delete";
    }

    @PostMapping("delete-country/{countryId}")
    public String delete(Country country) {
        countryService.delete(country);
        return "redirect:/country-list";
    }

}
