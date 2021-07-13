package com.codediff.ocr.api.CashFlowManagementAPI.repos;

import com.codediff.ocr.api.CashFlowManagementAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
