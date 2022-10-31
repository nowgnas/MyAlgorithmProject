package 암호화;

public class SecVO {
    private String userId;
    private String salt;
    private String secKey;

    public SecVO() {
    }

    public SecVO(String userId, String salt, String secKey) {
        super();
        this.userId = userId;
        this.salt = salt;
        this.secKey = secKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSecKey() {
        return secKey;
    }

    public void setSecKey(String secKey) {
        this.secKey = secKey;
    }
}