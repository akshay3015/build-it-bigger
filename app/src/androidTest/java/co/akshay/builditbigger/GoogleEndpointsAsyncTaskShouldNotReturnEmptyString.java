package co.akshay.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;



import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;


/**
 * Created by akshayshahane on 28/08/17.
 *  Reference : https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints

 */


@RunWith(AndroidJUnit4.class)
public class GoogleEndpointsAsyncTaskShouldNotReturnEmptyString {
    private static final String TAG = "GoogleEndpointsAsyncTas";

    @Test
    public void asyncTaskShouldNotReturnEmptyString() {
        GoogleEndPointsAsyncTask task = new GoogleEndPointsAsyncTask(InstrumentationRegistry.getTargetContext(),null);
        task.execute();

        try{

            String fecthedJoke = task.get();
            Log.d(TAG, "asyncTaskShouldNotReturnEmptyString: "+fecthedJoke);
            assertNotNull(fecthedJoke);
            assertTrue(fecthedJoke.length() > 0);


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
