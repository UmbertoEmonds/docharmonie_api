package com.umbertoemonds.docharmonie.repository;

import java.util.List;

import com.umbertoemonds.docharmonie.model.Accord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccordRepository extends JpaRepository<Accord, Long> {
    List<Accord> findAllByGrilleIdOrderByPositionAsc(Integer grilleId);
}