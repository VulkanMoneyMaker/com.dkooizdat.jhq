package love.asdhgjllkas.fop;

public abstract class BasePresenter<T> implements ILifePresenter {

    protected T mView;

    public void setView(T view) {
        this.mView = view;
    }

    public BasePresenter() {
    }

    @Override
    public void onDestroy() {
    }
}