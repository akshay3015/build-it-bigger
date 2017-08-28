package co.akshay.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.example.akshayshahane.myapplication.backend.jokesApi.JokesApi;
import com.example.akshayshahane.myapplication.backend.jokesApi.model.JokesBean;

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
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
        strJoke = s;
        startJokeDisplayActivity(strJoke);



    }

    private void startJokeDisplayActivity(String joke) {
        Intent intent = new Intent(mContext, ActivityJokesDisplay.class);
        intent.putExtra(ActivityJokesDisplay.INTENTEXTRA, joke);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
