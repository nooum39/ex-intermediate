package com.example.service;

import com.example.domain.BaseballTeam;
import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ホテル検索関連の処理を行うメソッドがあるサービスです.
 *
 * @author haruka.yamaneki
 */
@Service
@Transactional
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    /**
     * 引数よりも低い価格のホテルを表示するメソッドを呼び出します.
     *
     * @param price 価格
     * @return　ホテル一覧
     */
    public List<Hotel> showBelowPrice(Integer price) {
        if (price == null) {
            return hotelRepository.findByAll();

        }
        return hotelRepository.findByBelowPrice(price);
    }


}
