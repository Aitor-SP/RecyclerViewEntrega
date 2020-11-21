package com.example.recyclerviewentrega;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.recyclerviewentrega.databinding.FragmentEscudosBinding;
import com.example.recyclerviewentrega.databinding.ViewholderEscudoBinding;

import java.util.List;

public class EscudosFragment extends Fragment {

    FragmentEscudosBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding =  FragmentEscudosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EscudosViewModel escudosViewModel = new ViewModelProvider(this).get(EscudosViewModel.class);

        EscudosAdapter escudosAdapter = new EscudosAdapter();

        binding.recyclerView.setAdapter(escudosAdapter);
        //Para crear una linea divisoria entre cada item
        //binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        escudosViewModel.escudos().observe(getViewLifecycleOwner(), new Observer<List<Escudo>>() {
            @Override
            public void onChanged(List<Escudo> escudos) {
                escudosAdapter.setEscudoList(escudos);
            }
        });
    }

    class EscudosAdapter extends RecyclerView.Adapter<EscudoViewHolder> {

        List<Escudo> escudoList;

        @NonNull
        @Override
        public EscudoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EscudoViewHolder(ViewholderEscudoBinding.inflate(getLayoutInflater(),parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull EscudoViewHolder holder, int position) {
            Escudo escudo = escudoList.get(position);

            holder.binding.escudo.setText(escudo.escudo);
            holder.binding.ano.setText(escudo.ano);

            Glide.with(EscudosFragment.this).load(escudo.imagen).into(holder.binding.imagen);
        }

        @Override
        public int getItemCount() {
            return escudoList == null ? 0 : escudoList.size();
        }

        void setEscudoList(List<Escudo> escudoList) {
            this.escudoList = escudoList;
            notifyDataSetChanged();
        }
    }

    class EscudoViewHolder extends RecyclerView.ViewHolder {

        ViewholderEscudoBinding binding;

        public EscudoViewHolder(@NonNull ViewholderEscudoBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}