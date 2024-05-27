package com.example.service;


import com.example.domain.Cloth;
import com.example.repository.ClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服の検索処理を管理するサービスです.
 *
 * @author haruka.yamaneki
 */
@Service
@Transactional
public class ClothService {
    @Autowired
    private ClothRepository clothRepository;

    /**
     * 性別と色が適当な服の検索を行うメソッドを呼び出します.
     *
     * @param gender
     * @param color
     * @return　服の情報
     */
    public List<Cloth> searchByColorAndGender(String gender, String color) {
        return clothRepository.searchByColorAndGender(gender, color);
    }

}
