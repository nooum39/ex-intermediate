package com.example.domain;

/**
 * 服のドメインです.
 * @author haruka.yamaneki
 */
public class Cloth {
    /**
     * カテゴリ
     */
    private String category;
    /**
     * ジャンル
     */
    private String genre;
    /**
     * 性別
     */
    private String gender;
    /**
     * 色
     */
    private String color;
    /**
     * 価格
     */
    private String price;
    /**
     * サイズ
     */
    private String size;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "category='" + category + '\'' +
                ", genre='" + genre + '\'' +
                ", gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", size='" + size + '\'' +
                '}';
    }


}