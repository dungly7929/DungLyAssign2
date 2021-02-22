//Name: DUNG LY         ID:N01327929
package dung.ly.n01327929;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.zip.Inflater;

public class DungActivity extends AppCompatActivity {
    private String clicked = null,webview;
    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,LyActivity2.class);
        Button bntnext = (Button) findViewById(R.id.btnnext);
        ImageButton imgpiz = (ImageButton) findViewById(R.id.imgbtnpizapiza);
        ImageButton imghut = (ImageButton)  findViewById(R.id.imgbtnpizzahut);
        ImageButton imgDo =  (ImageButton) findViewById(R.id.imgbtndomi);
        ImageButton imgnova = (ImageButton)  findViewById(R.id.imgbtnpnova);
        imgpiz.setOnClickListener(new clickcase());
        imghut.setOnClickListener(new clickcase());
        imgDo.setOnClickListener(new clickcase());
        imgnova.setOnClickListener(new clickcase());

        //Check the click event for button next
        bntnext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                try
                {
                    if(clicked.equals("hut"))
                    {
                        intent.putExtra("Key_1",clicked);
                        intent.putExtra("Key_2",webview);
                        startActivity(intent);
                    }
                    else if(clicked.equals("pizapiza"))
                    {
                        intent.putExtra("Key_1",clicked);
                        intent.putExtra("Key_2",webview);
                        startActivity(intent);
                    }
                    else if(clicked.equals("domi"))
                    {
                        intent.putExtra("Key_1",clicked);
                        intent.putExtra("Key_2",webview);
                        startActivity(intent);
                    }
                    else if(clicked.equals("nova"))
                    {
                        intent.putExtra("Key_1",clicked);
                        intent.putExtra("Key_2",webview);
                        startActivity(intent);
                    }
                }
                catch (NullPointerException e)
                {
                    Toast.makeText(DungActivity.this, R.string.toastres,Toast.LENGTH_LONG).show();
                }


            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        this.menu = menu;
        return true;
    }

    //Function for Menuitem when selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent = null;
        switch (item.getItemId())
        {
            case R.id.dunglymenuhelp:
            intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.cbcurl)));
            startActivity(intent);
            return true;

            case R.id.dunglymenupiz:
            if (webview !=null)
            {
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(webview));
                startActivity(intent);
            }
            else
            {
                Toast toast = Toast.makeText(DungActivity.this, R.string.restaurantlink,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.LEFT | Gravity.TOP,20,30);
                toast.show();
            }
                return true;

            case R.id.dunglymenuname:
             Toast toast = Toast.makeText(DungActivity.this, R.string.dunglymenutoast,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.LEFT | Gravity.TOP,20,30);
                toast.show();
                return true;

            default:
                return  super.onOptionsItemSelected(item);
        }
    }
    //Switch case for each pizza order activity

    public class clickcase implements  View.OnClickListener
    {

        @Override
        public void onClick(View v) {


            switch (v.getId())
            {
                case R.id.imgbtnpizapiza:
                    menu.getItem(1).setIcon(R.drawable.pizzapizza);
                    webview = getString(R.string.pizzapizzalink);
                    clicked = "pizapiza";

                    break;
                case R.id.imgbtnpizzahut:
                    menu.getItem(1).setIcon(R.drawable.pizzahut);
                    webview = getString(R.string.pizzahutlink);
                    clicked = "hut";
                    break;
                case R.id.imgbtndomi:
                    menu.getItem(1).setIcon(R.drawable.dominopizza);
                    webview = getString(R.string.pizzadominolink);
                    clicked = "domi";
                    break;
                case R.id.imgbtnpnova:
                    clicked = "nova";
                    menu.getItem(1).setIcon(R.drawable.pizzanova);
                    webview = getString(R.string.pizzanovalink);
                    break;
                default:
                    clicked = "";
                    break;
            }
        }
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit the App ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}