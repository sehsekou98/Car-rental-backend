package org.sekou.carrentalapp.Repository;

import org.sekou.carrentalapp.CarModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
