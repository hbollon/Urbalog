package com.example.urbalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.urbalog.Json.JsonRole;

public class RoleConfigActivity extends AppCompatActivity {

    private Button modificationRole;
    private Button initRole;
    private Button addRole;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_config);

        mContext = RoleConfigActivity.this;

        modificationRole = findViewById(R.id.modificationRole);
        initRole = findViewById(R.id.initRole);
        addRole = findViewById(R.id.addRole);

        initRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonRole.recreate(mContext);
                Toast.makeText(mContext, "Les roles on été réinitialisés", Toast.LENGTH_LONG).show();
            }
        });

        addRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoleConfigActivity.this, AddRoleActivity.class);
                startActivity(intent);
                finish();
            }
        });
        modificationRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoleConfigActivity.this, RecyclerViewRolesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onBackPressed(){
        Intent intent = new Intent(this, ConfigurationActivity.class);
        startActivity(intent);
        finish();
    }
}