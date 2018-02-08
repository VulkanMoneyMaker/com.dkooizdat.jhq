package com.love.pop;

import android.os.Bundle;

public interface ILifePresenter {

    void onCreateView(Bundle saveInstance);

    void onStart();

    void onStop();

    void onDestroy();
}
