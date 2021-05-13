package com.example.getimagedemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.getimagedemo.Utils.ImageUtil;


public class MainFragment extends Fragment {
    Button getImage;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        getImage = view.findViewById(R.id.button);
        initOnClick();
        return view;
    }

    private void initOnClick() {
        getImage.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent,1);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 1){
            String testdata = ImageUtil.getRealPathFromUri(this.getActivity(),data.getData());
            Log.d("ImageInfo","ImageUri:" + data.getData().toString() + "/n" + "ImageRealPath:" + testdata);
            Toast.makeText(this.getActivity(), testdata, Toast.LENGTH_SHORT).show();
        }
    }
}