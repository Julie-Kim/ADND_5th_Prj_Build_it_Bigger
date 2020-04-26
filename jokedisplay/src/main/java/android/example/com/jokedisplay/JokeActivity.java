package android.example.com.jokedisplay;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.example.com.jokedisplay.databinding.ActivityJokeBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

public class JokeActivity extends AppCompatActivity {
    private static final String TAG = JokeActivity.class.getSimpleName();

    public static final String JOKE_KEY = "joke_key";

    private ActivityJokeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_joke);

        Intent intent = getIntent();
        if (intent == null) {
            Log.e(TAG, "onCreate(), intent is null.");
            return;
        }

        if (intent.hasExtra(JOKE_KEY)) {
            String joke = intent.getStringExtra(JOKE_KEY);
            Log.d(TAG, "onCreate(), joke: " + joke);

            if (TextUtils.isEmpty(joke)) {
                joke = getString(R.string.no_joke);
            }

            mBinding.tvJoke.setText(joke);
        }
    }
}
