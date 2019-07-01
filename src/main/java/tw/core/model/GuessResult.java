package tw.core.model;

import tw.core.Answer;

/**
 * Created by jxzhong on 2017/5/18.
 */
public class GuessResult {
    private final Answer inputAnswer;
    private final String result;
    private final String instruction;

    public GuessResult(String result, Answer inputAnswer, String instruction) {
        this.result = result;
        this.inputAnswer = inputAnswer;
        this.instruction = instruction;
    }

    public String getResult() {
        return result;
    }

    public Answer getInputAnswer() {
        return inputAnswer;
    }

    public String getInstruction() {
        return instruction;
    }
}
