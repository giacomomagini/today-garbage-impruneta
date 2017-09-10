package garu.chesibuttastaseraadimpruneta.mvp.common;

/**
 * Created by garu on 08/09/17.
 */

public abstract class Presenter<M, V> {

    private M model;
    private V view;

    public Presenter(M model, V view) {
        this.model = model;
        this.view = view;
    }

    public Presenter(M model){
        this(model, null);
    }

    public V getView() {
        return view;
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public void setView(V view) {
        this.view = view;
    }

}
