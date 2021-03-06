package com.veboro.webbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public static final int W = ViewGroup.LayoutParams.WRAP_CONTENT;
    public static final int M = ViewGroup.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        final EditText edit = new EditText(this);
        edit.setLayoutParams(new ViewGroup.LayoutParams(M,W));

        Button button = new Button(this);
        button.setLayoutParams(new ViewGroup.LayoutParams(W,W));
        button.setText("Press me");

        final WebView web = new WebView(this);
        web.setLayoutParams(new ViewGroup.LayoutParams(M,M));
        web.setWebViewClient(new WebViewClient());

        LinearLayout l = new LinearLayout(this);
        l.setLayoutParams(new ViewGroup.LayoutParams(M,M));
        l.setOrientation(LinearLayout.VERTICAL);

        l.addView(edit);
        l.addView(button);
        l.addView(web);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = edit.getText().toString();
                web.loadUrl(url);
            }
        });

        setContentView(l);
    }
}
