package pl.sdacademy;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tour")
public class TourController {
    private TourRepository tourRepository;

    public TourController(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @GetMapping("/list")
    public String getList(ModelMap modelMap) {
        List<Tour> tours = tourRepository.findAll();
        modelMap.addAttribute("tours", tours);
        return "list";
    }

    @GetMapping("/add")
    public String getForm(@ModelAttribute("tour") Tour tour){
        return "form";
    }
}