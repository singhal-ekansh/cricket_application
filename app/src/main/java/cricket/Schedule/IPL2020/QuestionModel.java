package cricket.Schedule.IPL2020;

public class QuestionModel {
    String question_id;
    String question, option_one, option_two, option_three, answer;

    public QuestionModel(){

    }
    public QuestionModel(String question_id, String question, String option_one, String option_two, String option_three, String answer) {
        this.question_id = question_id;
        this.question = question;
        this.option_one = option_one;
        this.option_two = option_two;
        this.option_three = option_three;
        this.answer = answer;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption_one() {
        return option_one;
    }

    public void setOption_one(String option_one) {
        this.option_one = option_one;
    }

    public String getOption_two() {
        return option_two;
    }

    public void setOption_two(String option_two) {
        this.option_two = option_two;
    }

    public String getOption_three() {
        return option_three;
    }

    public void setOption_three(String option_three) {
        this.option_three = option_three;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
