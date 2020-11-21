package com.example.recyclerviewentrega;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;

public class EscudoRepository {

    LiveData<List<Escudo>> escudosLiveData;

    EscudoRepository() {
        List<Escudo> escudos = Arrays.asList(
                new Escudo("Zaragoza FC", "1932", R.drawable.rz4),
                new Escudo("Zaragoza CF", "1941", R.drawable.rz5),
                new Escudo("Real Zaragoza FC", "1951", R.drawable.rz6),
                new Escudo("Real Zaragoza SAD", "1992", R.drawable.rz7),
                new Escudo("Real Zaragoza SAD", "2008", R.drawable.rz1),
                new Escudo("Real Zaragoza SAD", "2012", R.drawable.rz8)
        );

        escudosLiveData = new MutableLiveData<>(escudos);
    }

    LiveData<List<Escudo>> escudos() {
        return escudosLiveData;
    }
}
