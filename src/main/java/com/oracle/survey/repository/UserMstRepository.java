package com.oracle.survey.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oracle.survey.constants.QueryConstants;
import com.oracle.survey.entity.UserMST;

@Repository
public interface UserMstRepository extends CrudRepository<UserMST, Long> {
	
	@Query(value = QueryConstants.CHECK_USER)
	UserMST checkUser(@Param("userEmail") String userEmail,@Param("userPassword") String userPassword);

}
