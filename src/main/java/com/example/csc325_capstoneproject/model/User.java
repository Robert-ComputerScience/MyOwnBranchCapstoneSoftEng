package com.example.csc325_capstoneproject.model;

import java.util.LinkedList;
import java.util.List;

/**
 * A class which stores all the data for the User. The class contains the lists 
 * of tests for each of the subjects only allowing for 10 to be stored at a time.
 * @since 6/17/2025
 * @author Nathaniel Rivera
 */
public class User {

    /**
     * String that stores the username of the User
     */
    private String username;
    /**
     * String that stores the email of the User
     */
    private String email;
    /**
     * String that stores the first name of the User
     */
    private String firstName;
    /**
     * String that stores the last name of the User
     */
    private String lastName;
    /**
     * String that stores the password of the User
     */
    private String password;
    /**
     * Int that stores the grade level of the User
     */
    private int grade_level;
    /**
     * String that stores the UID of the User.
     */
    private String uid;

    /**
     * LinkedList that stores the previous 10 math tests taken by the User
     */
    private final LinkedList<Test> math_tests;
    /**
     * LinkedList that stores the previous 10 english tests taken by the User
     */
    private final LinkedList<Test> english_tests;
    /**
     * LinkedList that stores the previous 10 history tests taken by the User
     */
    private final LinkedList<Test> history_tests;
    /**
     * SLinkedList that stores the previous 10 science tests taken by the User
     */
    private final LinkedList<Test> science_tests;

    /**
     * Default constructor for the User class.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public User() {
        this.username = "";
        this.email = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        this.grade_level = 1;
        this.uid = "";
        this.math_tests = new LinkedList<>();;
        this.english_tests = new LinkedList<>();;
        this.history_tests = new LinkedList<>();;
        this.science_tests = new LinkedList<>();;
    }

    /**
     * Listless constructor for the User class, creates a User without established test grades.
     * @param username The username of the User.
     * @param email The email of the User.
     * @param firstName The first name of the User.
     * @param lastName The last name of the User.
     * @param password The password of the User.
     * @param grade_level The grade level of the User.
     * @param uid The UID of the User
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public User(String username, String email, String firstName, String lastName, String password, int grade_level, String uid) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.grade_level = grade_level;
        this.uid = uid;
        this.math_tests = new LinkedList<>();;
        this.english_tests = new LinkedList<>();;
        this.history_tests = new LinkedList<>();;
        this.science_tests = new LinkedList<>();;
    }

    /**
     * Parameterized constructor which creates a User with the data stored in Firebase.
     * @param username The username of the User.
     * @param email The email of the User.
     * @param uid The UID of the User
     * @since 6/27/2025
     * @author Nathaniel Rivera
     */
    public User(String username, String email, String uid) {
        this.username = username;
        this.email = email;
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        this.grade_level = 1;
        this.uid = uid;
        this.math_tests = new LinkedList<>();;
        this.english_tests = new LinkedList<>();;
        this.history_tests = new LinkedList<>();;
        this.science_tests = new LinkedList<>();;
    }

    /**
     * Listed constructor for the User class, creates a User with established test grades.
     * @param username The username of the User.
     * @param email The email of the User.
     * @param firstName The first name of the User.
     * @param lastName The last name of the User.
     * @param password The password of the User.
     * @param grade_level The grade level of the User.
     * @param uid The UID of the User
     * @param math_tests The List of the 10 previous math tests for the User.
     * @param english_tests The List of the 10 previous english tests for the User.
     * @param history_tests The List of the 10 previous history tests for the User.
     * @param science_tests The List of the 10 previous science tests for the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public User(String username, String email, String firstName, String lastName, String password, int grade_level, String uid, LinkedList<Test> math_tests, LinkedList<Test> english_tests, LinkedList<Test> history_tests, LinkedList<Test> science_tests) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.grade_level = grade_level;
        this.uid = uid;
        this.math_tests = math_tests;
        this.english_tests = english_tests;
        this.history_tests = history_tests;
        this.science_tests = science_tests;
    }

    /**
     * Getter method for Username.
     * @return the username of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for Username.
     * @param username The username of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method for Email.
     * @return the email of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for Email.
     * @param email The email of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for First Name.
     * @return the first name of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for First Name.
     * @param firstName The first name of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter method for Last Name.
     * @return the last name of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for Last Name.
     * @param lastName The last name of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter method for Password.
     * @return the password of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for Password.
     * @param password The password of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for Grade Level.
     * @return the grade level of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public int getGradeLevel() {
        return grade_level;
    }

    /**
     * Setter method for Grade Level.
     * @param grade_level The grade level of the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public void setGradeLevel(int grade_level) {
        this.grade_level = grade_level;
    }

    /**
     * Getter method for UID.
     * @return the UID of the User.
     * @since 6/27/2025
     * @author Nathaniel Rivera
     */
    public String getUID() {
        return uid;
    }

    /**
     * Setter method for UID.
     * @param uid The UID of the User.
     * @since 6/27/2025
     * @author Nathaniel Rivera
     */
    public void setUID(String uid) {
        this.uid = uid;
    }

    /**
     * Getter method for the list of Math Tests.
     * @return the list of math tests for the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public LinkedList<Test> getMathTests() {
        return this.math_tests;
    }

    /**
     * Adds a new test to the math test list. If there are more than
     * 10 tests it deletes the oldest test within the list.
     * @param test Test being added into the list.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public void addMathTests(Test test) {
        if(math_tests.size() != 10) {
            math_tests.add(test);
        } else {
            math_tests.poll();
        }
    }

    /**
     * Getter method for the list of English Tests.
     * @return the list of english tests for the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public List<Test> getEnglishTests() {
        return this.english_tests;
    }

    /**
     * Adds a new test to the english test list. If there are more than
     * 10 tests it deletes the oldest test within the list.
     * @param test Test being added into the list.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public void addEnglishTests(Test test) {
        if(english_tests.size() != 10) {
            english_tests.add(test);
        } else {
            english_tests.poll();
        }
    }

    /**
     * Getter method for the list of History Tests.
     * @return the list of history tests for the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public List<Test> getHistoryTests() {
        return this.history_tests;
    }

    /**
     * Adds a new test to the history test list. If there are more than
     * 10 tests it deletes the oldest test within the list.
     * @param test Test being added into the list.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public void addHistoryTests(Test test) {
        if(history_tests.size() != 10) {
            history_tests.add(test);
        } else {
            history_tests.poll();
        }
    }

    /**
     * Getter method for the list of Science Tests.
     * @return the list of science tests for the User.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public List<Test> getScienceTests() {
        return this.science_tests;
    }

    /**
     * Adds a new test to the science test list. If there are more than
     * 10 tests it deletes the oldest test within the list.
     * @param test Test being added into the list.
     * @since 6/17/2025
     * @author Nathaniel Rivera
     */
    public void addScienceTests(Test test) {
        if(science_tests.size() != 10) {
            science_tests.add(test);
        } else {
            science_tests.poll();
        }
    }
}   
