package com.example.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditContact extends AppCompatActivity {

    private EditText mEdtFullname, mEdtCompany, mEdtTitle, mEdtMobile, mEdtEmail;
    private TextView mTvCeateAt;
    private ImageView mIvAvatar;
    private Button mBtnCancel, mBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        mEdtFullname = (EditText)findViewById(R.id.edt_fname);
        mEdtCompany = (EditText)findViewById(R.id.edt_company);
        mEdtTitle = (EditText)findViewById(R.id.edt_title);
        mEdtMobile = (EditText)findViewById(R.id.edt_mobile);
        mEdtEmail = (EditText)findViewById(R.id.edt_email);

        mTvCeateAt = (TextView) findViewById(R.id.tv_createdAt);
        mBtnCancel = (Button) findViewById(R.id.btn_cancel);
        mBtnSave = (Button) findViewById(R.id.btn_save);


        Intent intentData = getIntent();
        Bundle packBundle = intentData.getBundleExtra("My package");
        Contact getContact = (Contact)packBundle.getSerializable("contact");

        mEdtFullname.setText(getContact.getmFullname());
        mEdtEmail.setText(getContact.getmEmail());
        mEdtCompany.setText(getContact.getmCompany());
        mEdtTitle.setText(getContact.getmTitle());
        mEdtMobile.setText(getContact.getmMobile());
        //mTvCreateAt.setText(getContact.getmCreated());
    }

    public void addContact(){
        Contact newContact = new Contact();
        newContact.setmFullname(mEdtFullname.getText().toString());
        newContact.setmCompany(mEdtCompany.getText().toString());
        newContact.setmTitle(mEdtTitle.getText().toString());
        newContact.setmMobile(mEdtMobile.getText().toString());
        newContact.setmEmail(mEdtEmail.getText().toString());
    }

    public void setOnClick(){
        mBtnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addContact();
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }

}