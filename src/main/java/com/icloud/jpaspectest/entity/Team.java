package com.icloud.jpaspectest.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String name;

    public Team(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "team",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Person> personList = new ArrayList<>();

    public void addPerson(Person person) {
        this.personList.add(person);
    }
}
