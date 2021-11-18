public class Bartenders {
    private String name;
    private String address;
    private String pps;
    private String Phone;
    private String email;

    public Bartenders() {
        this("empty","empty","empty","empty","empty");
    }

    public Bartenders(String name, String address, String pps, String phone, String email) {
        this.name = name;
        this.address = address;
        this.pps = pps;
        Phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPps() {
        return pps;
    }

    public void setPps(String pps) {
        this.pps = pps;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Bartenders" +
                "name:" + name + this.getName() +
                "address:" + address + this.getAddress() +
                "pps:" + pps + this.getPps() +
                "Phone:" + Phone + this.getPhone() +
                "email:" + email ;
    }
}
