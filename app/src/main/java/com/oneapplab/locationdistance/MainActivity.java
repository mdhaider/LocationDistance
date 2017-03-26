package com.oneapplab.locationdistance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tv);
        showDistance();


    }
    private void showDistance() {
        LatLng fromPosition = new LatLng(23.4555453556, 11.145315551);
        LatLng toPosition = new LatLng(12.1115145311, 99.333455333);
        double distance = SphericalUtil.computeDistanceBetween(fromPosition,toPosition);
        tv.setText("The distance between tho latlng is" +" "+ formatNumber(distance));
    }
    private String formatNumber(double distance) {
        String unit = "m";
        if (distance < 1) {
            distance *= 1000;
            unit = "mm";
        } else if (distance > 1000) {
            distance /= 1000;
            unit = "km";
        }

        return String.format("%4.3f%s", distance, unit);
    }
}
