package pl.sdacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/list")
    public String getList(ModelMap modelMap){
        List<Country> countries = countryService.getAll();
        modelMap.addAttribute("countries", countries);
        return "country-list";
    }

}
