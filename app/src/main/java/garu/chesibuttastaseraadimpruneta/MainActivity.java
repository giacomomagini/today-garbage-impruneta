package garu.chesibuttastaseraadimpruneta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import garu.chesibuttastaseraadimpruneta.mvp.main.MainPresenter;
import garu.chesibuttastaseraadimpruneta.mvp.main.MainView;
import garu.chesibuttastaseraadimpruneta.schedule.GarbageType;
import garu.chesibuttastaseraadimpruneta.ui.GarbageResouceMapper;
import garu.chesibuttastaseraadimpruneta.ui.GarbageTypeRes;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter presenter;

    @BindView(R.id.images_container)
    LinearLayout imageContainer;

    @BindView(R.id.garbage_text)
    TextView textGarbage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        this.presenter.setView(this);
        this.presenter.onCreate();
        this.presenter.showTodaySchedule();
    }

    @Override
    public void showSchedule(GarbageType[] garbageType) {
        Timber.i("Schedule: %s", Arrays.toString(garbageType));

        if (garbageType.length == 0)
            garbageType = new GarbageType[]{GarbageType.NONE};

        imageContainer.removeAllViews();

        StringBuilder text = new StringBuilder();

        for (GarbageType type : garbageType) {
            GarbageTypeRes res = GarbageResouceMapper.INSTANCE.get(type);
            addGarbageImageView(createImageView(res));
            text.append(String.format("%s\n", getResources().getText(res.getTextRes())));
        }

        textGarbage.setText(text);

    }

    @Override
    public void showError(Throwable throwable) {
        Timber.e(throwable);
    }

    public void refresh(View view) {
        this.presenter.showTodaySchedule();
    }

    private void addGarbageImageView(ImageView view) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.weight = 1;
        imageContainer.addView(view, params);
    }

    private ImageView createImageView(GarbageTypeRes res) {
        ImageView garbageIconView = new ImageView(this);
        garbageIconView.setImageResource(res.getIconRes());
        garbageIconView.setOnClickListener(click -> refresh(garbageIconView));
        return garbageIconView;
    }


}
