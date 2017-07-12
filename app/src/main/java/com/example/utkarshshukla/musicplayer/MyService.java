package com.example.utkarshshukla.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;

public class MyService extends Service {
    private String TAG = "SERVICE";

    public MyService ( ) {
        Log.e ( TAG, "MyService: "  );
    }

    @Override
    public void onCreate ( ) {
        super.onCreate ( );
        Log.e ( TAG, "onCreate: "  );
    }

    @Override
    public int onStartCommand ( Intent intent, int flags, int startId ) {
        Log.e ( TAG, "onStartCommand: "  );
        return super.onStartCommand ( intent, flags, startId );
    }

    @Override
    public void onDestroy ( ) {
        Log.e ( TAG, "onDestroy: "  );
        super.onDestroy ( );
    }

    @Override
    public void onConfigurationChanged ( Configuration newConfig ) {
        Log.e ( TAG, "onConfigurationChanged: "  );
        super.onConfigurationChanged ( newConfig );
    }

    @Override
    public void onLowMemory ( ) {
        Log.e ( TAG, "onLowMemory: "  );
        super.onLowMemory ( );
    }

    @Override
    public void onTrimMemory ( int level ) {
        Log.e ( TAG, "onTrimMemory: "  );
        super.onTrimMemory ( level );
    }

    @Override
    public boolean onUnbind ( Intent intent ) {
        Log.e ( TAG, "onUnbind: "  );
        return super.onUnbind ( intent );
    }

    @Override
    public void onRebind ( Intent intent ) {
        Log.e ( TAG, "onRebind: "  );
        super.onRebind ( intent );
    }

    @Override
    public void onTaskRemoved ( Intent rootIntent ) {
        Log.e ( TAG, "onTaskRemoved: "  );
        super.onTaskRemoved ( rootIntent );
    }

    @Override
    protected void dump ( FileDescriptor fd, PrintWriter writer, String[] args ) {
        Log.e ( TAG, "dump: "  );
        super.dump ( fd, writer, args );
    }

    @Override
    public IBinder onBind ( Intent intent ) {
        // TODO: Return the communication channel to the service.

        throw new UnsupportedOperationException ( "Not yet implemented" );

    }

    @Override
    public void onStart ( Intent intent, int startId ) {
        super.onStart ( intent, startId );
        Log.e ( "ERVICE", "onStart: WORKING-------------"  );
//        String url = "http://raag.me//music/data/Single%20Hindi/Mere%20Rashke%20Qamar-(Arijit%20Singh)/Mere%20Rashke%20Qamar[320]::Raag.Me::.mp3"; // your URL here
//        MediaPlayer mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType( AudioManager.STREAM_MUSIC);
//        try {
//            mediaPlayer.setDataSource(url);
//        } catch ( IOException e ) {
//            e.printStackTrace ( );
//        }
//        try {
//            mediaPlayer.prepare(); // might take long! (for buffering, etc)
//        } catch ( IOException e ) {
//            e.printStackTrace ( );
//        }
//        mediaPlayer.start();
        Uri myUri = Uri.fromFile(new File ("/storage/emulated/0/Download/Mere Rashke Qamar - Remix - Nusrat Fateh 190Kbps.mp3"));
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType( AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(getApplicationContext(), myUri);
        } catch ( IOException e ) {
            e.printStackTrace ( );
        }
        try {
            mediaPlayer.prepare();
        } catch ( IOException e ) {
            e.printStackTrace ( );
        }
        mediaPlayer.start();
    }
}
