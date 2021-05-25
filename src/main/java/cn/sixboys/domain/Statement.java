package cn.sixboys.domain;

/**
 * @author mingjuntang
 * @Data 2021/5/24 19:57
 */
public class Statement {
    private Integer num;
    private String type;

    public Statement() {
    }

    public Statement(Integer num, String type) {
        this.num = num;
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
