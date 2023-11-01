package quizManagement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class QuizManagementSystem {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
List<User> users = new ArrayList<>();
Admin admin = new Admin(1, "admin", "adminpass");
Quiz quiz = new Quiz();
Question question1=new Question(1,"What is the capital of france?",Arrays.asList("paris","london","rome","berin"),0);
Question question2=new Question(2,"What is the captain of indian cricket team?",Arrays.asList("Virat kohli","M S Dhoni","Ricky ponting","RahulDravid"),0);
quiz.addQuestion(question1);
quiz.addQuestion(question2);
while (true) {
System.out.println();
System.out.println("Welcome To Online Quiz...");
System.out.println();
System.out.println("1. Register user");
System.out.println("2. Login user");
System.out.println("3. Admin login");
System.out.println("4. Exit");
System.out.print("Enter your choice: ");
int choice = scanner.nextInt();
switch (choice)
{
case 1:
System.out.print("Enter username: ");
String username = scanner.next();
System.out.print("Enter password: ");
String password = scanner.next();
User newUser = new User(users.size() + 1, username, password);
users.add(newUser);
System.out.println("User registered successfully!");
break;
case 2:
System.out.print("Enter username: ");
String loginUser = scanner.next();
System.out.print("Enter password: ");
String loginPassword = scanner.next();
User loggedInUser = null;
for (User user : users)
{
if (user.username.equals(loginUser) && user.password.equals(loginPassword)) {
loggedInUser = user;
break;
}
}
if (loggedInUser!= null)
{
quiz.startQuiz(loggedInUser);
loggedInUser.viewPerformance();
} else {
System.out.println("Invalid credentials. Please try again.");
}
break;
case 3:
System.out.print("Enter admin username: ");
String adminUsername = scanner.next();
System.out.print("Enter admin password: ");
String adminPassword = scanner.next();
if (admin.username.equals(adminUsername) &&
admin.password.equals(adminPassword))
{
System.out.println("Admin Login Successful....");
handleAdminMenu(admin, quiz, scanner);
} else {
System.out.println("Invalid admin credentials.");
}
break;
case 4:
System.out.println("Exiting the system...");
System.exit(0);
default:
System.out.println("Invalid choice. Please try again.");
}
}
}
private static void handleAdminMenu(Admin admin, Quiz quiz, Scanner scanner)
{
while (true)
{
System.out.println("\nAdmin Menu");
System.out.println("1. Add Question");
System.out.println("2. Update Question");
System.out.println("3. Delete Question");
System.out.println("4. View All Questions");
System.out.println("5. Logout");
System.out.print("Enter your choice: ");
int adminChoice = scanner.nextInt();
switch (adminChoice)
{
case 1:
System.out.print("Enter question text: ");
scanner.nextLine();
String questionText = scanner.nextLine();
List<String> options = new ArrayList<>();
for (int i = 1; i <= 4; i++) {
System.out.print("Enter option " + i + ": ");
options.add(scanner.nextLine());
}
System.out.print("Enter correct option index (1-4): ");
int correctOptionIndex = scanner.nextInt() - 1;
admin.addQuestion(quiz, questionText, options, correctOptionIndex);
break;
case 2:
System.out.print("Enter question ID to update: ");
int updateQuestionId = scanner.nextInt();
System.out.print("Enter updated question text: ");
scanner.nextLine();
String updatedQuestionText = scanner.nextLine();
List<String> updatedOptions = new ArrayList<>();
for (int i = 1; i <= 4; i++)
{
System.out.print("Enter updated option " + i + ": ");
updatedOptions.add(scanner.nextLine());
}
System.out.print("Enter updated correct option index (1-4): ");
int updatedCorrectOptionIndex = scanner.nextInt() - 1;
admin.updateQuestion(quiz, updateQuestionId, updatedQuestionText,
updatedOptions, updatedCorrectOptionIndex);
break;
case 3:

System.out.print("Enter question ID to delete: ");
int deleteQuestionId = scanner.nextInt();
admin.deleteQuestion(quiz, deleteQuestionId);
break;
case 4:
admin.viewAllQuestions(quiz);
break;
case 5:
return;
default:
System.out.println("Invalid choice. Please try again.");
}
}
}
}