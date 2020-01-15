package com.example.usuario.acelerometro;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
public class Acelerometro extends Activity implements SensorEventListener{
    int contador=0;
    double x=0,y=0,z=0,a=0,amax=0;
    double gravedad=SensorManager.STANDARD_GRAVITY;
    TextView tvax,tvay,tvaz,tvaftvaMax,tvG;
/** Called when the activity is first created. */
@Override
    public void onCreate(Bundle savedlnstanceState) {
        super.onCreate(savedlnstanceState);
        setContentView(R.layout.main);
        tvax=(TextView) findViewById(R.id.textViewAX);
        tvay=(Textview) findViewByld(R.id.textViewAY);
        tvaz=(Textview) findViewByld(R.id.textViewAZ);
        tva=(Textview) findViewByld(R.id.textViewA);
        tvaMax=(Textview) findViewByld(R.id.textViewAmax);
        tvG=(Textview) findViewByld(R.id.textViewG);
// inicia un SensorManager
        SensorManager sensorManager=(SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
// define un sensor acelerómetro
        Sensor acelerometro=sensorManager.getDefaultSensor(
                Sensor.TYPE_ACCELEROMETER);
// registra el sensor para que comience a escuchar
        SensorManager.registerListener(
                this,
                acelerometro,
                SensorManager.SENSOR_DELAY_FASTEST);
        new MiAsyncTask().execute();
    }
    @Override
    public void onAccuracyChanged(Sensor argO, int argl) {
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
// componentes de la aceleración
        x= event.valúes[0]/
                y= event.valúes[1];
        z= event.valúes [2]/
// modulo de la aceleración
                a=Math.sqrt(x*x+y*y+z*z);
// aceleración máxima
        if(a>amax)amax=a;
    }
    class MiAsyncTao1: .CLends AsyncTask<Void, Void, Void> {
        @Override
        protected Void dolnBackground(Void... argO) {
            while(true){
                try {
                    Thread.sleep(lOO);
                } catch (InterruptedException e) {
                    e .printStackTrace();
                }
                contador++;
                publishProgress () ;
            }
        }
        @Override
        protected void onProgressüpdate(Void... progress){
            tvax.setText(”"+ x ) ;
                    tvay.setText(" "+ y);
            tvaz . setText ( ",f+ z ) ;
                    tva.setText(”"+a);
                            tvaMax.setText(""+amax);
            tvG .setText ( " f, + gravedad) ;
                    tvG.append("\n"+contador);
        }
    }
}