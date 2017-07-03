package matias.conceptos.cuentas;

import matias.conceptos.Client;

import java.util.List;

/**
 * Created by Matías on 14/04/2017.
 */
public class ClientAccount {

    private AccountAdministrativeData accountAdministrativeData;
    private List<Account> accountList;
    private Client client;

    public AccountAdministrativeData getAccountAdministrativeData() {
        return accountAdministrativeData;
    }

    public void setAccountAdministrativeData(AccountAdministrativeData accountAdministrativeData) {
        this.accountAdministrativeData = accountAdministrativeData;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
