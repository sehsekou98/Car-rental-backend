package org.sekou.carrentalapp.Repository;

import org.sekou.carrentalapp.CarModel.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByAvailableTrue();
    List<Car> findByBrand(String brand);

    List<Car> id(Long id);
}
