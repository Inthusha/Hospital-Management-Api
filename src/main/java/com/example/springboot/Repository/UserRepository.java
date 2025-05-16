package com.example.springboot.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>
{
	 User findByEmail(String email);
	 boolean existsByEmail(String email);

}
