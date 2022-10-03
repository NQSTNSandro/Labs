package servises;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moduls.Division;
import moduls.Dto;
import moduls.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Slf4j
@RequiredArgsConstructor
@EnableAutoConfiguration
public class HumanServise {
    @Autowired
    private final HumanRepository repository;
    private final DtoService service;

    public void func() {
        Map<String, List<Dto>> map = service.func();
        for (String department : map.keySet()) {
            Division division = new Division();
            division.setDivision(department);
            List<Dto> humans = map.get(department);
            for (Dto dto : humans) {
                Human human = new Human();
                human.setDivision(division);
                human.setId(dto.getId());
                human.setName(dto.getName());
                human.setDayOfBirt(dto.getDayOfBirt());
                human.setSalary(dto.getSalary());
                human.setGender(dto.getGender());
                repository.save(human);
            }

        }
    }
    @Scheduled(fixedRateString = "1000000")
    public void requestSessions(){
        func();
    }
}
