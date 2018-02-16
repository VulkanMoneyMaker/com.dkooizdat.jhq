package love.asdhgjllkas.fop;

import android.webkit.WebResourceError;
import android.webkit.WebResourceResponse;

public interface MainView extends BaseView{

    void showProgress();
    void hideProgress();
    void onErrorNetworkHttp(WebResourceResponse errorResponse);
    void onErrorNetwork(WebResourceError error);
    void onOverloading(String data);
}
