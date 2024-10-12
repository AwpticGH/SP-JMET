package sp.jmet.simpletodolistandroid.view.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import sp.jmet.simpletodolistandroid.R;
import sp.jmet.simpletodolistandroid.controller.NoteController;
import sp.jmet.simpletodolistandroid.databinding.FragmentCreationBinding;
import sp.jmet.simpletodolistandroid.flag.CreationFlag;
import sp.jmet.simpletodolistandroid.helper.DateHelper;
import sp.jmet.simpletodolistandroid.helper.ToastHelper;
import sp.jmet.simpletodolistandroid.model.DateModel;
import sp.jmet.simpletodolistandroid.model.NoteModel;
import sp.jmet.simpletodolistandroid.viewmodel.CreationViewModel;

public class CreationFragment extends Fragment {

    private FragmentCreationBinding binding;
    private DatePickerDialog datePickerDialog;
    private Calendar cal;
    private DateModel dateModel;

    public CreationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cal = Calendar.getInstance();
        dateModel = DateHelper.getCurrentDate(cal);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCreationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initDatePicker();

        binding.btnDp.setText(DateHelper.parseDateToString(dateModel.getYear(), dateModel.getMonth() + 1, dateModel.getDay()));
        binding.btnDp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        binding.btnCreationSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Checks if the title is empty or not
                if (!CreationFlag.isEmpty(binding.etCreationTitle)) {
                    String title = binding.etCreationTitle.getText().toString();
                    String desc = binding.etCreationDescription.getText().toString();

                    String strDate = binding.btnDp.getText().toString();
                    Date date = DateHelper.parseStringToDate(strDate, cal);

                    NoteModel model = new NoteModel();
                    model.setTitle(title);
                    model.setDescription(desc);
                    model.setDate(date);

                    CreationViewModel cvm = new CreationViewModel(getActivity().getApplication());
                    cvm.insert(model);
                    ToastHelper.createSuccess(binding.getRoot().getContext()).show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            NavController navController = NavHostFragment.findNavController(CreationFragment.this);
                            navController.navigate(R.id.action_CreationFragment_to_MainFragment);
                            navController.popBackStack(R.id.CreationFragment, true);
                        }
                    }, 2000);
                } else {
                    ToastHelper.titleEmpty(binding.getRoot().getContext()).show();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cal = null;
        binding = null;
        datePickerDialog = null;
        dateModel = null;
    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date;
                if (CreationFlag.isValid(cal, year, month, dayOfMonth)) {
                    date = DateHelper.parseDateToString(year, month + 1, dayOfMonth);
                    binding.btnDp.setText(date);
                } else {
                    date = DateHelper.parseDateToString(dateModel.getYear(), dateModel.getMonth() + 1, dateModel.getDay());
                    binding.btnDp.setText(date);
                    ToastHelper.dateInvalid(binding.getRoot().getContext()).show();
                }
            }
        };

        int style = android.R.style.Holo_ButtonBar_AlertDialog;
        datePickerDialog = new DatePickerDialog(binding.getRoot().getContext(), style, dateSetListener, dateModel.getYear(), dateModel.getMonth(), dateModel.getDay());
    }
}