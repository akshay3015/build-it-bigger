# build-it-bigger

This project consist of that uses multiple flavors, free flavor conatins ads while paid flavor is ad free.
App uses a Java library which provides jokes, Android library contains library to display joke and (GCE) Google Cloud EndPoints to Fetch jokes.
This App fetches joke from GCE and pass it to Android library which displays it.

## Useful tutorials 
https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints



## Important
- To see adds in free flavor. Check logcat output for the hashed device ID to get test ads on a  device.Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device.


```Java
  AdView adView = viewRoot.findViewById(R.id.adView);
         AdRequest adRequest = new AdRequest.Builder().addTestDevice("Use your device Id").build();
 
         Log.d("ADDD", "onCreateView: "+adRequest.isTestDevice(getContext()));
         adView.loadAd(adRequest);
``` 