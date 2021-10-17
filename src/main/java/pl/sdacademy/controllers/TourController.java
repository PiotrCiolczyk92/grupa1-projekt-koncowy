package pl.sdacademy.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sdacademy.services.TourService;
import pl.sdacademy.entities.Tour;

import java.util.List;

@Controller
public class TourController {

    private TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/tour")
    public String mainView() {
        return "tour";
    }

    @GetMapping("/list")
    public String getList(ModelMap modelMap) {
        List<Tour> tours = tourService.getAll();
        modelMap.addAttribute("tours", tours);
        return "tour-list";
    }

    @GetMapping("/add")
    public String getForm(@ModelAttribute("tour") Tour tour){
        return "tour-form";
    }

    @PostMapping("/add")
    public String create(Tour tour) {
        tourService.create(tour);
        return "redirect:/tour-list";
    }

}