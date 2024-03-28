package minMax;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @author MX.Y
 * @DATE 2021/11/23 23:10
 * @qq 2690399241
 */
public class GoodTrend {
    private Integer lastVal;
    private Integer whichOne;
    private Integer currVal;
    private Integer maxVal;

    public Integer getLastVal() {
        return lastVal;
    }

    public void setLastVal(Integer lastVal) {
        this.lastVal = lastVal;
    }

    public Integer getWhichOne() {
        return whichOne;
    }

    public void setWhichOne(Integer whichOne) {
        this.whichOne = whichOne;
    }

    public Integer getCurrVal() {
        return currVal;
    }

    public void setCurrVal(Integer currVal) {
        this.currVal = currVal;
    }

    public Integer getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(Integer maxVal) {
        this.maxVal = maxVal;
    }

    @Override
    public String toString() {
        return "GoodTrend{" +
                "whichOne=" + whichOne +
                ", lastVal=" + lastVal +
                ", currVal=" + currVal +
                ", maxVal=" + maxVal +
                '}';
    }
}
