package com.example.controller;


import com.example.domain.BaseballTeam;
import com.example.service.BaseballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex1")
public class BaseballController {
    @Autowired
    private BaseballService baseballService;

    /**
     * 野球チーム一覧を表示します.
     *
     * @param model
     * @return 野球チーム一覧画面
     */
    @GetMapping("/showList")
    public String showList(Model model) {
        model.addAttribute("baseballList", baseballService.showList());
        return "list";
    }

    /**
     * 野球チーム情報を取得します.
     *
     * @param id    ID
     * @param model 　モデル
     * @return　取得した野球チームの情報画面
     */
    @GetMapping("/showDetail")
    public String showDetail(Integer id, Model model) {
        model.addAttribute("baseballTeams", baseballService.load(id));
        return "detail";

    }

}
