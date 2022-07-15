/*
 * package kr.co.tj;
 * 
 * class Student { public int studentId; public String studentName;
 * 
 * public Subject korea; public Subject math;
 * 
 * public Student() { korea = new Subject(); math = new Subject(); } public
 * Student(int id, String name) { studentId = id; studentName = name;
 * 
 * korea = new Subject(); math = new Subject(); }
 * 
 * public void setKoreaSubject(String name, int score) { korea.subjectName =
 * name; korea.score = score; }
 * 
 * public void setMathSubject(String name, int score) { math.subjectName = name;
 * math.score = score; }
 * 
 * public void showStudentScore() { int total = korea.score + math.score;
 * System.out.println(studentName + "학생의 총점은 " + total + "점입니다.");
 * System.out.println(korea.toString()); System.out.println(math.toString()); }
 * }
 * 
 * class Subject { public String subjectName; public int score; public int
 * subjectId;
 * 
 * public Subject() { }
 * 
 * public Subject(String subjectName, int score, int subjectId) {
 * this.subjectName = subjectName; this.score = score; this.subjectId =
 * subjectId; }
 * 
 * public String toString() { return subjectName + ":" + score + ":" +
 * subjectId; } }
 * 
 * public class StudentTest {
 * 
 * public static void main(String[] args) { Student studentLee = new
 * Student(100, "이순신"); studentLee.setKoreaSubject("국어", 100);
 * studentLee.setMathSubject("수학", 95);
 * 
 * Student studentKim = new Student(101, "김유신");
 * studentKim.setKoreaSubject("국어", 80); studentKim.setMathSubject("수학", 99);
 * 
 * studentLee.showStudentScore(); studentKim.showStudentScore();
 * 
 * } }
 */