package com.example.raul__000.myfirstapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends ActionBarActivity implements View.OnClickListener{

    final Context context = this;
    private Button btn1;
    private Button btn1exchange;
    private Button btn2;
    private TextView respuesta;
    private TextView respuesta2;
    private EditText nombre;
    int opcion=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ////////////
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.versiones, android.R.layout.simple_spinner_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(final AdapterView<?> parent, View view, final int position, long id) {
                Toast.makeText(parent.getContext(),"Has Seleccionado"+ parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();

                String eleccion= parent.getItemAtPosition(position).toString();

                switch(eleccion) {
                    case "Euro":setOpcion(1);break;
                    case "Dolar":setOpcion(2);break;
                    case "Yen":setOpcion(3);break;
                    case "Libra esterlina":setOpcion(4);break;
                    case "Florines":setOpcion(5);break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /////////////

        Spinner sp2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(
                this, R.array.versiones, android.R.layout.simple_spinner_item);
        sp2.setAdapter(adapter2);

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(final AdapterView<?> parent, View view, final int position, long id) {
                Toast.makeText(parent.getContext(), "Has Seleccionado" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();

                final String eleccion2= parent.getItemAtPosition(position).toString();

                btn1exchange = (Button)findViewById(R.id.btnexchange);
                btn1exchange.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        nombre = (EditText) findViewById(R.id.editText);
                        respuesta2 = (TextView) findViewById(R.id.T4);
                        double valor = 0;

                        /*
                        case "Euro":setOpcion(1);break;
                        case "Dolar":setOpcion(2);break;
                        case "Yen":setOpcion(3);break;
                        case "Libra esterlina":setOpcion(4);break;
                        case "Florines":setOpcion(5);break;
                        */


                        switch(getOpcion()){
                            //Euro
                            case 1: if (eleccion2.equals("Euro")){
                                         valor = 1;
                                    }
                                    if (eleccion2.equals("Dolar")){
                                         valor = 1.08905;
                                    }
                                    if (eleccion2.equals("Yen")){
                                        valor = 129.741482;
                                    }
                                    if (eleccion2.equals("Libra esterlina")){
                                        valor = 0.73220;
                                    }
                                    if (eleccion2.equals("Florines")) {
                                        valor = 300.540;
                                    }

                        }



                        int myNum = 0;

                        try {
                            myNum = Integer.parseInt(nombre.getText().toString());

                            double operacion = myNum*valor;
                            String resultado = Double.toString(operacion);
                            respuesta2.setText(resultado);
                        }
                        catch(NumberFormatException nfe)
                        {
                            System.out.println("Could not parse " + nfe);
                        }
                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn1 = (Button)findViewById(R.id.btn01);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyActivity.this, Activity2.class);
                startActivity(i);
            }
        });

        btn2 = (Button)findViewById(R.id.btn02);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void setOpcion (int x){
        opcion=x;
    }

    public int getOpcion (){
       return opcion;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*
        if (id == R.id.action_settings) {
            return true;
        }*/

        switch (id){
            case R.id.action_about:
                showAlert();

                return true;

            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void showAlert(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle("About");

        // set dialog message
        alertDialogBuilder
                .setMessage("Informacion de la actividad principal")
                .setCancelable(false)
                .setNegativeButton("Ok",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

    @Override
    public void onClick(View v) {

    }
}
