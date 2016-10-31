package feicui.edu.testrecycler;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    TextInputLayout mTilay;
    TextInputEditText mTieText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTilay= (TextInputLayout) findViewById(R.id.til_layout);
        mTieText= (TextInputEditText) findViewById(R.id.tie_text);
        mTieText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
       if (mTieText.length()>4){
           mTieText.setError(null);
       }else{
           mTieText.setError("不能小于4");
       }
    }
}
