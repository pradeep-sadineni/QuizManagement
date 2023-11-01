package quizManagement;
import java.util.List;
import java.util.Scanner;
class User {
int userId;
String username;
String password;
int score;
public User(int userId,String username,String password) {
this.userId=userId;
this.username=username;
this.password=password;
}
public User() {
super();
// TODO Auto-generated constructor stub
}
public int getUserId() {
return userId;
}
public void setUserId(int userId) {
this.userId = userId;
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public int getScore() {
return score;
}
public void setScore(int score) {
this.score = score;
}
void playQuiz(Quiz quiz) {
@SuppressWarnings("resource")
Scanner scanner = new Scanner(System.in);
List<Question> questions = quiz.viewAllQuestions();
int totalQuestions = questions.size();
int correctAnswers = 0;
for (int i = 0; i < totalQuestions; i++) {
Question question = questions.get(i);
System.out.println("Question " + (i + 1) + ": " + question.questionText);
for (int j = 0; j < question.options.size(); j++) {
System.out.println((j + 1) + ". " + question.options.get(j));
}
System.out.print("Enter your choice (1-" + question.options.size() + "): ");
int userChoice = scanner.nextInt();
if (userChoice == question.correctOptionIndex + 1) {
System.out.println("Correct!");
correctAnswers++;
} else {
System.out.println("Incorrect.");
}
}
score = (int) ((double) correctAnswers / totalQuestions * 100);
System.out.println("Quiz completed. Your score: " + score + "%");
}
void viewPerformance() {
System.out.println("User: " + username);
System.out.println("Score: " + score + "%");
}
}
