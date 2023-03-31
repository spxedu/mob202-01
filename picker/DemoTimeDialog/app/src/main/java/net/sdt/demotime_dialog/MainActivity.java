package net.sdt.demotime_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText ed_date;
    Button btn_save;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DemoChuyenNgayThang();
        ed_date = findViewById(R.id.ed_date);
        btn_save = findViewById(R.id.btn_save);

        ed_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPickerDialog();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // tạo đối tượng format để chuyển đổi về dạng năm-thang-ngay
                android.text.format.DateFormat dateFormat = new DateFormat();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
                String ngay_chon = ed_date.getText().toString().trim();

                try {
                    Date objNgay = format.parse(ngay_chon );
                    // chuyển định dạng
                    String chuoi_CSDL = (String) dateFormat.format("yyyy-MM-dd", objNgay);
                    Toast.makeText(MainActivity.this, "Ngày lưu CSDL: "+ chuoi_CSDL, Toast.LENGTH_SHORT).show();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    void showPickerDialog(){
        // tạo đối tượng Lịch để cài đặt thời gian.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(   System.currentTimeMillis()   ); // cài đặt ngày giờ hiện tại vào lịch
        // Khởi tạo dialog picker
//        DatePickerDialog(@NonNull Context context, @Nullable DatePickerDialog.OnDateSetListener listener, int year, int month, int dayOfMonth)
        DatePickerDialog dialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        // xử lý nhận ngày tháng ở đây
                        int nam = i;
                        int thang = i1; // nhận từ 0 ==> 11
                        int ngay = i2;
                        // gán vào edittext
                        ed_date.setText( ngay + "/" +  (thang + 1) + '/' + nam   );
                    }
                },
                calendar.get( Calendar.YEAR ),
                calendar.get( Calendar.MONTH),
                calendar.get( Calendar.DATE )
        );
        dialog.show();

    }






    String TAG = "zzzzzzzz";
    void DemoChuyenNgayThang(){
        //1. Lấy ngày tháng hiện tại của hệ thống:
        Date objDate = new Date( System.currentTimeMillis()  );
        Log.d(TAG, "DemoChuyenNgayThang: objDate = " + objDate.toString() );
        //2. Chuyển đổi định dạng ngày tháng, các ký hiệu:  dd là ngày, MM là tháng, yyyy năm
        //Tạo đối tượng để format
        android.text.format.DateFormat dateFormat = new DateFormat();
        String chuoi_ngay_thang_nam = (String) dateFormat.format("dd/MM/yyyy", objDate);
        Log.d(TAG, "Chuoi ngay/thang/nam: " + chuoi_ngay_thang_nam );
        // Để lưu vào CSDL thì lưu dạng   yyyy-MM-dd ,
        // tạo chuỗi lưu CSDL:
        String saveDate = (String) dateFormat.format("yyyy-MM-dd", objDate);
        Log.d(TAG, "Chuoi Nam-Thang-ngay: " + chuoi_ngay_thang_nam );
        // Trường hợp người dùng nhập từ giao diện dạng ngày/tháng/năm ==> lưu vào CSDL sẽ cần chuyển định dạng
        // Giả sử chuỗi người dùng nhập là
        String chuoi_nhap = "31/03/2023";  // cần chuyển về dạng:  năm-tháng-ngày để lưu vào CSDL
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY"); // khuôn dạng chuỗi đầu vào
        try {
            Date objNgay = format.parse( chuoi_nhap );
            String chuoi_csdl = (String) dateFormat.format("yyyy-MM-dd", objNgay);
            Log.d(TAG, "Chuỗi người dùng nhập:  " + chuoi_nhap + " --> Lưu CSDL: " + chuoi_csdl );
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }




}