package com.haechan.settlement.revenue.repository;

import com.haechan.settlement.revenue.entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevenueRepository extends JpaRepository<Revenue, Long> {
}