package com.example.pentagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.pentagram.adapter.PageAdapter;
import com.example.pentagram.fragment.PerfilMascotaFragment;
import com.example.pentagram.fragment.RecyclerViewFragment;
import com.example.pentagram.pojo.contacto;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar miActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tableLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        if (miActionBar!=null){
            setSupportActionBar(miActionBar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.paw_dog);
                getSupportActionBar().setTitle(R.string.app_name);
            }
        }
        setupViewPager();
    }

    private ArrayList<Fragment> agregandoFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilMascotaFragment());
        return fragments;
    }

    private void setupViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregandoFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home50);
        tabLayout.getTabAt(1).setIcon(R.drawable.jake50);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate ( R.menu.barra, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId ()){
            case R.id.iestrella:
                //Toast.makeText ( this,"ranquet",Toast.LENGTH_SHORT ).show ();
                Intent intent = new Intent(this, Mascotasfavoritos.class);
                this.startActivity(intent);
                break;
            case R.id.icontacto:
                //Toast.makeText ( this,"ranquet",Toast.LENGTH_SHORT ).show ();
                Intent intent1 = new Intent(this, contacto.class);
                this.startActivity(intent1);
                break;
            case R.id.iacercade:
                //Toast.makeText ( this,"ranquet",Toast.LENGTH_SHORT ).show ();
                Intent intent2 = new Intent(this, BioDesarrollador.class);
                this.startActivity(intent2);
                break;
            default:
                return super.onOptionsItemSelected ( item );
        }
        return true;
    }
}