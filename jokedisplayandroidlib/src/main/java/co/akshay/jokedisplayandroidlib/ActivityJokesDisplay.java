package co.akshay.jokedisplayandroidlib;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by akshayshahane on 27/08/17.
 */

public class ActivityJokesDisplay extends AppCompatActivity {

    public static final String INTENTEXTRA = "JOKE";
    private String joke;
    private TextView tvJoke;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_dispaly);
        tvJoke = (TextView) findViewById(R.id.tv_joke);

        if (getIntent().hasExtra(INTENTEXTRA)){
            joke = getIntent().getStringExtra(INTENTEXTRA);

        }

        if (TextUtils.isEmpty(joke)){
            tvJoke.setText("I think I am out of jokes, why don't you tell me one :p");

        }else {
            tvJoke.setText(joke);

        }

    }
}
