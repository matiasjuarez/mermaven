package matias.conceptos;

import matias.conceptos.cuentas.ClientAccount;

/**
 * Representa un cliente de un banco
 * @author Matías
 */
public class Client {
    private String name;
    
    public Client(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
