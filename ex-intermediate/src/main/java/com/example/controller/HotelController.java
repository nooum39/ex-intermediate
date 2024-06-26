package com.example.controller;


import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ホテル情報を管理するコントローラです.
 *
 * @author haruka.yamaneki
 */
@Controller
@RequestMapping("/ex2")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    /**
     * ホテル検索画面を表示します.
     *
     * @return ホテル検索画面
     */
    @GetMapping("/seach")
    public String seach(Model model, HotelForm form) {
        return "hotelSeach";
    }

    /**
     * ホテル検索結果画面を表示します.
     *
     * @param price 価格
     * @param model　モデル
     * @param form　フォーム
     * @return ホテル検索結果画面
     */
    @RequestMapping("/result")
    public String result(Integer price, Model model, HotelForm form) {
        List<Hotel> hotelList = hotelService.showBelowPrice(form.getPrice());
        model.addAttribute("hotelList", hotelList);
        return "hotelSeach";
    }
}







