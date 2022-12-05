import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Class Sale
public class Sale {
    private final List<SalesLineltem> lineltems = new ArrayList<>();
    private final Date date = new Date();
    private boolean isComplete = false;
    protected Payment payment;

    public Money getBalance()  {
        return payment.getAmount().minus(getTotal());
    }

    public void becomeComplete() {  isComplete = true;   }

    public boolean isComplete() {   return isComplete;   }

    public void makeLineltem(ProductSpecification spec, int quantity) {
        lineltems.add(new SalesLineltem(spec, quantity));
    }

    public Money getTotal()
    {
        Money total = new Money();
        for (SalesLineltem lineltem : lineltems) {
            total=total.add(lineltem.getSubtotal());
        }
        return total;
    }

    public void makePayment(Money cashTendered) {
        payment = new Payment(cashTendered);
    }

    @Override
    public String toString() {
        Money total = new Money();
        Money subTotal = null;
        StringBuilder s = new StringBuilder("Date: " + date + "\n");
        s.append("---------------------------------------------\n");
        for (SalesLineltem sli : lineltems) {
            s.append(sli.toString());
            subTotal = sli.getSubtotal();
            total = total.add(subTotal);
        }
        s.append("---------------------------------------------\n");
        s.append("총 계산 금액: ").append(getTotal()).append("\n");

        if(payment!=null){
            s.append("지불 금액 : ").append(payment).append("\n");
            s.append("거스름 돈 : ").append(getBalance()).append("\n");
        }
        s.append("---------------------------------------------\n");
        return s.toString();
    }
}