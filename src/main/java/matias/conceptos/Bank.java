package matias.conceptos;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by matias on 27/06/17.
 */

@Entity
public class Bank implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
