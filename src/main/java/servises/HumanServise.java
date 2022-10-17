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

import javax.transaction.Transactional;
import java.util.*;


@Service
@Slf4j
@RequiredArgsConstructor
@EnableAutoConfiguration
@Transactional
public class HumanServise {
    @Autowired
    private final HumanRepository repository;
    private final DivisionRepository divisionRepository;
    private final DtoService service;

    /**
     * func()- заносит данные из dto в Human и division, а также сохраняет их в бд.
     */

    public void func() {
        Map<String, List<Dto>> map = service.func();
        List<Human> humanList = new ArrayList<>();
        for (String department : map.keySet()) {
            Division division = new Division();
            division.setDivision(department);
            List<Dto> humans = map.get(department);
            Division entity = divisionRepository.save(division);
            for (Dto dto : humans) {
                Human human = new Human();
                human.setId(dto.getId());
                human.setName(dto.getName());
                human.setDayOfBirt(dto.getDayOfBirt());
                human.setSalary(dto.getSalary());
                human.setGender(dto.getGender());
                human.setDivision(entity);
                humanList.add(human);
            }
        }
        repository.saveAll(humanList);
        System.out.println("Ok");
    }

    @Scheduled(fixedRateString = "1000000")
    public void requestSessions() {
        func();
    }
}
