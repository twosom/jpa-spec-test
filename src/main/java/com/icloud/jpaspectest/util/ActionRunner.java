package com.icloud.jpaspectest.util;

import com.icloud.jpaspectest.entity.Person;
import com.icloud.jpaspectest.entity.Team;
import com.icloud.jpaspectest.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class ActionRunner implements ApplicationRunner {

    private final TeamRepository teamRepository;

    @Override
    public void run(ApplicationArguments args) {
        createTeam("team1");
        createTeam("team2");
    }

    private void createTeam(String teamName) {
        Team team = new Team(teamName);
        IntStream.range(1, 50)
                .boxed()
                .map(e -> new Person("first" + e, "last" + e, e, team))
                .forEach(team::addPerson);
        teamRepository.save(team);
    }
}
