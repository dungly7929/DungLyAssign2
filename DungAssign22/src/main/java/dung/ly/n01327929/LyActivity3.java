package dung.ly.n01327929;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LyActivity3 extends AppCompatActivity {
    Intent intent;
    Bundle bundle;
    EditText edittextname,edittextaddress,edittextcard,edittextdate,editextcvv;
    Button bntorder;
    ArrayList<String> list,spinnerlist = new ArrayList<String>();
    String bdpizsize, bdpiztype, cb = "",txtname,txtaddress,txtcard,txtcvv,txtdate,txtprovince,click;
    private String webview = "";
    String [] provincelist = {"Nunavut", "British Columbia","Alberta","Saskatchewan","Manitoba","Ontario",
            "Quebec","Newfoundland and Labrador","Nova Scotia","Prince Edward Island"};
    TextView txtvsize,txttype,txtvtopping;
    Spinner spinnerprovince;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getid();
        spinnerprocreate();
        intent = getIntent();
        bundle = intent.getExtras();
        ImageView imgv = (ImageView) findViewById(R.id.imgvlogo);

        orderplace();


    }

    private  void orderplace()
    {
        bntorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                txtname = edittextname.getText().toString();
                txtaddress = edittextaddress.getText().toString();
                txtcard = edittextcard.getText().toString();
                txtdate = edittextdate.getText().toString();
                txtcvv = editextcvv.getText().toString();
                if(txtname.equals("") || txtaddress.equals("") || txtcard.equals("") || txtdate.equals("") || txtcvv.equals(""))
                {
                    if(txtname.equals(""))
                    {
                        edittextname.setError("This field can't empty !");
                    }
                    if (txtaddress.equals(""))
                    {
                        edittextaddress.setError("This field can't empty !");
                    }

                    if(txtcard.equals(""))
                    {
                        edittextcard.setError("This field can't empty !");
                    }

                    if (txtdate.equals(""))
                    {
                        edittextdate.setError("This field can't empty !");
                    }
                    if (txtcvv.equals(""))
                    {
                        editextcvv.setError("This field can't empty !");
                    }
                }
                else if(txtname.length() <3 || txtcard.length() <16 )
                {
                    if(txtname.length() <3 )
                    {
                        edittextname.setError("Name must at least 3 letters !");
                    }
                    if(txtcard.length() <16)
                    {
                        edittextcard.setError("Credit card number need 16 digits !");
                    }
                }
                else
                {
                    Intent intent2 = new Intent(LyActivity3.this, LyActivity4.class);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("Key_name",txtname);
                    bundle2.putString("Key_address",txtaddress);
                    bundle2.putString("Key_province",txtprovince);
                    bundle2.putString("Key_card",txtcard);
                    bundle2.putString("Key_date",txtdate);
                    bundle2.putString("Key_cvv",txtcvv);
                    bundle2.putString("Key_web",webview);
                    bundle2.putString("Key_psize",bdpizsize);
                    bundle2.putString("Key_ptype",bdpiztype);
                    bundle2.putString("Key_pcb",cb);
                    intent2.putExtras(bundle2);
                    startActivity(intent2);
                }

            }
        });
    }

    private void spinnerprocreate()
    {
        for(int i =0; i< provincelist.length;i++)
        {
            spinnerlist.add(provincelist[i]);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerlist);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerprovince.setAdapter(arrayAdapter);
        spinnerprovince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    txtprovince = spinnerlist.get(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }

    private void getid()
    {
        txtvsize = findViewById(R.id.textviewpizzasize);
        txttype = findViewById(R.id.textviewpizzatype);
        txtvtopping = findViewById(R.id.textviewtopping);
        spinnerprovince = (Spinner) findViewById(R.id.provincespinner);
        edittextname = (EditText) findViewById(R.id.edittextfullname);
        edittextaddress = (EditText) findViewById(R.id.edittextaddress);
        edittextcard = (EditText) findViewById(R.id.edittextpayment);
        edittextdate = (EditText) findViewById(R.id.edittextdate);
        editextcvv = (EditText) findViewById(R.id.edittextcvv);
        bntorder = (Button) findViewById(R.id.btnorder);

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
        intent = null;
        switch (item.getItemId())
        {
            case android.R.id.home:
                intent = new Intent(LyActivity3.this,DungActivity.class);
                startActivity(intent);
                return true;

            case R.id.dunglymenuhelp:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.cbcurl)));
                startActivity(intent);
                return true;

            case R.id.dunglymenupiz:
                intent =  new Intent(Intent.ACTION_VIEW, Uri.parse(webview));
                startActivity(intent);

                return true;

            case R.id.dunglymenuname:
                Toast toast = Toast.makeText(LyActivity3.this, R.string.dunglymenutoast,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.LEFT | Gravity.TOP,20,30);
                toast.show();
                return true;

            default:
                return  super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void  onStart()
    {
        super.onStart();
        if(bundle != null)
        {
            bdpizsize = bundle.getString("Pizza_type","");
            bdpiztype = bundle.getString("Pizza_size","");
            webview = bundle.getString("Web_key","");
            list = bundle.getStringArrayList("Pizza_topping");
            for(int i = 0 ; i <list.size() ; i++)
            {
                if(i == (list.size() - 1))
                {
                    cb += list.get(i)+ ".";
                }
                else
                {
                    cb += list.get(i) + ",";
                }

            }

            txtvsize.setText("Pizza Size: " + bdpizsize);
            txttype.setText("Pizza type: " + bdpiztype);
            txtvtopping.setText("Pizza Topping: " + cb);
        }
    }

}