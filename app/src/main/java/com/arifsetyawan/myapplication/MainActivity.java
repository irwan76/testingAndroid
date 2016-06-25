package com.arifsetyawan.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    protected double itemPrice = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        //FontManager.markAsIconContainer(findViewById(R.id.icons_container), iconFont);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Menambah jumlah barang
     */
    public void increaseItem(View view) {
        display(1);
    }

    /**
     * Mengurangi jumlah barang
     * @param view
     */
    public void decreaseItem(View view){
        display(-1);
    }

    public void orderItem(){

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view); // initial value 0
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view); // initial value 0.00

        int existing = Integer.parseInt(String.valueOf(quantityTextView.getText()));
        number = number+existing;
        if(number < 1) number = 0; // mencegah value negatif

        double price = number * itemPrice;

        quantityTextView.setText("" + number);
        priceTextView.setText("" + NumberFormat.getCurrencyInstance().format(price));

    }

}