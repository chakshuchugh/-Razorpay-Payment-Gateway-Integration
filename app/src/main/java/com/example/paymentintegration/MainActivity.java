package com.example.paymentintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {
    Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pay=findViewById(R.id.button);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pay();
            }
        });
    }

    public void pay(){
        Checkout co=new Checkout();
        JSONObject object=new JSONObject();
        try{
            object.put("name", "chakshu");
            object.put("description", "best");
            object.put("image", "mipmap-hdpi/ic_launcher.webp");
            object.put("currency", "INR");
            object.put("amount", "100");

            JSONObject prefill=new JSONObject();
            prefill.put("contact","8700414016");
            prefill.put("email","chughcakshu@gmail.com");
            object.put("prefill",prefill);

            co.open(MainActivity.this,object);
        }
        catch(JSONException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment failed", Toast.LENGTH_SHORT).show();
    }
}