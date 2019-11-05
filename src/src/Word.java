package src;

public class Word {

    private String v1;
    private String v2;
    private String v3;
    private String meaning;
    
    public Word() {
    }

    public Word(String v1, String v2, String v3, String meaning) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.meaning = meaning;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public String getV3() {
        return v3;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
