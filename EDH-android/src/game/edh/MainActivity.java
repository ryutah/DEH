package game.edh;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useCompass = false;
        cfg.hideStatusBar = true;
        cfg.useAccelerometer = false;
        cfg.useWakelock = true;
        
        initialize(new EdhGame(), cfg);
    }
}