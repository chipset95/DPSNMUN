package chipset.dpsnmun.activities;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import chipset.dpsnmun.R;
import chipset.dpsnmun.fragements.ContactFragment;
import chipset.dpsnmun.fragements.DetailFragment;
import chipset.dpsnmun.fragements.HomeFragment;
import chipset.dpsnmun.fragements.ScheduleFragment;
import chipset.dpsnmun.fragements.SlideUpFragment;
import chipset.potato.Potato;

import static chipset.dpsnmun.resources.Constants.URL_DPSNMUN;
/*
 * Developer: chipset
 * Package : chipset.dpsnmun.activities
 * Project : DPSNMUN'14
 * Date : 9/11/14
 */

public class MainActivity extends AppCompatActivity {

    SlidingUpPanelLayout mSlidingUpPanelLayout;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    Toolbar mToolbar;
    ListView mDrawerListView;
    String[] mDrawerTitles;
    String mTitle = "DPSNMUN\'15";
    ImageView logoImageView;
    LinearLayout mDevLayout;
    MediaPlayer mMediaPlayer;
    boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlidingUpPanelLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_home);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerListView = (ListView) findViewById(R.id.drawer_list);
        logoImageView = (ImageView) findViewById(R.id.logoiv);
        mDevLayout = (LinearLayout) findViewById(R.id.dev_layout);

        mDevLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying) {
                    mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.mia);
                    mMediaPlayer.setLooping(true);
                    mMediaPlayer.start();
                    isPlaying = true;
                    invalidateOptionsMenu();
                    mDrawerLayout.closeDrawers();
                }
            }
        });

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name) {
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(R.string.app_name);
            }

            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(mTitle);
                if (mSlidingUpPanelLayout.isPanelExpanded())
                    mSlidingUpPanelLayout.collapsePanel();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mDrawerTitles = getResources().getStringArray(R.array.drawer_items_title);
        mDrawerListView.setAdapter(new ArrayAdapter<>(MainActivity.this,
                R.layout.drawer_list_item, mDrawerTitles));

        Fragment fra = new HomeFragment();
        FragmentManager fraManager = getSupportFragmentManager();
        fraManager.beginTransaction()
                .replace(R.id.content_frame, fra).commit();
        Fragment frag = new SlideUpFragment();
        FragmentManager fragManager = getSupportFragmentManager();
        fragManager.beginTransaction()
                .replace(R.id.slide_up_frame, frag).commit();


        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment fragment = new HomeFragment();
                switch (i) {
                    case 0: {
                        fragment = new HomeFragment();
                        break;
                    }
                    case 1: {
                        fragment = new DetailFragment();
                        break;
                    }
                    case 2: {
                        fragment = new ScheduleFragment();
                        break;
                    }
                    case 3: {
                        fragment = new ContactFragment();
                        break;
                    }
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment).commit();
                mTitle = mDrawerTitles[i];
                mDrawerLayout.closeDrawers();
                if (mSlidingUpPanelLayout.isPanelExpanded())
                    mSlidingUpPanelLayout.collapsePanel();
            }
        });

        logoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Potato.potate().Intents().browserIntent(getApplicationContext(), URL_DPSNMUN);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return isPlaying && super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else if (id == R.id.stop_mia) {
            mMediaPlayer.stop();
            isPlaying = false;
            invalidateOptionsMenu();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }

}
