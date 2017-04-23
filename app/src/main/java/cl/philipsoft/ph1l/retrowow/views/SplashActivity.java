package cl.philipsoft.ph1l.retrowow.views;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cl.philipsoft.ph1l.retrowow.R;
import cl.philipsoft.ph1l.retrowow.background.services.ClassesService;
import cl.philipsoft.ph1l.retrowow.background.services.RacesService;
import cl.philipsoft.ph1l.retrowow.background.services.RealmsService;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity implements DataValidationCallback {

    private IntentFilter intentFilter;
    private BroadcastReceiver broadcastReceiver;
    private int races, classes, realms = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splash);

        View view = findViewById(R.id.splash);

        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        new DataValidation(this).init();

        intentFilter = new IntentFilter();
        //intentFilter.addAction();

    }

    @Override
    public void racesLoaded() {
        races = 1;
        if (races + classes + realms == 3) {

        }
    }

    @Override
    public void loadRaces() {
        RacesService.startActionRaces(this);
    }

    @Override
    public void classesLoaded() {
        classes = 1;
        if (races + classes + realms == 3) {

        }
    }

    @Override
    public void loadClasses() {
        ClassesService.startActionClasses(this);
    }

    @Override
    public void realmsLoaded() {
        realms = 1;
        if (races + classes + realms == 3) {

        }
    }

    @Override
    public void loadRealms() {
        RealmsService.startActionRealms(this);
    }
}
