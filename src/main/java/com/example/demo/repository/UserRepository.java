package com.example.demo.repository;

import java.time.LocalDate;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("SELECT u FROM User u WHERE u.userId = ?1 OR u.email = ?2 OR u.phone=?3")
	public User findByUserIdOrEmailOrPhone(String userId, String email, String phone);
	
	@Query("select x from User x where x.createDate between ?1 and ?2")
	public List<User> findByCreateDateBetween(LocalDate date1,LocalDate date2);

}
