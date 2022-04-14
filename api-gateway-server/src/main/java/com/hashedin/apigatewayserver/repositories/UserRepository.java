package com.hashedin.apigatewayserver.repositories;
import com.hashedin.apigatewayserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, String> {
}
