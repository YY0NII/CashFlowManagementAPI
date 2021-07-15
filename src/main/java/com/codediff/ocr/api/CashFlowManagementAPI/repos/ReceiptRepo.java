package com.codediff.ocr.api.CashFlowManagementAPI.repos;

import com.codediff.ocr.api.CashFlowManagementAPI.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReceiptRepo extends JpaRepository<Receipt, Long> {

}
