package henrytao.me.testdatabinding;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import java.util.Locale;

/**
 * Created by henrytao on 4/19/16.
 */
public class ItemViewModel extends BaseObservable {

    public ObservableField<String> title = new ObservableField<>();

    public ItemViewModel() {
    }

    public void setData(int data) {
        title.set(String.format(Locale.US, "Title %d", data));
    }
}
