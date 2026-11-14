package org.sekou.carrentalapp.Service;


import org.sekou.carrentalapp.CarModel.Car;
import org.sekou.carrentalapp.Repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }
    public List<Car> getAvailableCars() {
        return carRepository.findByAvailableTrue();
    }
    public Car addCar(Car car) {
        return carRepository.save(car);
    }
}
