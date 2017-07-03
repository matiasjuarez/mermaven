/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matias.conceptos.cuentas;

import matias.conceptos.Amount;
import matias.conceptos.Currency;
import matias.conceptos.excepciones.ExcepcionFondosInsuficientes;
import matias.conceptos.excepciones.ExcepcionLimiteExtraccion;

/**
 * Represents an account from which you can take money or in which you con make deposits.
 * @author Matías
 */
public class Account {
    private AccountAdministrativeData accountAdministrativeData;
    private float capital;
    private float withdrawalLimit;
    private float depositLimit;
    private float overdraftLimit;
    private Currency currency;

    public Account(Currency currency){
        this.capital = 0;
        this.withdrawalLimit = 0;
        this.depositLimit = 0;
        this.overdraftLimit = 0;
        this.currency = currency;
    }

    public Amount getWithdrawalLimit() {
        Amount amountLimiteExtraccion = new Amount(getCurrency(), this.withdrawalLimit);
        return amountLimiteExtraccion;
    }

    public void setWithdrawalLimit(float withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public Amount getDepositLimit() {
        Amount amountLimiteDeposito = new Amount(getCurrency(), this.depositLimit);
        return amountLimiteDeposito;
    }

    public void setDepositLimit(float depositLimit) {
        this.depositLimit = depositLimit;
    }

    public Amount getOverdraftLimit() {
        Amount amountLimiteGiroDescubierto = new Amount(getCurrency(), this.overdraftLimit);
        return amountLimiteGiroDescubierto;
    }

    public void setOverdraftLimit(float overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public Amount getCapital() {
        return new Amount(currency, capital);
    }

    public void setCapital(float capital) {
        this.capital = capital;
    }

    public Currency getCurrency() {
        return currency;
    }

    public AccountAdministrativeData getAccountAdministrativeData() {
        return accountAdministrativeData;
    }

    public void setAccountAdministrativeData(AccountAdministrativeData accountAdministrativeData) {
        this.accountAdministrativeData = accountAdministrativeData;
    }

    public void depositar(float montoDeposito) {
        this.capital += montoDeposito;
    }
    
    public void extraer(float montoExtraccion) throws
            ExcepcionLimiteExtraccion, ExcepcionFondosInsuficientes {

        validarExtraccion(montoExtraccion);
                
        this.capital -= montoExtraccion;
    }

    public void validarExtraccion(float montoExtraer) throws ExcepcionFondosInsuficientes, ExcepcionLimiteExtraccion {
        validarFondosSuficientesExtraccion(montoExtraer);
        validarLimiteExtraccion(montoExtraer);
    }

    private void validarFondosSuficientesExtraccion(float montoExtraer) throws ExcepcionFondosInsuficientes {
        float cantidadMaximaQuePuedeExtraer = getCapital().getQuantity() + overdraftLimit;

        if (montoExtraer > cantidadMaximaQuePuedeExtraer){
            throw new ExcepcionFondosInsuficientes();
        }
    }

    private void validarLimiteExtraccion(float montoExtraer) throws ExcepcionLimiteExtraccion {
        if(montoExtraer > this.withdrawalLimit) {
            throw new ExcepcionLimiteExtraccion();
        }
    }
}
