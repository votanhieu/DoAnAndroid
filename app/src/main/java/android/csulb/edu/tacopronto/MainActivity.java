package android.csulb.edu.tacopronto;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.view.View.OnClickListener;
import android.telephony.SmsManager;
import android.widget.Toast;
import android.content.Intent;

import java.lang.reflect.Array;

public class MainActivity extends Activity {

    CheckBox beefChk,chickenChk,wfChk,riceChk,cheeseChk,seafoodChk,beansChk,picoChk,guacamoleChk,lbtChk,sodaChk,margaritaChk,cervezaChk,tequillaChk;
    RadioButton largeRadio,mediumRadio,cornRadio,flourRadio;
    Button placeOrder;
    Integer beefprice = 2000,chickenprice = 2000, wfprice = 2000, riceprice = 2000,cheeseprice = 2000,seafoodprice = 2000,beansprice = 2000, picoprice =2000,
            guacamoleprice = 2000, lbtprice = 2000, sodaprice = 1000,margaritaprice = 1000,cervezaprice = 1000, tequillaprice = 1000, largeprice = 3000,
            mediumprice = 2000,cornprice = 3000,flourprice = 2000, total = 0;
    SmsManager sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListeners();
    }

    public void addListeners(){

        beefChk = (CheckBox) findViewById(R.id.beef);
        chickenChk = (CheckBox) findViewById(R.id.chicken);
        wfChk = (CheckBox) findViewById(R.id.whiteFish);
        riceChk = (CheckBox) findViewById(R.id.rice);
        cheeseChk = (CheckBox) findViewById(R.id.cheese);
        seafoodChk = (CheckBox) findViewById(R.id.seafood);
        beansChk = (CheckBox) findViewById(R.id.beans);
        picoChk = (CheckBox) findViewById(R.id.pico);
        guacamoleChk = (CheckBox) findViewById(R.id.guacamole);
        lbtChk = (CheckBox) findViewById(R.id.lbt);
        sodaChk = (CheckBox) findViewById(R.id.soda);
        margaritaChk = (CheckBox) findViewById(R.id.margarita);
        cervezaChk = (CheckBox) findViewById(R.id.cerveza);
        tequillaChk = (CheckBox) findViewById(R.id.tequilla);
        largeRadio = (RadioButton) findViewById(R.id.radioLarge);
        mediumRadio = (RadioButton) findViewById(R.id.radioMedium);
        cornRadio = (RadioButton) findViewById(R.id.radioCorn);
        flourRadio = (RadioButton) findViewById(R.id.radioFlour);
        placeOrder = (Button) findViewById(R.id.order);
        final String msg = "android.telephony.SmsManager.STATUS_ON_ICC_SENT";

        placeOrder.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder summary = new StringBuilder();
                summary.append("Your order");

                if(largeRadio.isChecked()){
                    total = total + largeprice;
                    summary.append("\nLarge Taco: 3000 VND ");
                }
                if(mediumRadio.isChecked()){
                    total = total + mediumprice;
                    summary.append("\nMedium Taco: 2000 VND ");
                }
                if(cornRadio.isChecked()){
                    total = total + cornprice;
                    summary.append("\nCorn Tortilla: 3000 VND ");
                }
                if(flourRadio.isChecked()){
                    total = total + flourprice;
                    summary.append("\nFlour Tortilla: 2000 VND ");
                }
                summary.append("\nFillings");
                if(beefChk.isChecked()){
                    total = total + beefprice;
                    summary.append("\nBeef: 2000 VND ");
                }
                if(riceChk.isChecked()){
                    total = total + riceprice;
                    summary.append("\nRice: 2000 VND ");
                }
                if(chickenChk.isChecked()){
                    total = total + chickenprice;
                    summary.append("\nChicken: 2000 VND ");
                }
                if(wfChk.isChecked()){
                    total = total + wfprice;
                    summary.append("\nWhite Fish: 2000 VND ");
                }
                if(cheeseChk.isChecked()){
                    total = total + cheeseprice;
                    summary.append("\nCheese: 2000 VND ");
                }
                if(seafoodChk.isChecked()){
                    total = total + seafoodprice;
                    summary.append("\nSea Food: 2000 VND ");
                }
                if(beansChk.isChecked()){
                    total = total + beansprice;
                    summary.append("\nBeans: 2000 VND ");
                }
                if(picoChk.isChecked()){
                    total = total + picoprice;
                    summary.append("\nPico de Gallo: 2000 VND ");
                }
                if(guacamoleChk.isChecked()){
                    total = total + guacamoleprice;
                    summary.append("\nGuacamole: 2000 VND ");
                }
                if(lbtChk.isChecked()){
                    total = total + lbtprice;
                    summary.append("\nLBT: 2000 VND ");
                }
                summary.append("\nBeverage");
                if(sodaChk.isChecked()){
                    total = total + sodaprice;
                    summary.append("\nSoda : 10000 VND ");
                }
                if(margaritaChk.isChecked()){
                    total = total + margaritaprice;
                    summary.append("\nMargarita : 10000 VND ");
                }
                if(cervezaChk.isChecked()){
                    total = total + cervezaprice;
                    summary.append("\nCerveza : 10000 VND ");
                }
                if(tequillaChk.isChecked()){
                    total = total + tequillaprice;
                    summary.append("\nTequilla : 10000 VND ");
                }

                summary.append(String.format("\nTotal: %d VND", total));

                Toast.makeText(getApplicationContext(), "Order is placed",
                        Toast.LENGTH_LONG).show();

                try {
                sms = SmsManager.getDefault();
                sms.sendTextMessage("5554", null, summary.toString(), null, null);
                Toast.makeText(getApplicationContext(), "SMS is sent successfully!",
                        Toast.LENGTH_LONG).show();
            }

            catch (Exception e){
                Toast.makeText(getApplicationContext(),
                        "SMS is failed to send, please try again!",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

            }
        });
    }

}