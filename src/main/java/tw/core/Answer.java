package tw.core;

import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.model.Record;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Answer {

    private List<String> numList;

    public void setNumList(List<String> numList) {
        this.numList = numList;
    }

    public static Answer createAnswer(String inputStr) {
        Answer answer = new Answer();
        List<String> inputList = Arrays.stream(inputStr.split(" ")).collect(Collectors.toList());
        answer.setNumList(inputList);
        return answer;
    }


    public Record check(Answer inputAnswer) {
        Record record = new Record();
        this.numList.forEach(num -> {
            int index = inputAnswer.getIndexOfNum(num);
            if (index != -1) {
                if (index == getIndexOfNum(num)) {
                    record.increaseCurrentNum(num);
                } else {
                    record.increaseIncludeOnlyNum(num);
                }
            }
        });
        return record;
    }

    public int getIndexOfNum(String num) {
        return this.numList.indexOf(num);
    }

    @Override
    public String toString() {
        return String.join(" ", numList);
    }
}
