package quizManagement;
import java.util.List;
public class Question {
int questionId;
String questionText;
List<String> options;
int correctOptionIndex;
public Question(int questionId, String questionText, List<String> options, int
correctOptionIndex) {
this.questionId = questionId;
this.questionText = questionText;
this.options = options;
this.correctOptionIndex = correctOptionIndex;
}
public int getQuestionId() {
return questionId;
}
public void setQuestionId(int questionId) {
this.questionId = questionId;
}
public String getQuestionText() {
return questionText;
}
public void setQuestionText(String questionText) {
this.questionText = questionText;
}
public List<String> getOptions() {
return options;
}
public void setOptions(List<String> options) {
this.options = options;
}
public int getCorrectOptionIndex() {
return correctOptionIndex;
}
public void setCorrectOptionIndex(int correctOptionIndex) {
this.correctOptionIndex = correctOptionIndex;
}
// Getter and setter methods for properties (if needed)
public void displayQuestion() {
System.out.println("Question: " + questionText);
for (int i = 0; i < options.size(); i++) {
System.out.println((i + 1) + ". " + options.get(i));
}
}
public void displayCorrectAnswer() {
System.out.println("Correct Answer: " + options.get(correctOptionIndex));
}
}