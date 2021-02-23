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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class LyActivity4 extends AppCompatActivity {
    Intent intent;
    Bundle bundle;
    TextView textviewname,textviewaddress,textviewprovince,textviewcard,textviewdate,textviewccv,textviewptype,textviewsize,textviewtopping;
    String txtname,txtaddress,txtprovince,txtcard,txtdate,txtcvv,ptype,psize,pcb;
    String webview = "";
    Button btncheckout;
    final String confirmnumber = "PIZA0123456789";
    final Date date = Calendar.getInstance().getTime();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getid();

        btncheckout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder dialogb = new AlertDialog.Builder(LyActivity4.this);
                dialogb.setTitle("Order Confirmed !");
                dialogb.setMessage("Your order number is : " + confirmnumber + "\n Time to Pickup: "+ date);
                dialogb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Intent intent = new Intent(LyActivity4.this,DungActivity.class);
                        startActivity(intent);
                    }
                });
                dialogb.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = dialogb.create();
                dialog.show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        if(webview.equals(getString(R.string.pizzapizzalink)))
        {
            menu.getItem(1).setIcon(R.drawable.pizzapizza);
        }
        if(webview.equals(getString(R.string.pizzahutlink)))
        {
            menu.getItem(1).setIcon(R.drawable.pizzahut);
        }
        if(webview.equals(getString(R.string.pizzadominolink)))
        {
            menu.getItem(1).setIcon(R.drawable.dominopizza);
        }
        if(webview.equals(getString(R.string.pizzanovalink)))
        {
            menu.getItem(1).setIcon(R.drawable.pizzanova);
        }
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent2 = null;
        switch (item.getItemId())
        {
            case android.R.id.home:
                intent2 = new Intent(LyActivity4.this,DungActivity.class);
                startActivity(intent2);
                return true;

            case R.id.dunglymenuhelp:
                intent2 =  new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.cbcurl)));
                startActivity(intent2);
                return true;

            case R.id.dunglymenupiz:
                intent2 =  new Intent(Intent.ACTION_VIEW, Uri.parse(webview));
                startActivity(intent2);

                return true;

            case R.id.dunglymenuname:
                Toast toast = Toast.makeText(LyActivity4.this, R.string.dunglymenutoast,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.LEFT | Gravity.TOP,20,30);
                toast.show();
                return true;

            default:
                return  super.onOptionsItemSelected(item);
        }
    }
    private void getid()
    {
        textviewname = (TextView) findViewById(R.id.txtvfullname);
        textviewaddress = (TextView) findViewById(R.id.txtvaddress);
        textviewprovince = (TextView) findViewById(R.id.txtvprovince);
        textviewcard = (TextView) findViewById(R.id.txtvcard2);
        textviewdate = (TextView) findViewById(R.id.txtvdate);
        textviewccv = (TextView) findViewById(R.id.txtvccv);
        textviewptype = (TextView) findViewById(R.id.txtvptype);
        textviewsize = (TextView) findViewById(R.id.txtvpsize);
        textviewtopping = (TextView) findViewById(R.id.txtvtopping);
        btncheckout = (Button) findViewById(R.id.btncheckout);
    }

    private void setup()
    {
        textviewname.setText("Full Name:" + txtname);
        textviewaddress.setText("Address: "+ txtaddress);
        textviewprovince.setText("Province: " +txtprovince);
        textviewcard.setText("Card Number: " +txtcard);
        textviewdate.setText("Date: " +txtdate);
        textviewccv.setText("CCV: " +txtcvv);
        textviewptype.setText("Pizza Type: " +ptype);
        textviewsize.setText("Pizza Size: " +psize);
        textviewtopping.setText("Pizza Topping: " +pcb);
    }

    @Override
    protected void  onStart()
    {
        intent = getIntent();
        bundle = intent.getExtras();
        super.onStart();
        if(bundle != null)
        {
            txtname = bundle.getString("Key_name","");
            txtaddress = bundle.getString("Key_address","");
            txtprovince = bundle.getString("Key_province","");
            txtcard = bundle.getString("Key_card","");
            txtdate = bundle.getString("Key_date","");
            txtcvv = bundle.getString("Key_cvv","");
            psize = bundle.getString("Key_psize","");
            ptype = bundle.getString("Key_ptype","");
            pcb = bundle.getString("Key_pcb","");
            webview = bundle.getString("Key_web","");
            textviewname.setText("Full Name:" + txtname);
            textviewaddress.setText("Address: "+ txtaddress);
            textviewprovince.setText("Province: " +txtprovince);
            textviewcard.setText("Card Number: " +txtcard);
            textviewdate.setText("Date: " +txtdate);
            textviewccv.setText("CCV: " +txtcvv);
            textviewptype.setText("Pizza Type: " +ptype);
            textviewsize.setText("Pizza Size: " +psize);
            textviewtopping.setText("Pizza Topping: " +pcb);
            setup();
        }

    }

}