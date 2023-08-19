package Terminal.terminale.Custom;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class AppData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;
    @Column(unique = true)
    @NotEmpty
    private String IpAddress;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private String description;
    @Column
    private int price;
}
