package com.pfe.tunhome.repositories;
import com.pfe.tunhome.models.Offer;
import com.pfe.tunhome.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
