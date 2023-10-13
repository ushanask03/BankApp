public class Employee {

    private int bank_id;
    private String bank_name;
    private String bank_email;

    private int bank_account_balance;
    private int cust_id;

    public Employee() {

    }

    public Employee(int bank_id, String bank_name, String bank_email, int bank_account_balance, int cust_id) {
        this.bank_id = bank_id;
        this.bank_name = bank_name;
        this.bank_email = bank_email;
        this.bank_account_balance = bank_account_balance;
        this.cust_id = cust_id;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_email() {
        return bank_email;
    }

    public void setBank_email(String bank_email) {
        this.bank_email = bank_email;
    }

    public int getBank_account_balance() {
        return bank_account_balance;
    }

    public void setBank_account_balance(int bank_account_balance) {
        this.bank_account_balance = bank_account_balance;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "bank_id=" + bank_id +
                ", bank_name='" + bank_name + '\'' +
                ", bank_email='" + bank_email + '\'' +
                ", bank_account_balance=" + bank_account_balance +
                ", cust_id=" + cust_id +
                '}';
    }
}