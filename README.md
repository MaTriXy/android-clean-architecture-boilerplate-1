# Android Clean Architecture Boilerplate
is a starting blank template for Android Projects

# Libraries
* **AppCompat**
* **Support Design**
* **Timber:** [https://github.com/JakeWharton/timber](https://github.com/JakeWharton/timber)
* **Butterknife:** [http://jakewharton.github.io/butterknife](http://jakewharton.github.io/butterknife)
* **Picasso:** [https://github.com/square/picasso](https://github.com/square/picasso)
* **Dagger:** [http://google.github.io/dagger/](http://google.github.io/dagger/)
* **Retrofit:** [http://square.github.io/retrofit](http://square.github.io/retrofit)
* **GSON:** [https://github.com/google/gson](https://github.com/google/gson)
* **RXJava** [https://github.com/ReactiveX/RxJava](https://github.com/ReactiveX/RxJava)
* **okHTTP** [http://square.github.io/okhttp](http://square.github.io/okhttp)
* **Facebook SDK** [https://developers.facebook.com/docs/android](https://developers.facebook.com/docs/android)
* **Twitter SDK** [hhttps://docs.fabric.io/android/twitter/twitter.html](https://docs.fabric.io/android/twitter/twitter.html)
* **Google SDK** [https://developers.google.com/api-client-library/java/google-api-java-client/oauth2](https://developers.google.com/api-client-library/java/google-api-java-client/oauth2)
* **EasyForm** [https://github.com/emmasuzuki/EasyForm](https://github.com/emmasuzuki/EasyForm)
* **Sweet Alert Dialog** [https://github.com/pedant/sweet-alert-dialog](https://github.com/pedant/sweet-alert-dialog)
* **Sugar ORM** [https://github.com/satyan/sugar](https://github.com/satyan/sugar)
* **Java JWT** [https://github.com/jwtk/jjwt](https://github.com/jwtk/jjwt)
* **Particle** [https://github.com/JeasonWong/Particle](https://github.com/JeasonWong/Particle)
* **CircleImageView** [https://github.com/hdodenhof/CircleImageView](https://github.com/hdodenhof/CircleImageView)
* **Material DateTime Picker - Select a time/date in style** [https://github.com/wdullaer/MaterialDateTimePicker](https://github.com/wdullaer/MaterialDateTimePicker)
* **RippleEffect** [https://github.com/traex/RippleEffect](https://github.com/traex/RippleEffect)
* **Picasso** [http://square.github.io/picasso](http://square.github.io/picasso)
* **Socket.IO-client Java** [https://github.com/socketio/socket.io-client-java](https://github.com/socketio/socket.io-client-java)
* **Firebase Cloud Messaging** [https://firebase.google.com/docs/cloud-messaging](https://firebase.google.com/docs/cloud-messaging)
* **PayPal Android SDK** [https://github.com/paypal/PayPal-Android-SDK](https://github.com/paypal/PayPal-Android-SDK)
* **PhotoView** [https://github.com/chrisbanes/PhotoView](https://github.com/chrisbanes/PhotoView)

# Utilities Usage
### Running Logic on Thread
```sh
MainThreadImp.getInstance().post(new Runnable() {
  @Override
  public void run() {
    
  }
});
```

### Camera
```sh
@Inject
Launcher launcher;

int REQUEST_IMAGE_CAPTURE = launcher.REQUEST_IMAGE_CAPTURE;
launcher.takePicture();

// on activity result
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
    Bundle extras = data.getExtras();
    Bitmap imageBitmap = (Bitmap) extras.get("data");
    if (imageBitmap != null) {
      // location: imageBitmap.toString()
    }
  }
}
```

### Video
```sh
@Inject
Launcher launcher;

int REQUEST_VIDEO_CAPTURE = launcher.REQUEST_VIDEO_CAPTURE;
launcher.takeVideo();

// on activity result
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
    // video file: launcher.videoFile(data);
  }
}
```

### Accelerometer
```sh
@Inject
AccelListener accelListener;

// accelerometer
accelListener.listener(new SensorEventListener() {
  public void onSensorChanged(SensorEvent event) {
    // only look at accelerometer events
    if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER) {
      return;
    }
    
    // X: event.values[0]
    // Y: event.values[1]
    // Z: event.values[2]
  }

  @Override
  public void onAccuracyChanged(Sensor sensor, int accuracy) {

  }
});

// start
try {
  accelListener.start();
} catch (Exception e) {
  e.printStackTrace();
}

// stop
accelListener.stop();
```

### GPS
```sh
@Inject
GPS gps;

// gps
gps.run(new LocationListener() {
  @Override
  public void onLocationChanged(Location location) {
    // LAT: location.getLatitude()
    // LNG: location.getLongitude()
  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {

  }

  @Override
  public void onProviderEnabled(String provider) {

  }

  @Override
  public void onProviderDisabled(String provider) {

  }
});
```

### Screen Orientation
```sh
@Inject
ScreenOrientation orientation;
    
// screen orientation
TYPES:
UNSPECIFIED, LANDSCAPE_PRIMARY, PORTRAIT_PRIMARY, LANDSCAPE, PORTRAIT, LANDSCAPE_SECONDARY, PORTRAIT_SECONDARY

try {
  orientation.apply(TYPES);
} catch (Exception e) {
  e.printStackTrace();
}
```

### Vibration
```sh
@Inject
Vibrate vibrate;
    
long[] patterns = {100, 200, 300, 400, 500};
vibrate.pattern(patterns, 1);
```

### Audio Player
```sh
@Inject
AudioHandler audioHandler;

// play audio
audioHandler.play("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.audio);
```

### Video Player
```sh
@Inject
VideoHandler videoHandler;

videoHandler.play("https://www.youtube.com/path-to-video");
videoHandler.play("http://your-domain-name/video.mp4");
videoHandler.play("file:///your-path/demo.mp4");
videoHandler.play("file:///android_asset/your-path/demo.mp4");
```

### Dialogs
```sh
// error dialog
DialogFactory.error(ctx, "Title", "Message!",
  new DialogInterfaceFactory().OnClick(new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
                      
    }
})).show();
```

### Alerts
```sh
@Inject
WBAlerts wbAlerts;

wbAlerts.error("Error Name", "Error Message").show();
```

### API Call
```sh
// Call API
YourAdapter yourAdapter = new YourAdapter();
Call<YOURMODELNAME> call = yourAdapter.getUser("username");
call.enqueue(new Callback<YOURMODELNAME>() {
  @Override
  public void onResponse(Call<YOURMODELNAME> call, Response<YOURMODELNAME> response) {
    final Response<YOURMODELNAME> res = response;
    
    // sample response model
    // res.body().getEmail()
  }
  
  @Override
  public void onFailure(Call<YOURMODELNAME> call, Throwable t) {
    
  }
});
```

### SMTP
```sh
@Inject
SMTP smtp;

smtp.username = "your-gmail@gmail.com";
smtp.password = "your-password";

smtp.host = "smtp.gmail.com";

// single email
smtp.email = "to-someone@yahoo.com";
// multiple email
smtp.emailMultiple = "to-someone@yahoo.com,to-other-someone@yahoo.com";

smtp.subject = "JavaMail Demo";
smtp.message = "Content of the demo";

smtp.attachment = new File(Environment.getExternalStorageDirectory() +
  File.separator + "DCIM" + File.separator + "Camera" + File.separator + "your-image.png").toString();

// send the email
smtp.execute();
```

### IMAP
```sh
@Inject
IMAP imap;

private class FetchEmail extends AsyncTask<Void, Void, Void> {
  @Override
        protected Void doInBackground(Void... voids) {
            imap.username = "your-email@your-provider.com";
            imap.password = "your-email-password";

            imap.host = "imap.your-provider.com";

            IMAP.ContentMessages[] messages = imap.fetch();
            for (IMAP.ContentMessages message : messages) {
              // message.getReceivedDate().toString()
            }

            // close the connection
            imap.close();

            return null;
        }
}

// execute the task
new FetchEmail().execute();
```

### Network Connection Type
```sh
@Inject
Network network;

// type
network.connectionInfo().getString("type");
// info
network.connectionInfo().getString("info");
```

### SocketIO
```sh
@Inject
SocketIOConnector socketIOConnector;

socketIOConnector.setUp();
// response
Emitter.Listener onNewMessage = args -> mActivity.runOnUiThread(() -> {
    String response = (String) args[0];
    Log.i(TAG, "Response: " + response);
});
socketIOConnector.listen("recieved_message", onNewMessage);

// connect
socketIOConnector.connect();

// sent data, message or what ever you
socketIOConnector.sendString("send_message", "We will sent data here!");
```

### FireBase Cloud Messaging
```sh
Replace the google-service.json under app folder with your own.
```

### SIP Phone
```sh
// start SIP Service
startService(new Intent(getBaseContext(), SIPService.class));

// stop SIP Service
stopService(new Intent(getBaseContext(), SIPService.class));

// start a call
new SIPService().initiateCall(mActivity, "sip:name_to_call@domain");
```

### Helpers
```sh
File helpers
FileWBFile.getBmpUri(Context context, Bitmap inImage);
String WBFile.getRealPathFromURI(Activity activity, Uri uri);
File WBFile.bmpToFile(Activity activity, Bitmap bitmap);

Form helpers
Spinner WBForm.defaultSpinner(Context context, int spinnerArray, Spinner spinner, AdapterView.OnItemSelectedListener onItemSelectedListener);

HTTP helpers
void WBHttp.imgURLLoad(Context context, String source, CircleImageView imageView);

Security helpers
String WBSecurity.MD5(String toHash);
String WBSecurity.encodeBase64(String toConvert);
String WBSecurity.decodeBase64(String converted);

Encryption helpers
String JWT.generateToken();

Time helpers
long WBTime.unix();
long WBTime.unixTimeStamp();
long WBTime.addMinuteUnix(int minute);
Date WBTime.currentDate();
Date WBTime.addMinuteDate(int minute);
Date WBTime.minusMinuteDate(int minute);
String WBTime.getMonthForInt(int num);
```

# Other Resources
<p><a href="https://developers.google.com/api-client-library/java/google-api-java-client/oauth2">Using OAuth 2.0 with the Google API Client Library for Java</a></p>

# License
Android Clean Architecture Boilerplate is licensed under the Apache License (ASL) license. For more information, see the LICENSE file in this repository.
