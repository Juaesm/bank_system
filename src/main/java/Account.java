import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {
    private double amount;
    private Client client;

    Account(Client client)
    {
        this.amount = 0;
        this.client = client;
    }

    public double addMoney(double amount) {
        if (amount <= 0.0 || Double.isNaN(amount)) {
            return -1;
        }

        this.amount += amount;
        return this.amount;
    }

    public double retrieveMoney(double amount){
        if(amount > this.amount || Double.isNaN(amount)){
            return -2;
        }
        this.amount -= amount;
        return this.amount;
    }

    @Override
    public String toString()
    {
        return "Cliente: " + client.getName() + " " + client.getLast_name() + " - " + "$ " + this.amount;
    }




}
