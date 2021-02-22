package dung.ly.n01327929;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LyActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    protected void  onStart()
    {
        super.onStart();
        Intent intent = getIntent();
        ImageView imgv = (ImageView) findViewById(R.id.imgvlogo);
        if(intent!=null)
        {
            String click = intent.getStringExtra("Key_1");
            if(click.equalsIgnoreCase("hut"))
            {
                imgv.setImageResource(R.drawable.pizzahut);
            }
            else if(click.equalsIgnoreCase("pizapiza"))
            {
                imgv.setImageResource(R.drawable.pizzapizza);
            }
            else if(click.equalsIgnoreCase("domi"))
            {
                imgv.setImageResource(R.drawable.dominopizza);
            }
            else if(click.equalsIgnoreCase("nova"))
            {
                imgv.setImageResource(R.drawable.pizzanova);
            }
        }
    }
}