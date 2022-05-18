package com.icloud.jpaspectest.repository;

import com.icloud.jpaspectest.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
