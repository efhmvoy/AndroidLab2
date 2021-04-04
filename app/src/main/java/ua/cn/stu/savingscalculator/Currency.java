package ua.cn.stu.savingscalculator;

public class Currency {
    private String name;
    private double cStart;
    private double cEnd;

    public Currency(String name, double cStart, double cEnd) {
        this.name = name;
        this.cStart = cStart;
        this.cEnd = cEnd;
    }

    public String getName() {
        return name;
    }

    public double getcStart() {
        return cStart;
    }

    public double getcEnd() {
        return cEnd;
    }
}
