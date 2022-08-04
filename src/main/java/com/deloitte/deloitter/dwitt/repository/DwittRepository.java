package com.deloitte.deloitter.dwitt.repository;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DwittRepository extends JpaRepository<Dwitt, Integer> {

}
