package devsbox.com.jihanislam007.vite_mati.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import devsbox.com.jihanislam007.vite_mati.Fragment.DashBoardFragment;
import devsbox.com.jihanislam007.vite_mati.Fragment.LandListFragment;
import devsbox.com.jihanislam007.vite_mati.Fragment.LandPostFragment;
import devsbox.com.jihanislam007.vite_mati.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////Fragment Loder///////////////////////

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        DashBoardFragment dashBoardFragment = new DashBoardFragment();
        fragmentManager.beginTransaction().add(R.id.frag_container,dashBoardFragment).commit();

        ////////////////////////Fragment Loder///////////////////////

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.dashboard) {

            DashBoardFragment dashBoardFragment = new DashBoardFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.frag_container, dashBoardFragment).commit();

        } else if (id == R.id.LandNewPost) {

            LandPostFragment landPostFragment = new LandPostFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.frag_container, landPostFragment).commit();

        } else if (id == R.id.SoldLandList) {

            LandListFragment landListFragment = new LandListFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.frag_container, landListFragment).commit();

        } else if (id == R.id.unsoldLandList) {

            LandListFragment landListFragment = new LandListFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.frag_container, landListFragment).commit();

        } else if (id == R.id.buyerLandList) {

            LandListFragment landListFragment = new LandListFragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.frag_container, landListFragment).commit();

        } else if (id == R.id.communication) {
            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.share) {
            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
