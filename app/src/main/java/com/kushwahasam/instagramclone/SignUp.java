package com.kushwahasam.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button btnretreive, btnSave;
    private EditText edtName,edtPunchPower, edtPunchSpeed, edtKickPower,edtKickSpeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnretreive = findViewById(R.id.btnretreive);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(SignUp.this);

        edtKickPower = findViewById(R.id.edtKickPower);
        edtKickSpeed = findViewById(R.id.edtKickSpeed);
        edtName = findViewById(R.id.edtName);
        edtPunchPower = findViewById(R.id.edtPunchPower);
        edtPunchSpeed = findViewById(R.id.edtPunchSpeed);
    }

    @Override
    public void onClick(View v) {

        try {
            final ParseObject kickBoxer = new ParseObject("Kick Boxer");
            kickBoxer.put("Name", edtName.getText().toString());
            kickBoxer.put("Kick Power", Integer.parseInt(edtKickPower.getText().toString()));
            kickBoxer.put("Kick Speed", Integer.parseInt(edtKickSpeed.getText().toString()));
            kickBoxer.put("Punch Speed", Integer.parseInt(edtPunchSpeed.getText().toString()));
            kickBoxer.put("Punch Power", Integer.parseInt(edtPunchPower.getText().toString()));
            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null)
                    {
                        FancyToast.makeText(SignUp.this,"Data Saved Succesfully",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                    }
                    else
                    {
                        FancyToast.makeText(SignUp.this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,true).show();
                    }
                }
            });
        }
        catch (Exception e)
        {
            FancyToast.makeText(SignUp.this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,true).show();
        }
    }
}
