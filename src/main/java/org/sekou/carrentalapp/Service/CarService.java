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
    public List<Car> getAllCars() {

        return carRepository.findAll();
    }
    public List<Car> getAvailableCars() {
        return carRepository.findByAvailableTrue();
    }
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Car not found with id " + id));

    }
     // first find the car
    public Car updateCar(Long id, Car updatedCar) {
        Car car = getCarById(id);
        car.setBrand(updatedCar.getBrand());
        car.setModel(updatedCar.getModel());
        car.setYear(updatedCar.getYear());
        car.setColor(updatedCar.getColor());
        car.setFuelType(updatedCar.getFuelType());
        car.setTransmission(updatedCar.getTransmission());
        car.setPricePerDay(updatedCar.getPricePerDay());
        car.setAvailable(updatedCar.isAvailable());
        return carRepository.save(car);
    }
    public void deleteCarById(Long id) {
        Car car = getCarById(id);  // make sure the car exists first
        carRepository.deleteById(id);
    }


}
