package com.icloud.jpaspectest.repository;

import com.icloud.jpaspectest.entity.Person;
import com.icloud.jpaspectest.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long>,
        JpaSpecificationExecutor<Person> {

    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    List<Person> findByAge(Integer age);

    List<Person> findByTeam(Team team);
}
