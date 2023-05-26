package fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pasandroidsemester2.Login;
import com.example.pasandroidsemester2.R;
import com.example.pasandroidsemester2.databinding.ActivityMainBinding;


public class ProfileFragment extends Fragment {
private ActivityMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Mendapatkan referensi button dari layout
        Button btnLogout = view.findViewById(R.id.buttonLogout);

        // Menambahkan onClickListener pada button

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(requireContext(), Login.class));
                Toast.makeText(getActivity(), "Button Profile clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}