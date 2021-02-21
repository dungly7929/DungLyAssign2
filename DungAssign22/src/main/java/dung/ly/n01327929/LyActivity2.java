package dung.ly.n01327929;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

public class LyActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly2);
        String click= "";
        Bundle extras = this.getIntent().getExtras();
        if(extras!=null)
        {
            click = extras.getString("Clicked","");
        }
        if(click.equalsIgnoreCase("hut"))
        {
            ImageView img = (ImageView) findViewById(R.id.imgvlogo);
            img.setImageResource(R.drawable.pizzahut);
        }
    }
    @Override
    protected void  onStart()
    {
        super.onStart();
    }
}