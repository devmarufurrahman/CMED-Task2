package com.maruf.cmedtask2.model;

public class CharactersModel {
    String full_name, father_name, profile_photo;

    public CharactersModel() {
    }

    public CharactersModel(String full_name, String father_name, String profile_photo) {
        this.full_name = full_name;
        this.father_name = father_name;
        this.profile_photo = profile_photo;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }
}
