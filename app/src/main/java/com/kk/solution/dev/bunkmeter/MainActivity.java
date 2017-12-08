package com.kk.solution.dev.bunkmeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Toolbar mToolbar;

    private InterstitialAd interstitialAd;

    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the interstitial
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-7920815986886474~9558080075");//This is a Test ID
        /*
        App IDs are unique identifiers given to mobile apps
        when they're registered in the AdMob console.
        To find your app ID, click the App management
        option under the settings dropdown
        (located in the upper right-hand corner)
        on the AdMob account page. App IDs have
        the form ca-app-pub-XXXXXXXXXXXXXXXX~NNNNNNNNNN.
        https://firebase.google.com/docs/admob/android/quick-start
         */
        //Create Request
        AdRequest adRequest = new AdRequest.Builder().build();

        //Start Loading...
        interstitialAd.loadAd(adRequest);

        //Once request is loaded,display ad.
        interstitialAd.setAdListener(new AdListener() {

            public void onAdLoaded() {
                displayInterstitialAd();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }
        });

        mAuth = FirebaseAuth.getInstance();

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Attendance Profile");

        btnContinue = (Button)findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bunkIntent = new Intent(MainActivity.this,BunkActivity.class);
                startActivity(bunkIntent);
            }
        });
    }

    public void displayInterstitialAd() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            sendToStart();
        }
    }

    private void sendToStart() {
        Intent startIntent = new Intent(MainActivity.this,StartActivity.class);
        startActivity(startIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.main_logout_btn)   {
            FirebaseAuth.getInstance().signOut();
            sendToStart();
        }
        return true;
    }

}
