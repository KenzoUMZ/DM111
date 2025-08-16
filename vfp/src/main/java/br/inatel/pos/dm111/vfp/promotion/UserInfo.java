package br.inatel.pos.dm111.vfp.promotion;

public class UserInfo {
    private String userId;
    private String userType;

    public UserInfo() {}
    public UserInfo(String userId, String userType) {
        this.userId = userId;
        this.userType = userType;
    }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
}
