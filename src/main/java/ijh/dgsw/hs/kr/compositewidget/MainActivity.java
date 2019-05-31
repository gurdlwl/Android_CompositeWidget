package ijh.dgsw.hs.kr.compositewidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import ijh.dgsw.hs.kr.compositewidget.widget.RadioBox;

public class MainActivity extends AppCompatActivity {

    private RadioBox radioBoxGender;
    private RadioBox radioBoxAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioBoxGender = findViewById(R.id.radioBoxGender);
        radioBoxAge = findViewById(R.id.radioBoxAge);
    }

    public void getValue(View v){
        String str = "gender = " + radioBoxGender.getValue();
        str += ", age = " + radioBoxAge.getValue();

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
