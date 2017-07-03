package edu.gsu.httpcs.testproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.testproject.R;
import android.view.View;

/**
 * Created by spri0 on 6/26/17.
 */

public class CustomDialog extends Dialog {

    private final ICustomDialogListener listener;

    public interface ICustomDialogListener{
        public void onOKClicked(String msg);
 //       abstract void onCanceledClicked();

    }

    @OnClick(R.id.dialog_custom_ok)
    public void ok(View view){
        listener.onOKClicked("You clicked OK");
        cancel();
    }

    public CustomDialog(@NonNull Context context,ICustomDialogListener listener){
        super(context,R.style.dialog);
        setContentView(R.layout.dialog_custom);
        ButterKnife.bind(this);
        this.listener = listener;
    }
}
