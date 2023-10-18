package sabrina.rover.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sabrina.rover.models.Obstaculo;
import sabrina.rover.repository.ObstaculoRepository;

import java.util.List;

@Service
public class ObstaculoService {
    @Autowired
    private ObstaculoRepository obstaculoRepository;

    public List<Obstaculo> getAll(){
        return (List<Obstaculo>) obstaculoRepository.findAll();
    }
}
