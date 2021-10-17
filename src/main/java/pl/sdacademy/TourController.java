package pl.sdacademy;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tour")
public class TourController {

    private TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/list")
    public String getList(ModelMap modelMap) {
        List<Tour> tours = tourService.getAll();
        modelMap.addAttribute("tours", tours);
        return "list";
    }

    @GetMapping("/add")
    public String getForm(@ModelAttribute("tour") Tour tour){
        return "form";
    }

    @PostMapping("/add")
    public String create(Tour tour) {
        tourService.create(tour);
        return "redirect:/tour/list";

    }


}