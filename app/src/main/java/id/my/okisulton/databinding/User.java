package id.my.okisulton.databinding;

import androidx.databinding.ObservableBoolean;

import java.util.Observable;

public class User {

    public String name;
    public String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public ObservableBoolean isMark = new ObservableBoolean(false);
}
