package sp.jmet.simpletodolistandroid.view.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sp.jmet.simpletodolistandroid.R;
import sp.jmet.simpletodolistandroid.databinding.FragmentMainBinding;
import sp.jmet.simpletodolistandroid.viewmodel.MainViewModel;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private FragmentMainBinding binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fab.setOnClickListener(v ->
            NavHostFragment.findNavController(MainFragment.this)
                    .navigate(R.id.action_MainFragment_to_CreationFragment)
        );

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the MainViewModel
    }

}