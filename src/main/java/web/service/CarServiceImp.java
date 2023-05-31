package web.service;

import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImp implements CarService{


    @Override
    public List<Car> getCarsByCount(List<Car> carList, int count) {
        if (count <= 0 || count > 5) {
            return carList;
        } else {
            return carList.stream().limit(count).collect(Collectors.toList());
        }
    }
}
