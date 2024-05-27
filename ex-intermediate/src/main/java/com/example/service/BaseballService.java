package com.example.service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 野球チーム関連の処理を行うメソッドがあるサービスです.
 *
 * @author haruka.yamaneki
 */

@Service
@Transactional
public class BaseballService {
    @Autowired
    private BaseballRepository repository;

    /**
     * 野球チームの情報をロードする.
     *
     * @param id
     * @return 野球チームの情報
     */
    public BaseballTeam load(Integer id) {
        return repository.load(id);
    }

    /**
     * 野球チームの一覧情報を取得する.
     *
     * @return　野球チーム一覧情報
     */
    public List<BaseballTeam> showList() {
        return repository.findAll();
    }


}


