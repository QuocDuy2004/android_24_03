package com.example.didong_21_03.tab_layout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.didong_21_03.R;
import com.google.android.flexbox.FlexboxLayout;

public class HomeFragment extends Fragment {

    // Mảng dữ liệu chứa thông tin sản phẩm
    private String[] productNames = {"Giày 1", "Giày 2", "Giày 2", "Giày 2"};
    private String[] productNames2 = {"XXX", "CCCC", "VVVV", "BBBB"};
    private int[] productPrices = {10000, 12000, 12000, 12000};
    private int[] productImages = {R.drawable.giay1, R.drawable.giay2, R.drawable.giay2, R.drawable.giay2};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Hiển thị dữ liệu sản phẩm ra màn hình
        displayProducts(view);

        return view;
    }

    // Phương thức để hiển thị dữ liệu sản phẩm ra màn hình
    private void displayProducts(View view) {
        FlexboxLayout flexboxLayout = view.findViewById(R.id.flexboxLayout);

        for (int i = 0; i < productNames.length; i++) {
            // Tạo mới một CardView từ layout đã được thiết kế trước
            View productView = LayoutInflater.from(getContext()).inflate(R.layout.item_product_cardview, flexboxLayout, false);

            // Lấy các thành phần giao diện từ view của CardView
            TextView ten_sp = productView.findViewById(R.id.ten_sp);
            TextView ten_sp2 = productView.findViewById(R.id.ten_sp2);
            TextView gia_sp = productView.findViewById(R.id.gia_sp);
            ImageView img_sp = productView.findViewById(R.id.img_sp);

            // Thiết lập thông tin cho từng thành phần từ mảng dữ liệu sản phẩm
            ten_sp.setText(productNames[i]);
            ten_sp2.setText(productNames2[i]);
            gia_sp.setText(productPrices[i] + " VNĐ");
            img_sp.setImageResource(productImages[i]);

            // Thêm CardView vào FlexboxLayout
            FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(
                    FlexboxLayout.LayoutParams.WRAP_CONTENT,
                    FlexboxLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(8, 8, 8, 8);
            productView.setLayoutParams(layoutParams);
            flexboxLayout.addView(productView);
        }
    }
}
