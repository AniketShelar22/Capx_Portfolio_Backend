package com.example.portfolio.repository;

import com.example.portfolio.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("SELECT SUM(s.buyPrice * s.quantity) FROM Stock s")
    BigDecimal findTotalPortfolioValue();

    @Query("SELECT s FROM Stock s WHERE s.currentPrice = (SELECT MAX(s2.currentPrice) FROM Stock s2)")
    Stock findTopPerformingStock();
}
