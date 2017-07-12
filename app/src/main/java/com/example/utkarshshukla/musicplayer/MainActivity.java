package com.example.utkarshshukla.musicplayer;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ACTIVITY";

    private ArrayList< String > songs;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION

        };

        Cursor cursor = this.managedQuery (
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                null,
                null );

        songs = new ArrayList< String > ( );
        while ( cursor.moveToNext ( ) ) {
            songs.add ( cursor.getString ( 0 ) + "||" + cursor.getString ( 1 ) + "||" + cursor.getString ( 2 ) + "||" + cursor.getString ( 3 ) + "||" + cursor.getString ( 4 ) + "||" + cursor.getString ( 5 ) );
        }

        String filePath = Environment.getExternalStorageDirectory ( ) + "/Nusrat Fateh Ali Khan , Khokhar Productions/Mere Rashke Qamar - Remix - Nusrat Fateh 190Kbps.mp3";
        Log.e ( "fileapth", "onCreate: " + filePath );
//        Uri myUri = Uri.fromFile(new File ("/storage/emulated/0/Download/Mere Rashke Qamar - Remix - Nusrat Fateh 190Kbps.mp3"));
//        MediaPlayer mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        try {
//            mediaPlayer.setDataSource(getApplicationContext(), myUri);
//        } catch ( IOException e ) {
//            e.printStackTrace ( );
//        }
//        try {
//            mediaPlayer.prepare();
//        } catch ( IOException e ) {
//            e.printStackTrace ( );
//        }
//        mediaPlayer.start();


    }

    @Override
    protected void onResume ( ) {
        super.onResume ( );
        Log.e ( "ACTIVITY", "onResume: " );
        Intent intent = new Intent ( MainActivity.this, MyService.class );
        startService ( intent );
    }

    @Override
    protected void onStop ( ) {
        super.onStop ( );
        Log.e ( TAG, "onStop: " );
    }

    @Override
    protected void onPause ( ) {
        super.onPause ( );
        Log.e ( TAG, "onPause: " );
    }

    @Override
    protected void onStart ( ) {
        super.onStart ( );
        Log.e ( TAG, "onStart: " );
    }
}
