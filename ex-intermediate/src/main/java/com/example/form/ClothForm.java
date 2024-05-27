package com.example.form;

/**
 *服の情報を格納するフォームです.
 */
public class ClothForm {
    /**
     * 性別
     */
    private String gender;
    /**
     * 色
     */
    private String color;

    @Override
    public String toString() {
        return "clothForm{" +
                "gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                '}';
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
}
