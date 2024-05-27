package com.example.repository;

import com.example.domain.Cloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * clothesテーブルを操作するリポジトリです.
 * @author haruka.yamaneki
 */
@Repository
public class ClothRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * clothオブジェクトを生成するRowMapperです.
     */
    private static final RowMapper<Cloth> CLOTH_ROW_MAPPER = (rs, i) -> {
        Cloth cloth = new Cloth();
        cloth.setCategory(rs.getString("category"));
        cloth.setGenre(rs.getString("genre"));
        cloth.setGender(rs.getString("gender"));
        cloth.setSize(rs.getString("color"));
        cloth.setPrice(rs.getString("price"));
        cloth.setColor(rs.getString("size"));
        return cloth;
    };

    /**
     * 性別と色が適当な服を価格の昇順に並べて表示します.
     *
     * @param gender 性別
     * @param color  　色
     * @return　服の情報
     */
    public List<Cloth> searchByColorAndGender(String gender, String color) {
        String sql = "SELECT category,genre,gender,color,price,size FROM clothes WHERE gender=:gender AND color=:color ORDER BY price;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
        return template.query(sql, param, CLOTH_ROW_MAPPER);
    }





}
