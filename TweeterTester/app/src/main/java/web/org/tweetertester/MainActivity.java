package web.org.tweetertester;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;


public class MainActivity extends Activity {
    private static final String TWITTER_KEY = "8zKFLwF1TMTQkL5XmiF7gXqBj";
    private static final String TWITTER_SECRET = "3fZDeD7FrccYK8ui3MHy3AzG28eSGUgXSOvMPxJ6FMyXYLPaF3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        startLoginActivity();
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, AndroidTwitterExample.class));
    }
}