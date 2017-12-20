package com.example.asusx550jx.androidtraining_2.Activity;

import android.app.ProgressDialog;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asusx550jx.androidtraining_2.Interface.BiodataPresenterInterface;
import com.example.asusx550jx.androidtraining_2.Interface.BiodataViewInterface;
import com.example.asusx550jx.androidtraining_2.Model.BaseActivity;
import com.example.asusx550jx.androidtraining_2.Model.ResponseModel;
import com.example.asusx550jx.androidtraining_2.Presenter.BiodataPresenter;
import com.example.asusx550jx.androidtraining_2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements BiodataViewInterface{
    @BindView(R.id.edtFullname)
    EditText fullname;
    @BindView(R.id.edtPanggilan)
    EditText name;
    @BindView(R.id.edttgLahir)
    EditText borndate;
    @BindView(R.id.edttmLahir)
    EditText bornplace;
    @BindView(R.id.rdbtngender)
    RadioGroup gender;
    @BindView(R.id.edtAdd)
    EditText address;
    @BindView(R.id.edtnoHP)
    EditText phone;
    @BindView(R.id.inputjk)
    TextView jk;
    @BindView(R.id.edtEmail)
    EditText email;
    ProgressDialog pg;

    public BiodataPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pg = new ProgressDialog(this);
        ButterKnife.bind(MainActivity.this);
        presenter = new BiodataPresenter(this, getAPI());
    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.chklaki:
                if(checked)
                    jk.setText("Laki-laki");
                break;
            case R.id.chkperem:
                if(checked)
                    jk.setText("Perempuan");
        }
    }
    @OnClick(R.id.btnSave) void doBiodata(){
        pg.setMessage("Sending data");
        pg.setCancelable(false);
        pg.show();

        String sfullname = fullname.getText().toString();
        String sname = name.getText().toString();
        String sborndate = borndate.getText().toString();
        String sbornplace = bornplace.getText().toString();
        String sinputjk = jk.getText().toString();
        String saddress = address.getText().toString();
        String sphone = phone.getText().toString();
        String semail = email.getText().toString();

        presenter.doBiodata(sfullname, sname, sborndate, sbornplace, sinputjk, saddress, sphone, semail);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onFinishinsert(ResponseModel res) {
    pg.hide();
        Toast.makeText(MainActivity.this, "Insert Success",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFailureinsert() {
        pg.hide();
        Toast.makeText(MainActivity.this, "Insert Failure",Toast.LENGTH_SHORT).show();
    }
}
