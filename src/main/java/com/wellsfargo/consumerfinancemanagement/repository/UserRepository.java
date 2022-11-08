package com.wellsfargo.consumerfinancemanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wellsfargo.consumerfinancemanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
//	public User findUserByuName(String userName);
	
	@Query(value = "SELECT * FROM user u WHERE u.user_Name = :userName", nativeQuery = true)
	public User findUserByuName(@Param("userName") String userName);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE USER SET password = ?2 WHERE user_name = ?1", nativeQuery = true)
	void updatePwdByuName(String userName, String password);
	
	@Query(value = "SELECT * FROM user u WHERE u.user_Name = :userName", nativeQuery = true)
	public User findPasswordByuName(@Param("userName") String userName);

	@Query(value = "SELECT * FROM user u", nativeQuery = true)
	List<User> uDashboard();
	
	@Query(value = "SELECT * FROM user u WHERE u.email_id = ?1", nativeQuery = true)
	User findByEmail(String email);
	
	@Query(value = "SELECT user_name FROM user u WHERE u.reset_token = ?1", nativeQuery = true)
	String findByResetToken(String resetToken);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE user SET reset_token=null WHERE reset_token = ?1", nativeQuery = true)
	void updateUserToken(String userToken);
}
