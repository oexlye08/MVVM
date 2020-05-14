package id.my.okisulton.databinding;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import id.my.okisulton.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements  MainNavigation{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main.xml =>>> ActivityMainBinding
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //setup view Model
        MainViewModel viewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel.class);

        viewModel.setNavigator(this);
        viewModel.setUser();
        viewModel.getUser().observe(this, user -> {
            binding.recyclerView.setAdapter(new MainAdapter(user, viewModel));
        });

    }

    @Override
    public void onItemClick(User user) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(user.name + "\n" + user.email);

        if (user.isMark.get()){
            alert.setPositiveButton("Unmark", (dialog, which) -> {
                user.isMark.set(false);
                dialog.dismiss();
            });
        }else {
            alert.setPositiveButton("MARK", (dialog, which) -> {
                user.isMark.set(true);
                dialog.dismiss();
            });
        }

        alert.show();
    }
}
