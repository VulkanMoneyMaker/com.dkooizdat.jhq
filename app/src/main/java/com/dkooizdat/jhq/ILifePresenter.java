package com.dkooizdat.jhq;

import android.os.Bundle;

public interface ILifePresenter {

    void onCreateView(Bundle saveInstance);

    void onStart();

    void onStop();

    void onDestroy();
}
