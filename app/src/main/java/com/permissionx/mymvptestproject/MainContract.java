package com.permissionx.mymvptestproject;

/**
 * Created by Ethan on 2021/6/16
 *
 * @author Ethan
 */
public interface MainContract {

    interface MainView{
        void showProgress();

        void hideProgress();

        void setQuote( String string );
    }

    interface GetQuoteInteractor{

        interface OnFinishedListener {
            void onFinished( String string ) ;
        }

        void getNextQuote( OnFinishedListener listener );
    }

    interface MainPresenter {

        void onButtonClick();

        void onDestroy();
    }
}
