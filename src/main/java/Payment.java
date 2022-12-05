public class Payment {
    private final Money amount;
    public Payment(Money cashTendered) {  amount = cashTendered;  }
    public Money getAmount() {  return amount;  }
    @Override
    public String toString(){
        return amount.toString();
    }
}
