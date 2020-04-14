package com.example.omnicurisvideoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoplayer;
    Button button;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button)findViewById(R.id.button);
        frameLayout=(FrameLayout)findViewById(R.id.video_frame);
        MediaController mediaController = new MediaController(this);
        videoplayer=(VideoView)findViewById(R.id.video_view);
        videoplayer.setMediaController(mediaController);

        mediaController.setPrevNextListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Next", Toast.LENGTH_SHORT).show();//next button clicked
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Previous", Toast.LENGTH_SHORT).show();                //previous button clicked
            }
        });
        videoplayer.setMediaController(mediaController);

        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/videoplayer-e2171.appspot.com/o/videoplayback.mp4?alt=media&token=43440d17-ab65-4e04-b6fe-5923f8efde32");
        videoplayer.setVideoURI(uri);
        videoplayer.start();

        }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            frameLayout.getLayoutParams().width=ViewGroup.LayoutParams.MATCH_PARENT;
            frameLayout.getLayoutParams().height= ViewGroup.LayoutParams.MATCH_PARENT;
            button.setVisibility(View.INVISIBLE);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            ViewGroup.LayoutParams params =frameLayout.getLayoutParams();
            params.height=600;
            frameLayout.setLayoutParams(params);
            button.setVisibility(View.VISIBLE);}
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(videoplayer.isPlaying())
        {

        }


    }


}
