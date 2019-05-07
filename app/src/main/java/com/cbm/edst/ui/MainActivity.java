package com.cbm.edst.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cbm.edst.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private View.OnClickListener mOpenDrawerOnClick, mBackOnClick;
    private NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        mToolbar = findViewById(R.id.toolbar);

        NavigationView navigationView = findViewById(R.id.navigation);
        mNavController = Navigation.findNavController(this, R.id.fragment);

        mOpenDrawerOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        };

        mBackOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNavController.navigateUp();
            }
        };

        mToolbar.findViewById(R.id.ivMenu).setOnClickListener(mOpenDrawerOnClick);

        Menu menu = navigationView.getMenu();
        MenuItem menuItem;
        for (int i = 0; i < 3; i++) {
            int fragmentId = R.id.homeFragment;
            switch (i) {
                case 0:  fragmentId = R.id.homeFragment;
                    break;
                case 1:
                    break;
                case 2:
                    break;
                default:
            }
            menuItem = menu.add(R.id.itemsGroup, fragmentId, Menu.NONE, null);
            menuItem.setActionView(R.layout.menu_item_layout);
            switch (i) {
                case 0:
                    ((TextView) menuItem.getActionView().findViewById(R.id.tv)).setText(getString(R.string.registration));
                    //            set Image for menu item
//            ((ImageView) menuItem.getActionView().findViewById(R.id.iv)).setImageResource();
                    break;
                case 1:
                    ((TextView) menuItem.getActionView().findViewById(R.id.tv)).setText(getString(R.string.inscription));
                    //            set Image for menu item
//            ((ImageView) menuItem.getActionView().findViewById(R.id.iv)).setImageResource();
                    break;
                case 2:
                    ((TextView) menuItem.getActionView().findViewById(R.id.tv)).setText(getString(R.string.contact_us));
                    //            set Image for menu item
//            ((ImageView) menuItem.getActionView().findViewById(R.id.iv)).setImageResource();
                    break;
                default:
            }
        }
        NavigationUI.setupWithNavController(navigationView, mNavController);
        mNavController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getId()) {
                    case R.id.homeFragment:
                        setToolbarTitle(R.string.registration, true, false);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void setToolbarTitle(@StringRes int titleRes, boolean isLogoVisible, boolean withBackButton) {
        String title = getString(titleRes);
        setToolbarTitle(title, isLogoVisible);
    }

    public void setToolbarTitle(String title, boolean isLogoVisible) {
        TextView tvAppTitle = mToolbar.findViewById(R.id.tv);
        tvAppTitle.setText(title);
        ImageView ivLogo = mToolbar.findViewById(R.id.ivMenu);
        if (isLogoVisible) {
            ivLogo.setVisibility(View.VISIBLE);
        } else {
            ivLogo.setVisibility(View.GONE);
        }
    }
}
