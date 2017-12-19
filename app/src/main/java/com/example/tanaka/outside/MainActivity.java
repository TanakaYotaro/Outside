package com.example.tanaka.outside;

import android.app.Activity;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.view.WindowManager;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    private android.app.DialogFragment dialogFragment;
    private FragmentManager flagmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(
                LAYOUT_INFLATER_SERVICE);
        final View layout = inflater.inflate(R.layout.dialog,
                (ViewGroup) findViewById(R.id.layout_root));
        Button button = (Button)findViewById(R.id.show_button);

        // ボタンタップでAlertを表示させる
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog;

                // アラーとダイアログ を生成
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("ダイアログタイトル");
                builder.setView(layout);
                alertDialog = builder.create();

                builder.setPositiveButton("OK", new OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // OK ボタンクリック処理
                        // ID と PASSWORD を取得
                        EditText id
                                = (EditText) layout.findViewById(R.id.customDlg_id);
                        EditText pass
                                = (EditText) layout.findViewById(R.id.customDlg_pass);
                        String strId = id.getText().toString();
                        String strPass = pass.getText().toString();
                    }
                });
                builder.setNegativeButton("Cancel", new OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Cancel ボタンクリック処理
                    }
                });
                WindowManager.LayoutParams wmlp=alertDialog.getWindow().getAttributes();
                wmlp.gravity=Gravity.BOTTOM;
                alertDialog.getWindow().setAttributes(wmlp);
                // 表示
                alertDialog.show();
                //builder.create().show();
            }
        });

    }
}