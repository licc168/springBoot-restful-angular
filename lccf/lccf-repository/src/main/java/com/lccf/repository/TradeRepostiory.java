package com.lccf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lccf.domain.TradeData;

public interface TradeRepostiory extends JpaRepository<TradeData, Long> {
    Long countByTimeLong(Long time);
}
