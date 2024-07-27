package edu.sfsu.shrine.code.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.sfsu.shrine.R;
import edu.sfsu.shrine.code.model.RandomUserModel;

/* RecyclerView Adapter
 * The adapter has two main jobs:
 * 1. To create each of the views that are visible within the recycler view.
 * 2. Bind each view to a piece of data.
 *
 * The RecyclerView needs to display a set of cards, each containing an image and caption.
 *
 * The ViewHolder is used to specify which views should be used for each data item.
 * 1. Define a nested class:
 *      public static class ViewHolder extends RecyclerView.ViewHolder {
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<RandomUserModel> randomUserModel;

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        // View itemView = holder.itemView;

        RandomUserModel item = randomUserModel.get(position);
        holder.gender.setText(String.format("%s", item.getGender()));
        holder.name_title.setText(String.format("%s", item.getName_title()));
        holder.name_first.setText(String.format("%s", item.getName_first()));
        holder.name_last.setText(String.format("%s", item.getName_last()));
        holder.location_street_number.setText(String.format("%s", item.getLocation_street_number()));
        holder.location_street_name.setText(String.format("%s", item.getLocation_street_name()));
        holder.location_city.setText(String.format("%s", item.getLocation_city()));
        holder.location_state.setText(String.format("%s", item.getLocation_state()));
        holder.location_country.setText(String.format("%s", item.getLocation_country()));
        holder.location_postcode.setText(String.format("%s", item.getLocation_postcode()));
        holder.location_coordinates_latitude.setText(String.format("%s", item.getCoordinates_latitude()));
        holder.location_coordinates_longitude.setText(String.format("%s", item.getCoordinates_longitude()));
        holder.location_timezone_offset.setText(String.format("%s", item.getTimezone_offset()));
        holder.location_timezone_description.setText(String.format("%s", item.getTimezone_description()));
        holder.email.setText(String.format("%s", item.getEmail()));
        holder.login_uuid.setText(String.format("%s", item.getLogin_uuid()));
        holder.login_username.setText(String.format("%s", item.getLogin_username()));
        holder.login_password.setText(String.format("%s", item.getLogin_password()));
        holder.login_salt.setText(String.format("%s", item.getLogin_salt()));
        holder.login_md5.setText(String.format("%s", item.getLogin_md5()));
        holder.login_sha1.setText(String.format("%s", item.getLogin_sha1()));
        holder.login_sha256.setText(String.format("%s", item.getLogin_sha256()));
        holder.dob_age.setText(String.format("%s", item.getDob_age()));
        holder.dob_date.setText(String.format("%s", item.getDob_date()));
        holder.registered_date.setText(String.format("%s", item.getRegistered_date()));
        holder.registered_age.setText(String.format("%s", item.getDob_age()));
        holder.phone.setText(String.format("%s", item.getPhone()));
        holder.cell.setText(String.format("%s", item.getCell()));
        holder.id_name.setText(String.format("%s", item.getId_name()));
        holder.id_value.setText(String.format("%s", item.getId_value()));
        holder.picture_large.setText(String.format("%s", item.getPicture_large()));
        holder.picture_medium.setText(String.format("%s", item.getPicture_medium()));
        holder.picture_thumbnail.setText(String.format("%s", item.getPicture_thumbnail()));
        holder.nat.setText(String.format("%s", item.getNat()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // Static nested classes do not have access to other members of the enclosing class.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView gender;
        public TextView name_title;
        public TextView name_first;
        public TextView name_last;
        public TextView location_street_number;
        public TextView location_street_name;
        public TextView location_city;
        public TextView location_state;
        public TextView location_country;
        public TextView location_postcode;
        public TextView location_coordinates_latitude;
        public TextView location_coordinates_longitude;
        public TextView location_timezone_offset;
        public TextView location_timezone_description;
        public TextView email;
        public TextView login_uuid;
        public TextView login_username;
        public TextView login_password;
        public TextView login_salt;
        public TextView login_md5;
        public TextView login_sha1;
        public TextView login_sha256;
        public TextView dob_date;
        public TextView dob_age;
        public TextView registered_date;
        public TextView registered_age;
        public TextView phone;
        public TextView cell;
        public TextView id_name;
        public TextView id_value;
        public TextView picture_large;
        public TextView picture_medium;
        public TextView picture_thumbnail;
        public TextView nat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gender = itemView.findViewById(R.id.tv_gender);
            name_title = itemView.findViewById(R.id.tv_name_title);
            name_first = itemView.findViewById(R.id.tv_name_first);
            name_last = itemView.findViewById(R.id.tv_name_last);
            location_street_number = itemView.findViewById(R.id.tv_location_street_number);
            location_street_name = itemView.findViewById(R.id.tv_location_street_name);
            location_city = itemView.findViewById(R.id.tv_location_city);
            location_state = itemView.findViewById(R.id.tv_location_state);
            location_country = itemView.findViewById(R.id.tv_location_country);
            location_postcode = itemView.findViewById(R.id.tv_location_postcode);
            location_coordinates_latitude = itemView.findViewById(R.id.tv_location_coordinates_latitude);
            location_coordinates_longitude = itemView.findViewById(R.id.tv_location_coordinates_longitude);
            location_timezone_offset = itemView.findViewById(R.id.tv_location_timezone_offset);
            location_timezone_description = itemView.findViewById(R.id.tv_location_timezone_description);
            email = itemView.findViewById(R.id.tv_email);
            login_uuid = itemView.findViewById(R.id.tv_login_uuid);
            login_username = itemView.findViewById(R.id.tv_login_username);
            login_password = itemView.findViewById(R.id.tv_login_password);
            login_salt = itemView.findViewById(R.id.tv_login_salt);
            login_md5 = itemView.findViewById(R.id.tv_login_md5);
            login_sha1 = itemView.findViewById(R.id.tv_login_sha1);
            login_sha256 = itemView.findViewById(R.id.tv_login_sha256);
            dob_date = itemView.findViewById(R.id.tv_dob_date);
            dob_age = itemView.findViewById(R.id.tv_dob_age);
            registered_date = itemView.findViewById(R.id.tv_registered_date);
            registered_age = itemView.findViewById(R.id.tv_registered_age);
            phone = itemView.findViewById(R.id.tv_phone);
            cell = itemView.findViewById(R.id.tv_cell);
            id_name = itemView.findViewById(R.id.tv_id_name);
            id_value = itemView.findViewById(R.id.tv_id_value);
            picture_large = itemView.findViewById(R.id.tv_picture_large);
            picture_medium = itemView.findViewById(R.id.tv_picture_medium);
            picture_thumbnail = itemView.findViewById(R.id.tv_picture_thumbnail);
            nat = itemView.findViewById(R.id.tv_nat);
        }
    }
}