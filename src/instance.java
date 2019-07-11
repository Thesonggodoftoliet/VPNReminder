public class instance implements Comparable<instance>{
    private int port;
    private String password;
    private String email;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(instance o) {
        return this.getPassword().compareTo(o.getPassword());
    }
}
