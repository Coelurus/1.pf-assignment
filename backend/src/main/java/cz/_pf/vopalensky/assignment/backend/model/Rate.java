package cz._pf.vopalensky.assignment.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "rates")
public class Rate {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_name")
    private String shortName;
    @Column(name = "valid_from")
    private String validFrom;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @Column(name = "move")
    private Double move;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "val_buy")
    private Double valBuy;
    @Column(name = "val_sell")
    private Double valSell;
    @Column(name = "val_mid")
    private Double valMid;
    @Column(name = "curr_buy")
    private Double currBuy;
    @Column(name = "curr_sell")
    private Double currSell;
    @Column(name = "curr_mid")
    private Double currMid;
    @Column(name = "version")
    private Integer version;
    @Column(name = "cnb_mid")
    private Double cnbMid;
    @Column(name = "ecb_mid")
    private Double ecbMid;

    public Rate() {
    }
}
