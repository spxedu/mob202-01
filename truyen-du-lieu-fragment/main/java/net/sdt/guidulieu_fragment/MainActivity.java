package net.sdt.guidulieu_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = new Bundle();
        bundle.putString("hoTen", "Nguyen Van A");

//        //gán vào fragment
//        Frag01 frag01 = (Frag01) getSupportFragmentManager().findFragmentById(R.id.frag111);
//        frag01.setArguments(bundle); //gán dữ liệu vào fragment: Dùng cho khởi tọa fragment

        Button btn = findViewById(R.id.btn01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frag01 frag01 = (Frag01) getSupportFragmentManager().findFragmentById(R.id.frag111);
                frag01.btn.setText(" Nội dung gửi từ Activity ");
            }
        });



    }



}