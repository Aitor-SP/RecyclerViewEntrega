package com.example.recyclerviewentrega;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EscudosViewModel extends AndroidViewModel {

    EscudoRepository escudoRepository;

    public EscudosViewModel(@NonNull Application application) {
        super(application);

        escudoRepository = new EscudoRepository();
    }

    LiveData<List<Escudo>> escudos() {
        return escudoRepository.escudos();
    }
}
