package view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bichi.gitopenapi.R;

import model.UserDetail;
import network.UserInterFace;
import viewModel.UserViewModel;

public class UserDetailFragment extends Fragment {

    UserViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_user_detail, container, false);
        final TextView textView = view.findViewById(R.id.text1);
        viewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        viewModel.getUserData(new UserInterFace(){

            @Override
            public void onResult(UserDetail userDetail) {
                textView.setText(userDetail.getFullName());
            }

            @Override
            public void onFail(String error) {

            }
        });

        return view;
    }
}