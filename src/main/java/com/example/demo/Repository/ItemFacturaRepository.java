package com.example.demo.Repository;

package com.example.crud_segurity_aplication.models.ItemFacturaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemFacturaRepository extends JpaRepository<ItemFacturaModel, Long> {
    
}
