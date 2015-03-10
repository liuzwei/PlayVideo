package com.example.PlayVideo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.PlayVideo.view.MovieRecorderView;

public class MainActivity extends Activity implements MovieRecorderView.OnRecordFinishListener , View.OnClickListener{
    private MovieRecorderView recorderView;
    private Button button;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        recorderView = (MovieRecorderView) this.findViewById(R.id.movie_recorder);
        button = (Button) this.findViewById(R.id.play_btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onRecordFinish() {
        recorderView.stop();
        System.out.print("录制完毕");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play_btn:
                recorderView.record(this);
                break;
        }
    }
}
