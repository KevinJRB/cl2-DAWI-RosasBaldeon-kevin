package pe.edu.cibertec.examencl2web.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Invetary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventoryId;

    @ManyToOne
    @JoinColumn(name = "filmId")
    private Film film;

    private Integer storeId;
    private Date lastUpdate;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.REMOVE )
    private List<Rental> rentals;
}
