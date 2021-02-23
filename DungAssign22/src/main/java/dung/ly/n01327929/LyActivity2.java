package dung.ly.n01327929;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;

public class LyActivity2 extends AppCompatActivity
{
    Button bntnext;
    ArrayList<String> list = new ArrayList<String>();
    private int checkbox = 0;
    String rbtntypetext,rbtnsizetext;
    RadioButton rbtnsizesm, rbtnsizemed,rbtnsizelarge, rbtntypeny, rbtntypesf;
    CheckBox cbbacon,cbsausage,cbcheese,cbbellpp,cbpineapple;
    RadioGroup radioGroupsize,radioGrouptype;
    private String webview= "";
    private String click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly2);
        Intent intent = new Intent(LyActivity2.this, LyActivity3.class);
        Bundle bundle = new Bundle();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bntnext = findViewById(R.id.btnnext2);
        radioGroupsize = (RadioGroup) findViewById(R.id.pizzasizegroup);
        radioGrouptype = (RadioGroup) findViewById(R.id.pizzatypegroup);
        addid();

        //radiogroup for type
        radioGroupsize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.radiobtnsmall:
                        rbtnsizetext = rbtnsizesm.getText().toString();
                        break;

                    case R.id.radiobtnmed:
                        rbtnsizetext = rbtnsizemed.getText().toString();
                        break;

                    case R.id.radiobtnlarge:
                        rbtnsizetext = rbtnsizelarge.getText().toString();
                        break;

                }

            }
        });

        radioGrouptype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.radiobtnnewyork:
                        rbtntypetext = rbtntypeny.getText().toString();
                        break;

                    case R.id.radiobtnseafood:
                        rbtntypetext = rbtntypesf.getText().toString();
                        break;

                }
            }
        });

        cbbacon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    list.add(cbbacon.getText().toString());
                    checkbox++;
                }
                else
                {
                    list.remove(String.valueOf(cbbacon.getText()));;
                    checkbox--;
                }
            }
        });

        cbsausage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    list.add(cbsausage.getText().toString());;
                    checkbox++;
                }
                else
                {
                    list.remove(String.valueOf(cbsausage.getText()));;
                    checkbox--;
                }
            }
        });

        cbcheese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    list.add(cbcheese.getText().toString());;
                    checkbox++;
                }
                else
                {
                    list.remove(String.valueOf(cbcheese.getText()));;
                    checkbox--;
                }
            }
        });

        cbbellpp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    list.add(cbbellpp.getText().toString());;
                    checkbox++;
                }
                else
                {
                    list.remove(String.valueOf(cbbellpp.getText()));;
                    checkbox--;
                }
            }
        });

        cbpineapple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    list.add(cbpineapple.getText().toString());;
                    checkbox++;
                }
                else
                {
                    list.remove(String.valueOf(cbpineapple.getText()));;
                    checkbox--;
                }
            }
        });

        //Function for Button
        bntnext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
              if(radioGroupsize.getCheckedRadioButtonId() == -1 && radioGrouptype.getCheckedRadioButtonId() == -1 && checkbox == 0 )
              {
                  Toast.makeText(LyActivity2.this,"Please choose the pizza options",Toast.LENGTH_LONG).show();
              }
              else if(radioGroupsize.getCheckedRadioButtonId() == -1)
              {
                  Toast.makeText(LyActivity2.this,"Please choose the pizza size !",Toast.LENGTH_LONG).show();
              }
              else if(radioGrouptype.getCheckedRadioButtonId() == -1)
              {
                  Toast.makeText(LyActivity2.this,"Please choose the pizza type !",Toast.LENGTH_LONG).show();
              }
              else if (checkbox == 0)
              {
                  Toast.makeText(LyActivity2.this,"Please choose at least one topping !",Toast.LENGTH_LONG).show();
              }

              else
              {
                bundle.putString("Pizza_type",rbtntypetext);
                bundle.putString("Pizza_size",rbtnsizetext);
                bundle.putString("Web_key",webview);
                bundle.putStringArrayList("Pizza_topping",list);
                intent.putExtras(bundle);
                startActivity(intent);

              }
            }
        });


    }

    private void addid()
    {
        cbbacon = (CheckBox) findViewById(R.id.checkbbacon);
        cbsausage = (CheckBox) findViewById(R.id.checkbsausage);
        cbcheese = (CheckBox) findViewById(R.id.checkbcheese);
        cbbellpp = (CheckBox) findViewById(R.id.checkbbellpp);
        cbpineapple = (CheckBox) findViewById(R.id.checkbpineapple);
        rbtnsizesm = (RadioButton) findViewById(R.id.radiobtnsmall);
        rbtnsizemed = (RadioButton) findViewById(R.id.radiobtnmed);
        rbtnsizelarge = (RadioButton) findViewById(R.id.radiobtnlarge);
        rbtntypeny = (RadioButton) findViewById(R.id.radiobtnnewyork);
        rbtntypesf = (RadioButton) findViewById(R.id.radiobtnseafood);
        cbbacon = (CheckBox) findViewById(R.id.checkbbacon);
        cbsausage = (CheckBox) findViewById(R.id.checkbsausage);
        cbcheese = (CheckBox) findViewById(R.id.checkbcheese);
        cbbellpp = (CheckBox) findViewById(R.id.checkbbellpp);
        cbpineapple = (CheckBox) findViewById(R.id.checkbpineapple);
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
        Intent intent = null;
        switch (item.getItemId())
        {
            case android.R.id.home:
                intent = new Intent(LyActivity2.this,DungActivity.class);
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
                Toast toast = Toast.makeText(LyActivity2.this, R.string.dunglymenutoast,Toast.LENGTH_LONG);
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
        Intent intent = getIntent();
        ImageView imgv = (ImageView) findViewById(R.id.imgvlogo);
        if(intent!=null)
        {
            click = intent.getStringExtra("Key_1");
            webview = intent.getStringExtra("Key_2");
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