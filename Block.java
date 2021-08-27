package Marketplace.Blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block{
    private String version;
    private Date Timestamp;
    private String hash;
    private String prevHash;
    private String data;

    public Block(String version, Date timestamp, String data){
        this.version = version;
        this.Timestamp = timestamp;
        this.data = data;
        this.hash = computeHash();
    }

    public String computeHash(){
        String dataToHash = "" + this.version + this.Timestamp + this.prevHash + this.data;

        MessageDigest  digest;
        String encoded = null;

        try{
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
            encoded = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.hash = encoded;
        return encoded;
    }


    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getTimestamp() {
        return this.Timestamp;
    }

    public void setTimestamp(Date Timestamp) {
        this.Timestamp = Timestamp;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevHash() {
        return this.prevHash;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}