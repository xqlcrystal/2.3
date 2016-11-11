package crystal.com.chronometer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Chronometer ch=(Chronometer)findViewById(R.id.test);
        Button start=(Button)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch.setBase(SystemClock.elapsedRealtime());
                ch.start();
            }
        });

        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(SystemClock.elapsedRealtime()-ch.getBase()>20*1000){
                    ch.stop();
                }
            }
        });
    }
}
