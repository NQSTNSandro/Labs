package controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import servises.HumanServise;

@Controller
@RequiredArgsConstructor
public class HumanController {
    @Autowired
    private final HumanServise servise;

    public void save() {
        servise.func();
    }
}
