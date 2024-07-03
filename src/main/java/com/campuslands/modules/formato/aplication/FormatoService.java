package com.campuslands.modules.formato.aplication;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.formato.domain.models.Formato;
import com.campuslands.modules.formato.domain.repository.FormatoRepository;


public class FormatoService {
     private final FormatoRepository formatoRepository;

    public FormatoService(FormatoRepository formatoRepository){
        this.formatoRepository  = formatoRepository;
    }

    public void createFormato(Formato formato) {
        formatoRepository.save(formato);
    }

    public void updateFormato(Formato formato) {
        formatoRepository.update(formato);
    }

    public Optional<Formato> getFormatoById(int id) {
        return formatoRepository.findById(id);
    }

    public void deleteFormato(int id) {
        formatoRepository.delete(id);
    }

    public List<Formato> getAllFormatos() {
        return formatoRepository.findAll();
    }
}
