package edu.sfsu.shrine.code.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import kotlinx.coroutines.CoroutineScope;

public class RandomUserModel extends ViewModel {
    private final String gender;
    private final String name_title;
    private final String name_first;
    private final String name_last;
    private final int location_street_number;
    private final String location_street_name;
    private final String location_city;
    private final String location_state;
    private final String location_country;
    private final int location_postcode;
    private final String coordinates_latitude;
    private final String coordinates_longitude;
    private final String timezone_offset;
    private final String timezone_description;
    private final String email;
    private final String login_uuid;
    private final String login_username;
    private final String login_password;
    private final String login_salt;
    private final String login_md5;
    private final String login_sha1;
    private final String login_sha256;
    private final String dob_date;
    private final int dob_age;
    private final String registered_date;
    private final int registered_age;
    private final String phone;
    private final String cell;
    private final String id_name;
    private final String id_value;
    private final String picture_large;
    private final String picture_medium;
    private final String picture_thumbnail;
    private final String nat;

    public RandomUserModel(String cell, String coordinates_latitude, String coordinates_longitude, int dob_age, String dob_date, String email, String gender, String id_name, String id_value, String location_city, String location_country, int location_postcode, String location_state, int location_street_number, String location_street_name, String login_md5, String login_password, String login_salt, String login_sha1, String login_sha256, String login_username, String login_uuid, String name_first, String name_last, String name_title, String nat, String phone, String picture_large, String picture_medium, String picture_thumbnail, int registered_age, String registered_date, String timezone_description, String timezone_offset) {
        this.cell = cell;
        this.coordinates_latitude = coordinates_latitude;
        this.coordinates_longitude = coordinates_longitude;
        this.dob_age = dob_age;
        this.dob_date = dob_date;
        this.email = email;
        this.gender = gender;
        this.id_name = id_name;
        this.id_value = id_value;
        this.location_city = location_city;
        this.location_country = location_country;
        this.location_postcode = location_postcode;
        this.location_state = location_state;
        this.location_street_number = location_street_number;
        this.location_street_name = location_street_name;
        this.login_md5 = login_md5;
        this.login_password = login_password;
        this.login_salt = login_salt;
        this.login_sha1 = login_sha1;
        this.login_sha256 = login_sha256;
        this.login_username = login_username;
        this.login_uuid = login_uuid;
        this.name_first = name_first;
        this.name_last = name_last;
        this.name_title = name_title;
        this.nat = nat;
        this.phone = phone;
        this.picture_large = picture_large;
        this.picture_medium = picture_medium;
        this.picture_thumbnail = picture_thumbnail;
        this.registered_age = registered_age;
        this.registered_date = registered_date;
        this.timezone_description = timezone_description;
        this.timezone_offset = timezone_offset;
    }

    public String getCell() {
        return cell;
    }

    public String getCoordinates_latitude() {
        return coordinates_latitude;
    }

    public String getCoordinates_longitude() {
        return coordinates_longitude;
    }

    public int getDob_age() {
        return dob_age;
    }

    public String getDob_date() {
        return dob_date;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getId_name() {
        return id_name;
    }

    public String getId_value() {
        return id_value;
    }

    public String getLocation_city() {
        return location_city;
    }

    public String getLocation_country() {
        return location_country;
    }

    public int getLocation_postcode() {
        return location_postcode;
    }

    public String getLocation_state() {
        return location_state;
    }

    public int getLocation_street_number() {
        return location_street_number;
    }

    public String getLocation_street_name() {
        return location_street_name;
    }

    public String getLogin_md5() {
        return login_md5;
    }

    public String getLogin_password() {
        return login_password;
    }

    public String getLogin_salt() {
        return login_salt;
    }

    public String getLogin_sha1() {
        return login_sha1;
    }

    public String getLogin_sha256() {
        return login_sha256;
    }

    public String getLogin_username() {
        return login_username;
    }

    public String getLogin_uuid() {
        return login_uuid;
    }

    public String getName_first() {
        return name_first;
    }

    public String getName_last() {
        return name_last;
    }

    public String getName_title() {
        return name_title;
    }

    public String getNat() {
        return nat;
    }

    public String getPhone() {
        return phone;
    }

    public String getPicture_large() {
        return picture_large;
    }

    public String getPicture_medium() {
        return picture_medium;
    }

    public String getPicture_thumbnail() {
        return picture_thumbnail;
    }

    public int getRegistered_age() {
        return registered_age;
    }

    public String getRegistered_date() {
        return registered_date;
    }

    public String getTimezone_description() {
        return timezone_description;
    }

    public String getTimezone_offset() {
        return timezone_offset;
    }
}