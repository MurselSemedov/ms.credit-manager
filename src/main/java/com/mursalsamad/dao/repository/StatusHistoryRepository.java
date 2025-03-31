package com.mursalsamad.dao.repository;

import com.mursalsamad.dao.entity.StatusHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusHistoryRepository extends JpaRepository<StatusHistoryEntity,Long> {
}
