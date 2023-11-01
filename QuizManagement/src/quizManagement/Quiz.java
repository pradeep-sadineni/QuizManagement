package quizManagement;
import java.util.ArrayList;
import java.util.List;
public class Quiz implements QuizOperations {
int quizId;
List<Question> questions = new ArrayList<>();
private int nextQuestionId = 3;
public int getNextQuestionId() {
return nextQuestionId++;
}
@Override
public void addQuestion(Question question) {
questions.add(question);
System.out.println("Question added successfully!");
}
@Override
public void updateQuestion(int questionId, Question question) {
questions.set(questionId - 1, question);
System.out.println("Question updated successfully!");
}
@Override
public void deleteQuestion(int questionId) {
questions.remove(questionId - 1);
System.out.println("Question deleted successfully!");
}
@Override
public Question viewQuestion(int questionId) {
return questions.get(questionId - 1);
}
@Override
public List<Question> viewAllQuestions() {
return questions;
}
public void startQuiz(User user) {
if (questions.isEmpty()) {
System.out.println("No questions available to start the quiz.");
return;
}
user.playQuiz(this);
}
}