package parts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parts.model.Part;
import parts.repository.PartRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PartServiceImpl implements PartService {

    @Autowired
    private PartRepository partRepository;

    @Override
    public Page<Part> listParts(Pageable pageable) {
        return partRepository.findAll(pageable);
    }

    @Override
    public Part findById(Long id) {
        return partRepository.getById(id);
    }

    @Override
    public Page<Part> findAllByNessesery(boolean nessesery, Pageable pageable) {
        return partRepository.findAllByNessesery(nessesery, pageable);
    }

    @Override
    public Page<Part> findAllByDeviceName(String name, Pageable pageable) {
        String name1 = "%"+name+"%";
        return partRepository.findAllByDeviceName(name1, pageable);
    }

    @Override
    @Transactional
    public void addPart(Part part) {
        partRepository.save(part);
    }

    @Override
    @Transactional
    public void updatePart(Part part) {
        partRepository.save(part);
    }

    @Override
    @Transactional
    public void removePart(Long id) {
        partRepository.deleteById(id);
    }

    @Override
    public int countComp() {
        return partRepository.inStockCount();
    }
}