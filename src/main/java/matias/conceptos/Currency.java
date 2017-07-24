/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matias.conceptos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author Matías
 */
@Entity
public class Currency implements Serializable{
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    private String symbol;

    public Currency(){}

    public Currency(String name){
        this.name = name;
    }

    public Currency(CurrencyType type){
        this.name = type.getName();
        this.symbol = type.getSymbol();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
