package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddContact extends AppCompatActivity {

    private EditText mEdtFullname, mEdtCompany, mEdtTitle, mEdtMobile, mEdtEmail;
    private TextView mTvCeateAt;
    private ImageView mIvAvatar;
    private Button mBtnCancel, mBtnSave;
    private MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        db = new MyDatabase(this);
        mEdtFullname = (EditText)findViewById(R.id.edt_fname);
        mEdtCompany = (EditText)findViewById(R.id.edt_company);
        mEdtTitle = (EditText)findViewById(R.id.edt_title);
        mEdtMobile = (EditText)findViewById(R.id.edt_mobile);
        mEdtEmail = (EditText)findViewById(R.id.edt_email);

        mTvCeateAt = (TextView) findViewById(R.id.tv_createdAt);
        mIvAvatar = (ImageView) findViewById(R.id.iv_avatar);
        mBtnCancel = (Button) findViewById(R.id.btn_cancel);
        mBtnSave = (Button) findViewById(R.id.btn_save);

//        setOnClick();
    }

    public Contact addNewContact() {

        Contact newContact = new Contact();

        newContact.setmFullname(mEdtFullname.getText().toString());
        newContact.setmCompany(mEdtCompany.getText().toString());
        newContact.setmEmail(mEdtEmail.getText().toString());
        newContact.setmMobile(mEdtMobile.getText().toString());
        newContact.setmTitle(mEdtTitle.getText().toString());

        String dateInString = new SimpleDateFormat( "yyyy-mm-dd",
                Locale.getDefault()).format(new Date());
        newContact.setmCreated(dateInString);
//        newContact.setmId(34);
        newContact.setmId(db.addContact(newContact));
        return newContact;
    }


    public void saveContact(View v){
        Contact contact = addNewContact();
        Log.d("Giang","contact-- " + contact);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("RETURN", contact);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);

        finish();
    }

    public void cancel(View v){
        finish();
    }

}
