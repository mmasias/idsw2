# Divergent changes

Ocurre cuando una clase es modificada por múltiples razones diferentes. Esto se traduce en que la clase tiene múltiples responsabilidades, lo que viola el Principio de Responsabilidad Única (SRP). Como resultado, cada vez que una funcionalidad necesita ser modificada, hay un riesgo alto de afectar otras funcionalidades que la clase maneja.

## Ejemplo

### Problema

Supongamos que tenemos una clase que maneja diversas operaciones relacionadas con cuentas bancarias, incluyendo la impresión de reportes de cuenta y la administración de la lógica de transacciones.

```java

public class AccountManager {
    private String accountNumber;
    private double balance;

    public AccountManager(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. Balance is now " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Balance is now " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void printStatement() {
        System.out.println("Account Statement for " + accountNumber);
        System.out.println("Current balance: " + balance);
    }

    public void addInterest(double rate) {
        double interest = balance * rate / 100;
        balance += interest;
        System.out.println("Interest added. Balance is now " + balance);
    }
}


```

La clase AccountManager es responsable por la gestión de transacciones (depósitos y retiros), la manipulación de intereses, y la impresión de estados de cuenta. Estas son razones divergentes para cambiar esta clase:

- Si la forma de calcular intereses cambia, se tendrá que modificar AccountManager.
- Si la política de transacciones cambia, se tendrá que modificar AccountManager.
- Si el formato del estado de cuenta cambia, se tendrá que modificar AccountManager.

Cada uno de estos cambios afecta a una "vertiente" diferente del manejo de la cuenta.

### Solución propuesta

```java

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. Balance is now " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Balance is now " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class AccountStatementPrinter {
    public void printStatement(Account account) {
        System.out.println("Account Statement for " + account.getAccountNumber());
        System.out.println("Current balance: " + account.getBalance());
    }
}

public class InterestManager {
    public void addInterest(Account account, double rate) {
        double interest = account.getBalance() * rate / 100;
        account.deposit(interest);
    }
}

```

- **Responsabilidades separadas**: La lógica de transacción, la generación de estados de cuenta, y la administración de intereses están ahora en clases separadas.
- **Adherencia al SRP**: Cada clase tiene una razón única para cambiar, lo cual facilita la mantenibilidad y escalabilidad del código.
- **Facilidad de mantenimiento**: Modificar cualquier lógica relacionada con intereses, transacciones, o reportes es ahora más seguro y no requiere tocar otras áreas del código.
