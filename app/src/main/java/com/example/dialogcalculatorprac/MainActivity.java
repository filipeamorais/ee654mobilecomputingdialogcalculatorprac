package com.example.dialogcalculatorprac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button opt;
    EditText op1, op2;
    TextView result;
    String[] operations = new String[]{ "+ Add",
            "- Subtract", "* Multiply", "/ Divide" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opt  = (Button)findViewById(R.id.opt);
        op1  = (EditText)findViewById(R.id.op1);
        op2  = (EditText)findViewById(R.id.op2);
        result = (TextView) findViewById(R.id.result);
        opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertdialogbuilder =
                        new AlertDialog.Builder(MainActivity.this);
                alertdialogbuilder.setTitle("Select Operation ");
                alertdialogbuilder.setItems(operations,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which){
                                String str = Arrays.asList(operations)
                                        .get(which);
                                opt.setText(" "+ str.charAt(0) + " ");
                                int val1=Integer.valueOf(op1.getText()
                                        .toString());
                                int val2=Integer.valueOf(op2.getText()
                                        .toString());
                                switch(which) {
                                    case 0: result.setText(" = "
                                            +(val1+val2));
                                        break;
                                    case 1: result.setText(" = "
                                            +(val1-val2));
                                        break;
                                    case 2: result.setText(" = "
                                            +(val1*val2));
                                        break;
                                    case 3: result.setText(" = "
                                            +(val1/val2));
                                        break;
                                }
                            } // end of onClick()
                        }); //end of setItems()
                AlertDialog dialog=alertdialogbuilder.create();
                dialog.show();
            } //end of onClick()
        }); //end of opt.setOnClickListener ()
    }// end of onCreate()
}// end of class MainActivity
