package org.acme;

public class NameVO {
    public String common;
    public String official;

    public String getOfficial() {
        return official;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    @Override
    public String toString() {
        return "Name{" +
                "common='" + common + '\'' +
                ", official='" + official + '\'' +
                '}';
    }
}
