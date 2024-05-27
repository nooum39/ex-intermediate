package com.example.controller;

import com.example.domain.Cloth;
import com.example.form.ClothForm;
import com.example.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ex3")
public class ClothController {
    @Autowired
    private ClothService clothService;

    @GetMapping("/search")
    public String search(Model model, ClothForm clothForm) {
        Map<Integer, String> genderMap = new LinkedHashMap<>();
        genderMap.put(1, "Man");
        genderMap.put(2, "Woman");
        model.addAttribute("genderMap", genderMap);

        Map<Integer, String> colorMap = new LinkedHashMap<>();
        colorMap.put(1, "赤");
        colorMap.put(2, "青");
        colorMap.put(3, "白");
        colorMap.put(4, "黄");
        model.addAttribute("genderMap", genderMap);
        model.addAttribute("colorMap", colorMap);

        return "cloth_search";
    }

    @RequestMapping("/result")
    public String result(Model model, ClothForm form, BindingResult result) {
        if(result.hasErrors()) {
            return "search";
        }
        List<Cloth> clothList = new ArrayList<>();
        clothList = clothService.searchByColorAndGender(form.getGender(), form.getColor());
        model.addAttribute("clothList",clothList);
        return "cloth_search";
    }
}


