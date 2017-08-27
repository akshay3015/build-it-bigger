package co.akshay.builditbigger;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class FragmentAskJoke extends Fragment {


    private Button btnHitme;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View viewRoot = inflater.inflate(R.layout.fragment_ask_joke,container,false);
        btnHitme = (Button) viewRoot.findViewById(R.id.btn_joke);
        btnHitme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchJoke(viewRoot);
            }
        });

        AdView adView = viewRoot.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("2C56765C2241F8D1EA67A240BDF6CDE8").build();

        Log.d("ADDD", "onCreateView: "+adRequest.isTestDevice(getContext()));
        adView.loadAd(adRequest);



        return viewRoot;
    }


    public void fetchJoke(View view) {
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        new GoogleEndPointsAsyncTask(getContext(), progressBar).execute();
    }
}
