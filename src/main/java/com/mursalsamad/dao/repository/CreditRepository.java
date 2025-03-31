package com.mursalsamad.dao.repository;
import com.mursalsamad.dao.entity.CreditEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.FETCH;

public interface CreditRepository extends JpaRepository<CreditEntity,Long> {

    @EntityGraph(attributePaths = {"statusHistories","customer"},type = FETCH)
    List<CreditEntity> findAllByStatus(String status);
}
