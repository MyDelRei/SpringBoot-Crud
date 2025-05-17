package com.example.studentMS.repo;

import com.example.studentMS.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users,String> {

    Users findByEmail(String email);

}
