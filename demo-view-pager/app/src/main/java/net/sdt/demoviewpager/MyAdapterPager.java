package net.sdt.demoviewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapterPager extends FragmentStateAdapter {
    int soLuong = 3;
    public MyAdapterPager(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //postion: thứ tự của fragment
        switch (position){
            case  0:
                return new Fragment01();
            case 1:
                return new Fragment02();
            default:
                return new Fragment01(); // mặc định trả về fragment 01
        }

    }

    @Override
    public int getItemCount() {
        return soLuong;
    }
}
