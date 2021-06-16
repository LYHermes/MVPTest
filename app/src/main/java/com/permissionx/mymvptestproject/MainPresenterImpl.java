package com.permissionx.mymvptestproject;

/**
 * Created by Ethan on 2021/6/16
 *
 * @author Ethan
 */
public class MainPresenterImpl implements MainContract.MainPresenter, MainContract.GetQuoteInteractor.OnFinishedListener{

    private MainContract.MainView mMainView;
    private MainContract.GetQuoteInteractor mGetQuoteInteractor;

    public MainPresenterImpl(MainContract.MainView mainView , MainContract.GetQuoteInteractor getQuoteInteractor){
        mMainView = mainView;
        mGetQuoteInteractor = getQuoteInteractor;
    }

    @Override
    public void onButtonClick() {

        if ( mMainView != null ){
            mMainView.showProgress();
        }
        mGetQuoteInteractor.getNextQuote(this);

    }

    @Override
    public void onDestroy() {
        mMainView = null;
    }

    @Override
    public void onFinished(String string) {
        if ( mMainView!=null ){
            mMainView.setQuote(string);
            mMainView.hideProgress();
        }
    }
}
