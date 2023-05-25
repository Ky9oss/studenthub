package model;

import java.util.*;
import java.lang.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.json.JSONException;
import org.json.JSONObject;

import netscape.javascript.JSObject;

import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;

/**
 * The Calculater class provide algorithms for generating GPA
 * It contains three methods of different GPA algorithms
 * @author ZhengnanCao
 * @version 1.0
 */
public class Calculator {

    public Calculator() {
    }

    /**

     *Calculates the GPA of a student based on a standard grading system.
     *@param cont A JSON string containing the details of the student's courses.
     *@return The GPA of the student.
     */
    public double calculateByStandard(String cont) {
        double gpa = 0;

        double totalGradePoints = 0.0;
        int totalCredits = 0;

        JSONArray content = new JSONArray(cont);

        List<Course> courseList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(content);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Course course = new Course(jsonObject.getInt("grade"), jsonObject.getInt("credit"),
                    jsonObject.getString("type"));
            courseList.add(course);
        }

        for (Course course : courseList) {
            double grade = course.getGrade();
            int credit = course.getCredit();
            /*if (course.getType() != "type1") {
                grade = 0;
                credit = 0;
            }*/
            double gradeToGPA;
            if (grade >= 90.0) {
                gradeToGPA = 4.0;
            } else if (grade >= 80.0) {
                gradeToGPA = 3.0;
            } else if (grade >= 70.0) {
                gradeToGPA = 2.0;
            } else if (grade >= 60.0) {
                gradeToGPA = 1.0;
            } else {
                gradeToGPA = 0.0;
            }
            totalGradePoints += gradeToGPA * credit;
            totalCredits += credit;
        }

        gpa = totalGradePoints / totalCredits;
        gpa = Math.round(gpa * 100.0) / 100.0;

        return gpa;
        // 100～90 4.0
        // 89～80 3.0
        // 79～70 2.0
        // 69～60 1.0
        // 59～0 0 
    }

    /**
     * Calculates the GPA of a student based on the Beida 4.0 grading system.
     * @param content A JSON string containing the details of the student's courses.
     * @return The GPA of the student.
     */
    public double calculateByBeida4_0(String content) {
        double gpa = 0;

        double totalGradePoints = 0.0;
        int totalCredits = 0;

        List<Course> courseList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(content);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Course course = new Course(jsonObject.getInt("grade"), jsonObject.getInt("credit"),
                    jsonObject.getString("type"));
            courseList.add(course);
        }

        for (Course course : courseList) {
            double grade = course.getGrade();
            int credit = course.getCredit();
            /*if (course.getType() != "type1") {
                grade = 0;
                credit = 0;
            }*/
            double gradeToGPA;
            if (grade >= 90.0) {
                gradeToGPA = 4.0;
            } else if (grade >= 85.0) {
                gradeToGPA = 3.7;
            } else if (grade >= 82.0) {
                gradeToGPA = 3.3;
            } else if (grade >= 78.0) {
                gradeToGPA = 3.0;
            } else if (grade >= 75.0) {
                gradeToGPA = 2.7;
            } else if (grade >= 72.0) {
                gradeToGPA = 2.3;
            } else if (grade >= 68.0) {
                gradeToGPA = 2.0;
            } else if (grade >= 64.0) {
                gradeToGPA = 1.5;
            } else if (grade >= 60.0) {
                gradeToGPA = 1.0;
            } else {
                gradeToGPA = 0.0;
            }
            totalGradePoints += gradeToGPA * credit;
            totalCredits += credit;
        }

        gpa = totalGradePoints / totalCredits;
        gpa = Math.round(gpa * 100.0) / 100.0;

        return gpa;
    }

    /**
     * Calculates the World Education Services (WES) score of a student based on their grades.
     * @param content A JSON string containing the details of the student's courses.
     * @return The WES score of the student.
     */
    public double calculateByWorldEducationScore(String content) {
        double gpa = 0;

        double totalGradePoints = 0.0;
        int totalCredits = 0;

        List<Course> courseList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(content);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Course course = new Course(jsonObject.getInt("grade"), jsonObject.getInt("credit"),
                    jsonObject.getString("type"));
            courseList.add(course);
        }

        for (Course course : courseList) {
            double grade = course.getGrade();
            int credit = course.getCredit();

            double gradeToGPA;
            if (grade >= 85.0) {
                gradeToGPA = 4.0;
            } else if (grade >= 75.0) {
                gradeToGPA = 3.0;
            } else if (grade >= 60.0) {
                gradeToGPA = 2.0;
            } else {
                gradeToGPA = 1.0;
            }
            totalGradePoints += gradeToGPA * credit;
            totalCredits += credit;
        }

        gpa = totalGradePoints / totalCredits;
        gpa = Math.round(gpa * 100.0) / 100.0;

        return gpa;
        // 100～85 4.0, 84～75 3.0, 74～60 2.0, 59～0 1.0 所有type都纳入计算
    }

    class Course {
        private double grade;
        private int credits;
        private String type;

        /**

         *Constructs a new Course object with the given grade, credits and type.
         *@param score The grade received by the student in the course.
         *@param credits The number of credits earned for the course.
         *@param type The type of the course.
         */
        public Course(double score, int credits, String type) {
            this.type = type;
            this.grade = score;
            this.credits = credits;
        }

        /**

         *Gets the type of the course represented by this Course object.
         *@return The type of the course.
         */
        public String getType() {
            return type;
        }

        /**

         *Gets the grade of the course represented by this Course object.
         *@return The grade of the course.
         */
        public double getGrade() {
            return grade;
        }

        /**

         *Gets the credit of the course represented by this Course object.
         *@return The credit of the course.
         */
        public int getCredit() {
            return credits;
        }

    }
}