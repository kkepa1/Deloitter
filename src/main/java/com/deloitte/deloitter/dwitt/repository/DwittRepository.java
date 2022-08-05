package com.deloitte.deloitter.dwitt.repository;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DwittRepository extends JpaRepository<Dwitt, Long> {

}
