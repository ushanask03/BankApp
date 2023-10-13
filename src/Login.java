public class Login {
    private int cust_id;
    private String name;
    private String email;
    private int mobile_no;
    private String address;

    public Login(){

    }

    public Login(int cust_id, String name, String email, int mobile_no, String address) {
        this.cust_id = cust_id;
        this.name = name;
        this.email = email;
        this.mobile_no = mobile_no;
        this.address = address;


    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(int mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Login{" +
                "cust_id=" + cust_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile_no=" + mobile_no +
                ", address='" + address + '\'' +
                '}';
    }
}
