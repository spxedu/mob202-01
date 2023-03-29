package net.sdt.demoviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class MyCollectionFrag extends Fragment {
    MyAdapterPager myAdapterPager;
    ViewPager2 pager2 ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_collection_frag, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // thiết lập adapter cho ViewPager hoạt động
        myAdapterPager = new MyAdapterPager(this);
        pager2 = view.findViewById(R.id.pager_01);
        pager2.setAdapter( myAdapterPager );
    }
}