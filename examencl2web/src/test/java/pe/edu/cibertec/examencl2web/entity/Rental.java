package pe.edu.cibertec.examencl2web.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentalId;
    private Date rentalDate;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Invetary inventory;
    private Integer customerId;
    private Date returnDate;
    private Integer staffId;
    private Date lastUpdate;
}
