package com.example.repository;


import com.example.domain.BaseballTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * teamsテーブルを操作するリポジトリです.
 *
 * @author haruka.yamaneki
 */
@Repository
public class BaseballTeamRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;


    /**
     * BaseballTeamオブジェクトを生成するRowMapperです.
     */
    private static final RowMapper<BaseballTeam> BASEBALL_TEAM_ROW_MAPPER = (rs, i) -> {
        BaseballTeam baseballTeam = new BaseballTeam();
        baseballTeam.setId(rs.getInt("id"));
        baseballTeam.setLeagueName(rs.getString("league_name"));
        baseballTeam.setTeamName(rs.getString("team_name"));
        baseballTeam.setHeadquarters(rs.getString("headquarters"));
        baseballTeam.setInauguration(rs.getString("inauguration"));
        baseballTeam.setHistory(rs.getString("history"));
        return baseballTeam;
    };

    /**
     * 主キー検索を行う.
     *
     * @param id ID
     * @return　野球チーム情報
     */
    public BaseballTeam load(Integer id) {
        String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams WHERE id=:id;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        BaseballTeam baseballTeam = template.queryForObject(sql, param, BASEBALL_TEAM_ROW_MAPPER);
        return baseballTeam;
    }

    /**
     * 全探索を行う.
     *
     * @return 野球チーム一覧
     */
    public List<BaseballTeam> findAll() {
        String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams ORDER BY inauguration;";
        List<BaseballTeam> baseballTeamList = template.query(sql, BASEBALL_TEAM_ROW_MAPPER);
        return baseballTeamList;
    }


}



