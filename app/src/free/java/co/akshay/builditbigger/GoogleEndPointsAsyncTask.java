package co.akshay.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.example.akshayshahane.myapplication.backend.jokesApi.JokesApi;
import com.example.akshayshahane.myapplication.backend.jokesApi.model.JokesBean;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import co.akshay.jokedisplayandroidlib.*;

/**
 * Created by akshayshahane on 27/08/17.
 */

public class GoogleEndPointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {



    private static JokesApi sJokesApi;
    private Context mContext;
    private ProgressBar mProgressBar;
    private String strJoke;
    private InterstitialAd mInterstitialAd;

    public GoogleEndPointsAsyncTask(Context context, ProgressBar progressBar) {
        mContext = context;
        mProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {

        if (null ==sJokesApi) {
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(BuildConfig.googleEndpontsUrl);

            sJokesApi = builder.build();
        }
            try {
                return sJokesApi.fetchJoke(new JokesBean()).execute().getJoke();
            } catch (IOException e) {
                return e.getMessage();
            }


    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        strJoke = s;

        mInterstitialAd = new InterstitialAd(mContext);
        mInterstitialAd.setAdUnitId(BuildConfig.AdId);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (mProgressBar != null) {
                    mProgressBar.setVisibility(View.GONE);
                }
                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                if (mProgressBar != null) {
                    mProgressBar.setVisibility(View.GONE);
                }
                startJokeDisplayActivity();
            }

            @Override
            public void onAdClosed() {
                startJokeDisplayActivity();
            }
        });
        AdRequest ar = new AdRequest
                .Builder()
                .addTestDevice("2C56765C2241F8D1EA67A240BDF6CDE8")
                .build();
        mInterstitialAd.loadAd(ar);


    }

    private void startJokeDisplayActivity() {
        Intent intent = new Intent(mContext, ActivityJokesDisplay.class);
        intent.putExtra(ActivityJokesDisplay.INTENTEXTRA, strJoke);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
