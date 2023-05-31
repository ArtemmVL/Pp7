package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    CarService carService = new CarServiceImp();

    @GetMapping(value = "/cars")
    public String getCar(@RequestParam(value = "count",defaultValue = "0") int count, ModelMap model) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("model1", 1,"red"));
        carList.add(new Car("model2", 2,"green"));
        carList.add(new Car("model3", 3,"black"));
        carList.add(new Car("model4", 4,"blue"));
        carList.add(new Car("model5", 5,"orange"));
        carList = carService.getCarsByCount(carList, count);
        model.addAttribute("list", carList);
        return "cars";
    }

}
