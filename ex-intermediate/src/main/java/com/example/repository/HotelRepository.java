package com.example.repository;

import com.example.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * hotelsテーブルを操作するリポジトリです.
 *
 * @author haruka.yamaneki
 */

@Repository
public class HotelRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * Hotelオブジェクトを生成するRowMapperです.
     */
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setAreaName(rs.getString("area_name"));
        hotel.setHotelName(rs.getString("hotel_name"));
        hotel.setAddress(rs.getString("address"));
        hotel.setNearestStation(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        hotel.setParking(rs.getString("parking"));
        return hotel;
    };

    /**
     * price以下の価格をもったホテルの情報を降順に表示します.
     *
     * @param price
     * @return price以下の価格をもったホテルの情報
     */
    public List<Hotel> showBelowPrice(Integer price) {
        String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price<=:price ORDER BY price DESC;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
        List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
        return hotelList;
    }

    /**
     * すべてのホテルを表示します.
     * @param price
     * @return ホテル情報
     */
    public List<Hotel> showAllList() {
        String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels ORDER BY price DESC;";
        List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
        return hotelList;
    }


}