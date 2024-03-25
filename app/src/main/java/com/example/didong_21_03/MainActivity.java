package com.example.didong_21_03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private int selectedTabPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        ViewPager2 pager2 = findViewById(R.id.viewPager2);

        TablayoutAdapter adapter = new TablayoutAdapter(MainActivity.this);
        pager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setIcon(R.drawable.search);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.search);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.search);
                        break;

                    default:
                        tab.setIcon(R.drawable.search);
                        break;
                }
            }
        }).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectedTabPosition = tab.getPosition();
                updateTabBackground();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Không cần làm gì khi tab không được chọn
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Không cần làm gì khi tab được chọn lại
            }
        });
    }

    private void updateTabBackground() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                if (i == selectedTabPosition) {
                    Drawable icon = tab.getIcon();
                    if (icon != null) {
                        icon.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_IN);
                        tab.setIcon(icon);
                    }
                } else {
                    Drawable icon = tab.getIcon();
                    if (icon != null) {
                        icon.setColorFilter(null);
                        tab.setIcon(icon);
                    }
                }
            }
        }
    }
}
