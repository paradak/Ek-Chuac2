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
    String eleccion;
    String eleccion2;


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

                setEleccion( parent.getItemAtPosition(position).toString());

                switch(getEleccion()) {
                    case "Euro":setOpcion(1);break;
                    case "Dolar Estadounidense":setOpcion(2);break;
                    case "Yen":setOpcion(3);break;
                    case "Libra Esterlina":setOpcion(4);break;
                    case "Peso":setOpcion(5);break;
                    case "Yuan":setOpcion(6);break;
                    case "Franco Suizo":setOpcion(7);break;
                    case "Dolar Canadiense":setOpcion(8);break;
                    case "Dolar Australiano":setOpcion(9);break;
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

                setEleccion2(parent.getItemAtPosition(position).toString());

                btn1exchange = (Button)findViewById(R.id.btnexchange);
                btn1exchange.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        nombre = (EditText) findViewById(R.id.editText);
                        respuesta2 = (TextView) findViewById(R.id.T4);
                        double valor = 0;
                        switch(getOpcion()){
                            //Euro
                            case 1:
                                    if (getEleccion2().equals("Euro")){
                                         valor = 1;
                                    }
                                    if (getEleccion2().equals("Dolar Estadounidense")){
                                         valor = 1.08905;
                                    }
                                    if (getEleccion2().equals("Yen")){
                                        valor = 129.741482;
                                    }
                                    if (getEleccion2().equals("Libra Esterlina")){
                                        valor = 0.732159064;
                                    }
                                    if (getEleccion2().equals("Peso")) {
                                        valor = 16.594289;
                                    }
                                    if (getEleccion2().equals("Yuan")){
                                        valor = 6.76285753;
                                    }
                                    if (getEleccion2().equals("Franco Suizo")){
                                        valor = 1.04792119;
                                    }
                                    if (getEleccion2().equals("Dolar Canadiense")) {
                                        valor = 1.37367385;
                                    }
                                    if (getEleccion2().equals("Dolar Australiano")) {
                                        valor = 1.40499013;
                                    }break;
                            //Dolar Estadounidense
                            case 2:
                                    if (getEleccion2().equals("Euro")){
                                        valor = 0.918231486;
                                    }
                                    if (getEleccion2().equals("Dolar Estadounidense")){
                                        valor = 1;
                                    }
                                    if (getEleccion2().equals("Yen")){
                                        valor = 119.128;
                                    }
                                    if (getEleccion2().equals("Libra Esterlina")){
                                        valor = 0.672291506;
                                    }
                                    if (getEleccion2().equals("Peso")) {
                                        valor = 15.2373987;
                                    }
                                    if (getEleccion2().equals("Yuan")){
                                        valor = 6.20986872;
                                    }
                                    if (getEleccion2().equals("Franco Suizo")){
                                        valor = 0.962234231;
                                    }
                                    if (getEleccion2().equals("Dolar Canadiense")) {
                                        valor = 1.26135058;
                                    }
                                    if (getEleccion2().equals("Dolar Australiano")) {
                                        valor = 1.29010618;
                                    }break;
                            //Yen
                            case 3:
                                    if (getEleccion2().equals("Euro")){
                                        valor = 0.00770763509;
                                    }
                                    if (getEleccion2().equals("Dolar Estadounidense")){
                                        valor = 0.008394;
                                    }
                                    if (getEleccion2().equals("Yen")){
                                        valor = 1;
                                    }
                                    if (getEleccion2().equals("Libra Esterlina")){
                                        valor = 0.0056432149;
                                    }
                                    if (getEleccion2().equals("Peso")) {
                                        valor = 0.127902724;
                                    }
                                    if (getEleccion2().equals("Yuan")){
                                        valor = 0.0521256381;
                                    }
                                    if (getEleccion2().equals("Franco Suizo")){
                                        valor = 0.0080767;
                                    }
                                    if (getEleccion2().equals("Dolar Canadiense")) {
                                        valor = 0.0105877768;
                                    }
                                    if (getEleccion2().equals("Dolar Australiano")) {
                                        valor = 0.0108291512;
                                    }break;
                            //Libra Esterlina
                            case 4:
                                    if (getEleccion2().equals("Euro")){
                                        valor = 1.36582342;
                                    }
                                    if (getEleccion2().equals("Dolar Estadounidense")){
                                        valor = 1.48745;
                                    }
                                    if (getEleccion2().equals("Yen")){
                                        valor = 177.203955;
                                    }
                                    if (getEleccion2().equals("Libra Esterlina")){
                                        valor = 1;
                                    }
                                    if (getEleccion2().equals("Peso")) {
                                        valor = 22.6648687;
                                    }
                                    if (getEleccion2().equals("Yuan")){
                                        valor = 9.23686923;
                                    }
                                    if (getEleccion2().equals("Franco Suizo")){
                                        valor = 1.43127531;
                                    }
                                    if (getEleccion2().equals("Dolar Canadiense")) {
                                        valor = 1.87619592;
                                    }
                                    if (getEleccion2().equals("Dolar Australiano")) {
                                        valor = 1.91896843;
                                    }break;
                            //Peso
                            case 5:
                                    if (getEleccion2().equals("Euro")){
                                        valor = 0.060261696;
                                    }
                                    if (getEleccion2().equals("Dolar Estadounidense")){
                                        valor = 0.065628;
                                    }
                                    if (getEleccion2().equals("Yen")){
                                        valor = 7.81844174;
                                    }
                                    if (getEleccion2().equals("Libra Esterlina")){
                                        valor = 0.0441211469;
                                    }
                                    if (getEleccion2().equals("Peso")) {
                                        valor = 1;
                                    }
                                    if (getEleccion2().equals("Yuan")){
                                        valor = 0.407541265;
                                    }
                                    if (getEleccion2().equals("Franco Suizo")){
                                        valor = 0.0631495081;
                                    }
                                    if (getEleccion2().equals("Dolar Canadiense")) {
                                        valor = 0.0827799158;
                                    }
                                    if (getEleccion2().equals("Dolar Australiano")) {
                                        valor = 0.0846670881;
                                    }break;
                            //Yuan
                            case 6:
                                    if (getEleccion2().equals("Euro")){
                                        valor = 0.147866489;
                                    }
                                    if (getEleccion2().equals("Dolar Estadounidense")){
                                        valor = 0.161034;
                                    }
                                    if (getEleccion2().equals("Yen")){
                                        valor = 19.1844174;
                                    }
                                    if (getEleccion2().equals("Libra Esterlina")){
                                        valor = 0.10826179;
                                    }
                                    if (getEleccion2().equals("Peso")) {
                                        valor = 2.45373926;
                                    }
                                    if (getEleccion2().equals("Yuan")){
                                        valor = 1;
                                    }
                                    if (getEleccion2().equals("Franco Suizo")){
                                        valor = 0.154952427;
                                    }
                                    if (getEleccion2().equals("Dolar Canadiense")) {
                                        valor = 0.203120329;
                                    }
                                    if (getEleccion2().equals("Dolar Australiano")) {
                                        valor = 0.207750958;
                                    }break;
                            //Franco Suizo
                            case 7:
                                    if (getEleccion2().equals("Euro")){
                                        valor = 0.954270236;
                                    }
                                    if (getEleccion2().equals("Dolar Estadounidense")){
                                        valor = 1.039248;
                                    }
                                    if (getEleccion2().equals("Yen")){
                                        valor = 123.808435;
                                    }
                                    if (getEleccion2().equals("Libra Esterlina")){
                                        valor = 0.698677603;
                                    }
                                    if (getEleccion2().equals("Peso")) {
                                        valor = 15.8354361;
                                    }
                                    if (getEleccion2().equals("Yuan")){
                                        valor = 6.45359365;
                                    }
                                    if (getEleccion2().equals("Franco Suizo")){
                                        valor = 1;
                                    }
                                    if (getEleccion2().equals("Dolar Canadiense")) {
                                        valor = 1.31085607;
                                    }
                                    if (getEleccion2().equals("Dolar Australiano")) {
                                        valor = 1.34074026;
                                    }break;
                            //Dolar Canadiense
                            case 8:
                                    if (getEleccion2().equals("Euro")){
                                        valor = 0.72797484;
                                    }
                                    if (getEleccion2().equals("Dolar Estadounidense")){
                                        valor = 0.792801;
                                    }
                                    if (getEleccion2().equals("Yen")){
                                        valor = 94.4485347;
                                    }
                                    if (getEleccion2().equals("Libra Esterlina")){
                                        valor = 0.532993378;
                                    }
                                    if (getEleccion2().equals("Peso")) {
                                        valor = 12.0802249;
                                    }
                                    if (getEleccion2().equals("Yuan")){
                                        valor = 4.92319013;
                                    }
                                    if (getEleccion2().equals("Franco Suizo")){
                                        valor = 0.76286026;
                                    }
                                    if (getEleccion2().equals("Dolar Canadiense")) {
                                        valor = 1;
                                    }
                                    if (getEleccion2().equals("Dolar Australiano")) {
                                        valor = 1.02279747;
                                    }break;
                            //Dolar Australiano
                            case 9:
                                    if (getEleccion2().equals("Euro")){
                                        valor = 0.711748772;
                                    }
                                    if (getEleccion2().equals("Dolar Estadounidense")){
                                        valor = 0.77513;
                                    }
                                    if (getEleccion2().equals("Yen")){
                                        valor = 92.3433405;
                                    }
                                    if (getEleccion2().equals("Libra Esterlina")){
                                        valor = 0.745856619;
                                    }
                                    if (getEleccion2().equals("Peso")) {
                                        valor = 11.8109648;
                                    }
                                    if (getEleccion2().equals("Yuan")){
                                        valor = 4.81345554;
                                    }
                                    if (getEleccion2().equals("Franco Suizo")){
                                        valor = 0.745856619;
                                    }
                                    if (getEleccion2().equals("Dolar Canadiense")) {
                                        valor = 0.977710674 ;
                                    }
                                    if (getEleccion2().equals("Dolar Australiano")) {
                                        valor = 1;
                                    }break;

                        }



                        double myNum = 0;

                        try {

                            myNum = Double.parseDouble(nombre.getText().toString());
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


    public void setEleccion(String x){
        eleccion=x;
    }

    public String getEleccion (){
        return eleccion;
    }

    public void setEleccion2 (String x){
        eleccion2=x;
    }

    public String getEleccion2 (){
        return eleccion2;
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
