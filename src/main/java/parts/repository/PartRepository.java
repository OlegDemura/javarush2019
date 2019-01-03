package parts.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import parts.model.Part;



@Repository
public interface PartRepository extends JpaRepository<Part, Long>{
    @Query(value = "select distinct min(sum(amount)) over() deviceName from Part where nessesery = true group by deviceName", nativeQuery = true)
    Integer inStockCount();

    Part getById(Long id);

    Page<Part> findAllByNessesery(boolean nessesery, Pageable pageable);

    @Query(value = "SELECT * FROM Part WHERE deviceName LIKE ?1", nativeQuery = true)
    Page<Part> findAllByDeviceName(String searchString, Pageable pageable);
}