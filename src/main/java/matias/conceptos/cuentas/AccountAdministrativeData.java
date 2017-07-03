/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matias.conceptos.cuentas;

import java.util.Date;

/**
 * Administrative information related to an account.
 * @author Matías
 */
public class AccountAdministrativeData {
    
    private String id;
    private boolean active;
    private Date creationDate;
    
    public AccountAdministrativeData(String id){
        this(id, new Date());
    }

    public AccountAdministrativeData(String id, Date creationDate){
        this(id, creationDate, false);
    }

    public AccountAdministrativeData(String id, Date creationDate, boolean active){
        this.id = id;
        this.creationDate = creationDate;
        this.active = active;
    }
    
    public String getId(){
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
