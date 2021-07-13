package com.codediff.ocr.api.CashFlowManagementAPI.repos;

import com.codediff.ocr.api.CashFlowManagementAPI.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
}
