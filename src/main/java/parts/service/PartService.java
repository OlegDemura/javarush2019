package parts.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import parts.model.Part;

import java.util.List;

public interface PartService {
    //load
    Page<Part> listParts(Pageable pageable);
    Part findById(Long id);
    Page<Part> findAllByNessesery(boolean nessesery, Pageable pageable);
    Page<Part> findAllByDeviceName(String name, Pageable pageable);

    //create
    void addPart(Part part);


    //update
    void updatePart(Part part);

    //delete
    void removePart(Long id);

    //count
    int countComp();
}
