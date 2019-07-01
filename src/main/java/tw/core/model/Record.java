package tw.core.model;

import java.util.ArrayList;

public class Record {
    private int[] value;
    private ArrayList<String> correctNumList;
    private ArrayList<String> includeOnlyNumList;

    public Record() {
        this.value = new int[]{0, 0};
        correctNumList = new ArrayList<>();
        includeOnlyNumList = new ArrayList<>();
    }

    public String getValue() {
        return String.format("%1$sA%2$sB", value[0], value[1]);
    }

    public void increaseCurrentNum(String correctNum) {
        correctNumList.add(correctNum);
        this.value[0]++;
    }

    public void increaseIncludeOnlyNum(String includeOnlyNum) {
        includeOnlyNumList.add(includeOnlyNum);
        this.value[1]++;
    }

    public String getInstruction() {
        if (correctNumList.size() != 0) {
            return correctNumList.get(0) + " correct";
        }
        return "";
    }
}
