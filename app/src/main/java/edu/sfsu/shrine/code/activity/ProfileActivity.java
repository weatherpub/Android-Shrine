package edu.sfsu.shrine.code.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import edu.sfsu.shrine.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();

        ImageView imgView = (ImageView) findViewById(R.id.article_image_view);
        TextView param_content = (TextView) findViewById(R.id.tv_article_content);

        String str_1 = intent.getStringExtra("image");
        String str_2 = intent.getStringExtra("content_fname");
        String str_3 = intent.getStringExtra("content_lname");

        Picasso.get().load(str_1).into(imgView);
        String m = str_2 + " " + str_3;

        param_content.setText(m);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}