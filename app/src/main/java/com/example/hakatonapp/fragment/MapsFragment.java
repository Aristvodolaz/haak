package com.example.hakatonapp.fragment;

import static android.content.Context.LOCATION_SERVICE;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hakatonapp.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnCameraMoveStartedListener, LocationListener {

    private GoogleMap googleMap;

    Double lan, lon;

    public static MapsFragment newInstance() {
        return new MapsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.maps_layout, container, false);

        ((SupportMapFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.maps)).getMapAsync(this);
//        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager()
//                .findFragmentById(R.id.maps);
//        mapFragment.getMapAsync(this);

        return v;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        googleMap = map;

        LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

//        final LatLngBounds.Builder builder = new LatLngBounds.Builder();
//
//        builder.include(new LatLng(0,0));
//        builder.include(new LatLng(10,10));
//
//        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
//            @Override
//            public void onMapLoaded() {
//                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(builder.build(), 100);
//
//                googleMap.animateCamera(cu);
//               // googleMap.getCameraPosition(lon, lan)
//            }
//        });
    }

    @Override
    public void onCameraMoveStarted(int i) {
        googleMap.setOnCameraIdleListener((GoogleMap.OnCameraIdleListener) this);
        googleMap.setOnCameraMoveStartedListener(null);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        lan = location.getLatitude();
        lon = location.getLongitude();
    }
}
