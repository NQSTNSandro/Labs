package controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import servises.HumanServise;


@Controller
@RequiredArgsConstructor
@RequestMapping("/humans")
@ResponseBody
public class HumanController {
    @Autowired
    private final HumanServise servise;

    public void save() {
        servise.func();
    }
}
