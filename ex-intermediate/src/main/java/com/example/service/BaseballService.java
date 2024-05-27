package com.example.service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BaseballService {
    @Autowired
    private BaseballRepository repository;

    public BaseballTeam load(Integer id){
        return repository.load(id);
    }

    public List<BaseballTeam> allFind(){
        return repository.findAll();
    }



}


