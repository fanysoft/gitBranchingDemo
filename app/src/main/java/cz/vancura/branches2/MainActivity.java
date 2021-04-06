package cz.vancura.branches2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "myTAG-MainActivity";
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG, "onCreate");

        edittext = findViewById(R.id.editText);
        // step 1 - MASTER - empty android project
        // step 2 - branch 1 - add MVVM
        // step 3 - merge branch 1 to MASTER - done


        // https://developer.android.com/reference/androidx/lifecycle/ViewModel

        final UserModel viewModel = new ViewModelProvider(this).get(UserModel.class);


        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User data) {
                // update ui.
                Log.d(TAG, "observer - name=" + data.getName());
            }
        });


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edittext.getText().toString();
                viewModel.doAction(name);
            }
        });




    }
}