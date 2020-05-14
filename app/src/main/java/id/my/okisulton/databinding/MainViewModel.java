package id.my.okisulton.databinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<User>> user = new MutableLiveData<>();
    private MainNavigation navigator;

    public void setNavigator(MainNavigation navigator) {
        this.navigator = navigator;
    }

    public MutableLiveData<List<User>> getUser() {
        setUser();
        return user;
    }

    public void setUser() {

        List<User> users = new ArrayList<>();
        users.add(new User("Oki s 1", "oki@oki.com"));
        users.add(new User("Oki s 2", "oki@oki.com"));
        users.add(new User("Oki s 3", "oki@oki.com"));
        users.add(new User("Oki s 4", "oki@oki.com"));

        this.user.setValue(users);
    }

    public void itemClick(User user){
        navigator.onItemClick(user);
    }

}
