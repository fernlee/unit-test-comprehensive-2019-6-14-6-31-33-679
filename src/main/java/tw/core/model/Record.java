package tw.core.model;

import java.util.ArrayList;
import java.util.Objects;

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
        String result = "";
        if (value[0] == 0 && value[1] == 0) {
            return "all wrong";
        }
        if (value[1] == 4) {
            return "4 numbers position wrong";
        }
        if (correctNumList.size() != 0) {
            result = toString(correctNumList) + "correct";
        }
        if (includeOnlyNumList.size() != 0) {
            if (!Objects.equals(result, "")) {
                result += ", ";
            }
            result += toString(includeOnlyNumList) + "wrong position";
        }
        return result;
    }

    private String toString(ArrayList<String> list) {
        if (list.size() == 1) {
            return list.get(0) + " ";
        }
        StringBuilder str = new StringBuilder();
        for (String num : list) {
            str.append(num);
            if (!Objects.equals(list.get(list.size() - 1), num)) {
                str.append(" and ");
            } else {
                str.append(" ");
            }
        }
        return str.toString();
    }
}
