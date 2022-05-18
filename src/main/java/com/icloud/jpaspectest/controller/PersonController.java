package com.icloud.jpaspectest.controller;


import com.icloud.jpaspectest.entity.Person;
import com.icloud.jpaspectest.entity.Team;
import com.icloud.jpaspectest.repository.PersonRepository;
import com.icloud.jpaspectest.repository.PersonSpecification;
import com.icloud.jpaspectest.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;
    private final TeamRepository teamRepository;

    @GetMapping
    public List<Person> findAll(@RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName,
                                @RequestParam(required = false) Integer age,
                                @RequestParam(required = false) Long teamId,
                                @RequestParam(required = false) String teamName) {
        Specification<Person> spec = (root, query, criteriaBuilder) -> null;
        if (firstName != null) {
            spec = spec.and(PersonSpecification.equalFirstName(firstName));
        }
        if (lastName != null) {
            spec = spec.and(PersonSpecification.equalLastName(lastName));
        }
        if (age != null) {
            spec = spec.and(PersonSpecification.geAge(age));
        }
        if (teamId != null) {
            Team team = teamRepository.getById(teamId);
            spec = spec.and(PersonSpecification.equalTeam(team));
        }
        if (teamName != null) {
            spec = spec.and(PersonSpecification.equalTeamName(teamName));
        }

        return personRepository.findAll(spec);
    }

}
