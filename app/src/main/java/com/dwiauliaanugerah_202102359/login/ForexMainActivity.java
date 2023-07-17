package com.dwiauliaanugerah_202102359.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.text.DecimalFormat;

import cz.msebera.android.httpclient.Header;

public class ForexMainActivity extends AppCompatActivity {

    private ProgressBar loadingProgressBar;
    private SwipeRefreshLayout swipeRefreshLayout1;
    private TextView sgdTextView, hkdTextView, hufTextView, idrTextView, nzdTextView, kpwTextView, krwTextView, kwdTextView, sekTextView, shpTextView, usdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forex_main);

        swipeRefreshLayout1 = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout1);
        sgdTextView = (TextView)findViewById(R.id.sgdTextView);
        hkdTextView = (TextView)findViewById(R.id.hkdTextView);
        hufTextView = (TextView)findViewById(R.id.hufTextView);
        idrTextView = (TextView)findViewById(R.id.idrTextView);
        nzdTextView = (TextView)findViewById(R.id.nzdTextView);
        kpwTextView = (TextView)findViewById(R.id.kpwTextView);
        krwTextView = (TextView)findViewById(R.id.krwTextView);
        kwdTextView = (TextView)findViewById(R.id.kwdTextView);
        sekTextView = (TextView)findViewById(R.id.sekTextView);
        shpTextView = (TextView)findViewById(R.id.shpTextView);
        usdTextView = (TextView)findViewById(R.id.usdTextView);
        loadingProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);

        initSwipeRefreshLayout();
        initForex();
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initForex();
            }
        });
    }

    public String formatNumber(double number, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }

    private void initForex() {
        loadingProgressBar.setVisibility(TextView.VISIBLE);

        String url = "https://openexchangerates.org/api/latest.json?app_id=76c053e36034400085112d30a02f0493";

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                ForexRootModel rootModel = gson.fromJson(new String(responseBody), ForexRootModel.class);
                ForexRatesModel ratesModel = rootModel.getRatesModel();

                double sgd = ratesModel.getIDR() / ratesModel.getSGD();
                double hkd = ratesModel.getIDR() / ratesModel.getHKD();
                double huf = ratesModel.getIDR() / ratesModel.getHUF();
                double nzd = ratesModel.getIDR() / ratesModel.getNZD();
                double kpw = ratesModel.getIDR() / ratesModel.getKPW();
                double krw = ratesModel.getIDR() / ratesModel.getKRW();
                double kwd = ratesModel.getIDR() / ratesModel.getKWD();
                double sek = ratesModel.getIDR() / ratesModel.getSEK();
                double shp = ratesModel.getIDR() / ratesModel.getSHP();
                double usd = ratesModel.getIDR() / ratesModel.getUSD();
                double idr = ratesModel.getIDR();


                sgdTextView.setText(formatNumber(sgd, "###,##0.##"));
                hkdTextView.setText(formatNumber(hkd, "###,##0.##"));
                hufTextView.setText(formatNumber(huf, "###,##0.##"));
                nzdTextView.setText(formatNumber(nzd, "###,##0.##"));
                kpwTextView.setText(formatNumber(kpw, "###,##0.##"));
                krwTextView.setText(formatNumber(krw, "###,##0.##"));
                kwdTextView.setText(formatNumber(kwd, "###,##0.##"));
                sekTextView.setText(formatNumber(sek, "###,##0.##"));
                shpTextView.setText(formatNumber(shp, "###,##0.##"));
                usdTextView.setText(formatNumber(usd, "###,##0.##"));
                idrTextView.setText(formatNumber(idr, "###,##0.##"));

                loadingProgressBar.setVisibility(TextView.INVISIBLE);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                loadingProgressBar.setVisibility(TextView.INVISIBLE);
            }
        });
    }
}