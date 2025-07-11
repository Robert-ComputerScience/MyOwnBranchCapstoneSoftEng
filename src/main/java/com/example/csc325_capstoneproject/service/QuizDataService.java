package com.example.csc325_capstoneproject.service;



import com.example.csc325_capstoneproject.model.Question;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class QuizDataService {

    // Path to your local questions file in the resources folder
    private static final String QUESTIONS_FILE_PATH = "/com/example/examsjavacapstoneproj/questions.json";
    private final AIQuestionService aiService = new AIQuestionService();

    /**
     * Loads all questions from the local questions.json file.
     * @return A list of all questions from the file.
     */
    public List<Question> loadAllQuestions() {
        try {
            // Use getResourceAsStream to read a file from the resources folder
            InputStream inputStream = QuizDataService.class.getResourceAsStream(QUESTIONS_FILE_PATH);
            if (inputStream == null) {
                throw new RuntimeException("Cannot find resource file: " + QUESTIONS_FILE_PATH);
            }
            InputStreamReader reader = new InputStreamReader(inputStream);

            // Define the type for Gson to parse the JSON array into a List<Question>
            Type questionListType = new TypeToken<List<Question>>() {}.getType();

            // Parse the JSON and return the list
            return new Gson().fromJson(reader, questionListType);

        } catch (Exception e) {
            System.err.println("Error loading questions from JSON file.");
            e.printStackTrace();
            return Collections.emptyList(); // Return an empty list on error
        }
    }
hh
    /**
     * Generates a new test with 15 unique questions created by AI.
     * @return A list containing 15 new questions.
     */
    public List<Question> generateAITest() {
        try {
            // Call the AI service to generate 15 questions
            return aiService.generateJavaQuestions(15);
        } catch (IOException e) {
            System.err.println("Failed to generate questions using AI: " + e.getMessage());
            e.printStackTrace();
            // You could have a fallback here to load from a local file if the API fails
            return null;
        }
    }
}