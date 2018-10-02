package com.iteso.tarea4;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



public class ActivityMain extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    com.iteso.tarea4.beans.ItemProduct itemProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
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
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case Commons.IDK_SECTION1:
                    if(getIntent().getExtras() != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("ITEM", getIntent().getParcelableExtra("ITEM"));
                        Fragment fragment = new FragmentTechnology();
                        fragment.setArguments(bundle);
                        return fragment;
                    } else
                        return new FragmentTechnology();
                case Commons.IDK_SECTION2:
                    return new FragmentHome();
                case Commons.IDK_SECTION3:
                    return new FragmentElectronics();
                default:
                    return new FragmentTechnology();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return Commons.PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case Commons.IDK_SECTION1: return getString(R.string.title_section1).toUpperCase();
                case Commons.IDK_SECTION2: return getString(R.string.title_section2).toUpperCase();
                case Commons.IDK_SECTION3: return getString(R.string.title_section3).toUpperCase();
            }
            return null;
        }
    }
}