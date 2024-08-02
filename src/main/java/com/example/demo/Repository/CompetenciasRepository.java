package com.example.demo.Repository;

package com.example.crud_segurity_aplication.models.CompetenciasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaRepository extends JpaRepository<CompetenciasModel, Long> {
    
}
