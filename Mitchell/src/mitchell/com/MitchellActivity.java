package mitchell.com;

import com.etc.etc.SystemPropertiesProxy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MitchellActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Bug.LOG = true;
		Bug.i(this, SystemPropertiesProxy.get(this, "log.tag." + Bug.DEBUG_TAG));
		SystemPropertiesProxy.set(this, "log.tag." + Bug.DEBUG_TAG, "VERBOSE");
		Bug.i(this, SystemPropertiesProxy.get(this, "log.tag." + Bug.DEBUG_TAG));
		Bug.v(this, "verbose is active: " + Log.isLoggable(Bug.DEBUG_TAG, Log.VERBOSE));
		Bug.d(this, "debug is active: " + Log.isLoggable(Bug.DEBUG_TAG, Log.DEBUG));
		Bug.i(this, "info is active: " + Log.isLoggable(Bug.DEBUG_TAG, Log.INFO));
		Bug.w(this, "warn is active: " + Log.isLoggable(Bug.DEBUG_TAG, Log.WARN));
		Bug.e(this, "error is active: " + Log.isLoggable(Bug.DEBUG_TAG, Log.ERROR));

    }
}