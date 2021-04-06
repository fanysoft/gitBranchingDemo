package cz.vancura.branches2;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserModel extends ViewModel {

    private final String TAG = "myTAG-UserModel";

    private final MutableLiveData<User> userLiveData = new MutableLiveData<>();

    public LiveData<User> getUser() {
        return userLiveData;
    }

    public UserModel() {
        // trigger user load.
    }

    void doAction(String name) {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
        Log.d(TAG, "doAction " + name);
        User user = new User(name);
        userLiveData.setValue(user);

    }

}
