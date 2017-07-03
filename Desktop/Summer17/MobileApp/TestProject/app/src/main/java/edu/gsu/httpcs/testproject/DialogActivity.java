package edu.gsu.httpcs.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Dialog;
import android.app.Notification;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import edu.gsu.httpcs.testproject.dialog.CustomDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.onClick;
import static android.R.attr.progress;
import static edu.gsu.httpcs.testproject.R.style.dialog;

public class DialogActivity extends BaseActivity{
    private int checkedID = 0;
    @BindView(R.id.activity_dialog_radio_group)
    RadioGroup radioGroup;
    private Object which;
    private Handler mHandler;
    private int DIALOG;

    @OnClick(R.id.activity_dialog_button_ok)
    public void ok(View view){
        switch (checkedID){
            case R.id.dialogButton1:
                normalDialog();
                break;
            case R.id.dialogButton2:
                listDialog();
                break;
            case R.id.dialogButton3:
                singleChoiceDialog();
                break;
            case R.id.dialogButton4:
                multiChoiceDialog();
                break;
            case R.id.dialogButton5:
                waitingDialog();
                break;
            case R.id.dialogButton6:
                progressDialog();
                break;
            case R.id.dialogButton7:
                inputDialog();
                break;
            case R.id.dialogButton8:
                CustomDialog customDialog =
                        new CustomDialog(this, new CustomDialog.ICustomDialogListener() {
                            @Override
                            public void onOKClicked(String msg) {
                                shortToast(msg);
                            }
                        });
                customDialog.setCanceledOnTouchOutside(true);
                customDialog.show();
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID = checkedId;
            }
        });
    }
    private void normalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("AlertTitle");
        builder.setMessage("This is a normal Dialog");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked Yes");
            }
        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked Neutral");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked No");
            }
        });
        builder.show();
    }
    ProgressDialog waitingDialog;
    private void waitingDialog(){
        waitingDialog =  new ProgressDialog(this);
        waitingDialog.setTitle("Downloading");
        waitingDialog.setMessage("Waiting...");
        //waitingDialog.setCancelable(false);
        waitingDialog.show();
        waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                shortToast("Dialog Was Canceled");
            }
        });
    }

    int choice =2;
    private void singleChoiceDialog(){
        final String[] items = {"item1", "item2","item3", "item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a single Choice Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){choice = which;}
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shortToast("You clicked: "+choice);
            }
        });
        builder.show();
    }

    private void listDialog() {
        final String[] items = {"item1", "item2","item3", "item4"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a List Dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(items, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                shortToast("You Clicked"+items[which]);
            }
        });
        builder.show();
    }

    ArrayList<Integer> choices = new ArrayList<>();
    private void multiChoiceDialog(){
        final String[] items = {"item1", "item2","item3", "item4"};
        final boolean initChoiceSets[] ={false, false, false, false};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("I'm a multichoice Dialog");
        builder.setMultiChoiceItems(items, initChoiceSets,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked) {
                            choices.add(which);
                        } else {
                            choices.remove(which);
                        }
                    }
                });
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int size = choices.size();
                        String str = "";
                        for (int i = 0; i < size; i++){
                            str += items[choices.get(i)] + " ";
                        }
                        shortToast("You chose: "+str);
                    }
                });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                shortToast("Cancel was clicked");
            }
        });
        builder.show();
    }
    private void progressDialog() {
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Downloading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();


        /*
        New Threa, Every 100ms progress +1
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // toastShort("Downloading success");
                Bundle bundle = new Bundle();
                bundle.putString("msg", "Download success");
                Message msg = Message.obtain();
                msg.what = DIALOG;
                msg.setData(bundle);
                mHandler.sendMessage(msg);
                progressDialog.cancel();
            }
        });
    }
    private void inputDialog(){
        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(this);
        inputDialog.setTitle("I'm an input Dialog").setView(editText);
        inputDialog.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        shortToast(editText.getText().toString());
                    }
                });
        inputDialog.setNegativeButton("Cancel", null).show();
    }
}

