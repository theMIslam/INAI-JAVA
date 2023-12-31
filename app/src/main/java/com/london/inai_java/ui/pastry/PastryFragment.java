package com.london.inai_java.ui.pastry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.london.inai_java.R;
import com.london.inai_java.databinding.FragmentPastryBinding;
import com.london.inai_java.ui.employee.adapter.EmployeeAdapter;
import com.london.inai_java.ui.employee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class PastryFragment extends Fragment {

    private FragmentPastryBinding binding;
    private List<Employee> list;
    private EmployeeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPastryBinding.inflate(inflater, container, false);
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
        list.add(new Employee("Торт Наполеон", R.drawable.napoleon));
        list.add(new Employee("Торт Медовик", R.drawable.medovik));
        list.add(new Employee("Торт Красный бархат", R.drawable.krasnyi_barhat));
        list.add(new Employee("Торт Сникерс", R.drawable.snikers));
        list.add(new Employee("Торт Зебра", R.drawable.zebra));
        list.add(new Employee("Торт Брауни", R.drawable.brayni));
        list.add(new Employee("Торт Три шоколада", R.drawable.three_chocolate));
        list.add(new Employee("Торт Прага", R.drawable.praga));
        list.add(new Employee("Торт Трюфельный", R.drawable.trufel));
        list.add(new Employee("Торт Вупи Пай", R.drawable.vupi_pay));
    }

    private void setAdapter() {
        adapter = new EmployeeAdapter((ArrayList<Employee>) list, this::onClick);
        binding.recyclerView.setAdapter(adapter);
    }

    private void onClick() {
        NavHostFragment.findNavController(this).navigate(R.id.compositionFragment);
    }
}
