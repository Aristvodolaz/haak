package com.example.hakatonapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hakatonapp.R;
import com.example.hakatonapp.adapter.DriverAdapter;
import com.example.hakatonapp.data.DriverData;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddDriverFragment extends Fragment {

    public static AddDriverFragment newInstance() {
        return new AddDriverFragment();
    }
    EditText nameUser, surnameUser, phoneUser, startPoint, endPoint, numCar, nameCar, ageDriver, price, date, numMest;
    String name, surname, phone, start, end, num, car, age, cena, data, mesta;
    Button addBtn;
    private FirebaseFirestore db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =LayoutInflater.from(getContext()).inflate(R.layout.create_travel_driver, container, false);

        nameUser = v.findViewById(R.id.name_user);
        surnameUser = v.findViewById(R.id.surname_user);
        phoneUser = v.findViewById(R.id.num_phone);
        startPoint = v.findViewById(R.id.start_point);
        endPoint = v.findViewById(R.id.end_point);
        numCar = v.findViewById(R.id.num_car);
        nameCar = v.findViewById(R.id.name_car);
        ageDriver = v.findViewById(R.id.driver_age);
        price = v.findViewById(R.id.price);
        date = v.findViewById(R.id.date_Start);
        numMest = v.findViewById(R.id.num_mest);
        addBtn = v.findViewById(R.id.btn_add);
        addBtn.setOnClickListener(view->{
            initViews();

        });


        db = FirebaseFirestore.getInstance();




        return v;
    }

    @SuppressLint("SuspiciousIndentation")
    private void initViews(){
        if (nameUser.getText()!=null)
        name = nameUser.getText().toString();
        if (surnameUser.getText()!=null)
        surname = surnameUser.getText().toString();
        if (phoneUser.getText()!=null)
        phone = phoneUser.getText().toString();
        if (startPoint.getText()!=null)
        start = startPoint.getText().toString();
        if (endPoint.getText()!=null)
        end = endPoint.getText().toString();
        if (numCar.getText()!=null)
        num = numCar.getText().toString();
        if (nameCar.getText()!=null)
        car = nameCar.getText().toString();
        if (ageDriver.getText()!=null)
        age = ageDriver.getText().toString();
        if (price.getText()!=null)
        cena = price.getText().toString();
        if (date.getText()!=null)
        data = date.getText().toString();
        if (numMest.getText()!=null)
        mesta = numMest.getText().toString();

        if(name.isEmpty()||surname.isEmpty()||phone.isEmpty()||start.isEmpty()
                ||end.isEmpty()||num.isEmpty()||car.isEmpty()||
        age.isEmpty()||cena.isEmpty()||data.isEmpty()||mesta.isEmpty()){
            Toast.makeText(getContext(),"Заполните все поля!", Toast.LENGTH_LONG).show();
        }else addToDataBase(name,surname, phone, start,end, num, car,age, cena,data, mesta);
    }

    private void addToDataBase(String name, String surname, String phone, String start, String end, String num, String car, String age, String cena, String data, String mesta) {

        CollectionReference dbDrivers = db.collection("DriverData");
        DriverData driverData = new DriverData(name ,surname, phone,start,end,num,car, age,cena,data,mesta);
        dbDrivers.add(driverData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getContext(), "Ваша поездка успешно добавлена!", Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Произошла ошибка, попробуйте позднее!", Toast.LENGTH_LONG).show();
            }

    });
    }
}
