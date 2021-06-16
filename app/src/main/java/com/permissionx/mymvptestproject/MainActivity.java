package com.permissionx.mymvptestproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 我们将创建一个活动应用程序，该应用程序将显示ArrayList中存在的引号列表中的随机引号。
 * 我们将看到演示者如何管理使应用程序的业务逻辑远离活动类。
 */
public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private TextView mTextView;
    private Button mButton;
    private ProgressBar mProgressBar;
    MainContract.MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.textView);
        mButton = (Button)findViewById(R.id.button);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mainPresenter = new MainPresenterImpl(this , new GetQuoteInteractorImpl());
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.onButtonClick();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
        mTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String string) {
        mTextView.setText(string);
    }
}
