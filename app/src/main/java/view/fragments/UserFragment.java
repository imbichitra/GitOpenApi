package view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.bichi.gitopenapi.R;

import viewModel.UserViewModel;

import static android.content.ContentValues.TAG;


public class UserFragment extends Fragment implements View.OnClickListener{
    NavController navController = null;
    UserViewModel viewModel;
    EditText id,repo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_user, container, false);
        id = view.findViewById(R.id.userid);
        repo = view.findViewById(R.id.repo);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.next_btn).setOnClickListener(this);
        viewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.next_btn){
            String userId = id.getText().toString().trim();
            String repo1 = repo.getText().toString().trim();
            Log.d(TAG, "onClick: "+userId);
            viewModel.setUserId(userId);
            viewModel.setRepo(repo1);
            navController.navigate(R.id.action_userFragment_to_userDetailFragment);
        }
    }
}