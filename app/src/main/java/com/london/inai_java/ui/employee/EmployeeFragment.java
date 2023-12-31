package com.london.inai_java.ui.employee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.london.inai_java.R;
import com.london.inai_java.databinding.FragmentEmployeeBinding;
import com.london.inai_java.ui.employee.adapter.EmployeeAdapter;
import com.london.inai_java.ui.employee.model.Employee;

import java.util.ArrayList;

public class EmployeeFragment extends Fragment {

    private FragmentEmployeeBinding binding;
    private ArrayList<Employee> list;
    private EmployeeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentEmployeeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        setAdapter();
        binding.btnArrow.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigateUp();
        });
    }

    private void loadData() {
        list = new ArrayList<>();
        list.add(new Employee("Ногоев Роман", R.drawable.ic_profile1));
        list.add(new Employee("Мартынов Артём", R.drawable.ic_profile2));
        list.add(new Employee("Мартынова Даша", R.drawable.ic_profile3));
        list.add(new Employee("Власова Анастасия", R.drawable.ic_profile1));
        list.add(new Employee("Алексеев Руслан", R.drawable.ic_profile2));
        list.add(new Employee("Кузнецова Милана", R.drawable.ic_profile3));
        list.add(new Employee("Смирнов Алексей", R.drawable.ic_profile1));
    }

    private void setAdapter() {
        adapter = new EmployeeAdapter(list, this::onClick);
        binding.recyclerView.setAdapter(adapter);
    }

    private void onClick() {
        NavHostFragment.findNavController(this).navigate(R.id.profileFragment);
    }
}
