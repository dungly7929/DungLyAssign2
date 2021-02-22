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
                    Intent intent1 = new Intent(LyActivity3.this, LyActivity4.class);
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("Key_name",txtname);
                    bundle1.putString("Key_address",txtaddress);
                    bundle1.putString("Key_province",txtprovince);
                    intent1.putExtras(bundle1);
                    startActivity(intent1);
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

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return  true;
    }

    @Override
    protected void  onStart()
    {
        super.onStart();
        ImageView imgv = (ImageView) findViewById(R.id.imgvlogo);
        if(bundle != null)
        {
            bdpizsize = bundle.getString("Pizza_type","");
            bdpiztype = bundle.getString("Pizza_size","");
            webview = bundle.getString("Web_key","");
            click = bundle.getString("Click_key","");
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
            if(click.equalsIgnoreCase("hut"))
            {
                Toast.makeText(LyActivity3.this,click,Toast.LENGTH_SHORT).show();
            }
        }
    }

}