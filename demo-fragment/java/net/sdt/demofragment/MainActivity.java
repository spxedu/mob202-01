package net.sdt.demofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    FragmentManager fm ;
    Frag01 frag01;
    Frag02 frag02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        frag01 = new Frag01();
        frag02 = new Frag02();

        fm = getSupportFragmentManager();
        // khởi tạo gắn fragment đầu tiên cho ứng dụng
        fm.beginTransaction()
                .add(R.id.frag_container, frag01)
                .commit();
        // xử lý sự kiện bấm nút đổi fragment
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.frag_container, frag01).commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.frag_container, frag02).commit();
            }
        });

    }
}