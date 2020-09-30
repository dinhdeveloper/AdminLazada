package com.dinh.thuhuyen.activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.dinh.thuhuyen.R;
import com.dinh.thuhuyen.fragment.MenuMainFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout layoutRoot;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        FragmentManager fragmentManager = getSupportFragmentManager();
        MenuMainFragment fragment = new MenuMainFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.layoutRoot, fragment);
        transaction.commit();
    }

    private void addControls() {
        layoutRoot = findViewById(R.id.layoutRoot);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Nhấn lần nữa để thoát", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private int isShowContainer = 0;
    public void checkBack() {
        if (isShowContainer > 0) {
            isShowContainer--;
            FragmentManager fm = getSupportFragmentManager();
            if (fm.getBackStackEntryCount() > 0) {
                fm.popBackStack();
            }

            if (isShowContainer == 0) {
//                if (listProductOrder != null) {
//                    int countItemOrder = countOrderProduct();
//                    if (countItemOrder > 0) {
//                        view.setBadgeCart(countItemOrder);
//                    }
//
//
//                }
            }

        } else {
            checkFragment();
        }
    }
    private void checkFragment() {

        FragmentManager fm = getSupportFragmentManager();

        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();

        } else {
            super.onBackPressed();
        }
    }
}