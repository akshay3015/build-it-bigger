package co.akshay.builditbigger;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

public class FragmentAskJoke extends Fragment {
    private Button btnHitme;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ask_joke,container,false);
        btnHitme = (Button) view.findViewById(R.id.btn_joke);
        btnHitme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchJoke(view);
            }
        });


        return view;
    }

    public void fetchJoke(View view) {
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        new GoogleEndPointsAsyncTask(getContext(), progressBar).execute();
    }
}
