package quizManagement;
import java.util.List;
public interface QuizOperations {
void addQuestion(Question question);
void updateQuestion(int questionId, Question question);
void deleteQuestion(int questionId);
Question viewQuestion(int questionId);
List<Question> viewAllQuestions();
}
