package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.servise.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String cars(Model model) {
        model.addAttribute("cars",carService.findAll());
        return "cars";
    }

    @GetMapping(params = "count")
    public String carsByCount(Model model, @RequestParam int count){
        model.addAttribute("cars",carService.findLimited(count));
        return "cars";

    }


}
