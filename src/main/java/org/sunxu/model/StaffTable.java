package org.sunxu.model;

//承接数据库中的参数用的一个类
public class StaffTable {
    private int id;
    private String role;
    private String username;
    private String account;
    private String passwd;
    private String status;
    private String otherthing;

    public StaffTable() {
    }

    public StaffTable(int id, String role, String username, String account, String passwd, String status, String otherthing) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.account = account;
        this.passwd = passwd;
        this.status = status;
        this.otherthing = otherthing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOtherthing() {
        return otherthing;
    }

    public void setOtherthing(String otherthing) {
        this.otherthing = otherthing;
    }

    @Override
    public String toString() {
        return "StaffTable{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", passwd='" + passwd + '\'' +
                ", status='" + status + '\'' +
                ", otherthing='" + otherthing + '\'' +
                '}';
    }
}


