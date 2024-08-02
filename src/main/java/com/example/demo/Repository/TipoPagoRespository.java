package com.example.demo.Repository;

package com.example.crud_segurity_aplication.models.TipoPagoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPagoModel, Long> {
    
}
