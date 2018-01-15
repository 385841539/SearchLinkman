package com.example.ruedy.searchlinkman;

public class Person {

    private String name;

    private String pinyin;

    public Person(String name){
        this.name = name;
        this.pinyin = PinYinUtils.getPinYin(name.substring(0,1));
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }
}
