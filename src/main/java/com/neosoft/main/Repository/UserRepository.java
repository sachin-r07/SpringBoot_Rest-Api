package com.neosoft.main.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.neosoft.main.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.uname = :uname or u.surname = :surname or u.pincode = :pincode")
	List<User> findByUnameOrSurnameAndPincode(@Param("uname") String uname, @Param("surname") String surname,
			@Param("pincode") String pincode);

}
