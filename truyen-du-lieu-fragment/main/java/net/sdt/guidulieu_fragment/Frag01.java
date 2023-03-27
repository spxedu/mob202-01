package net.sdt.guidulieu_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Frag01 extends Fragment {
    Button btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.layout_frag01,container,false);
        return  v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // xử lý tương tác với các thành phần trong fragment
         btn = view.findViewById(R.id.nut_bam_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Bấm ở Frag 01", Toast.LENGTH_SHORT).show();

                // gửi text sang Frag 02
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Frag02 frag02 = (Frag02) fm.findFragmentById(R.id.frag222);
                frag02.tv02.setText("Nội dung gửi từ Frag 01 sang ");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
