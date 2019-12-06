package com.changedsac.Model;


public class QuestionScore {
    private String Question_Score;
    private String User;
    private String Score;
    private String CategoryId;
    private String CategoryName;


    public QuestionScore() {
    }

    public QuestionScore(String question_Score, String user, String score, String categoryId, String categoryName) {
        Question_Score = question_Score;
        User = user;
        Score = score;
        CategoryId = categoryId;
        CategoryName = categoryName;
    }

    public String getQuestion_Score() {
        return Question_Score;
    }

    public String getUser() {
        return User;
    }

    public String getScore() {
        return Score;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setQuestion_Score(String question_Score) {
        Question_Score = question_Score;
    }

    public void setUser(String user) {
        User = user;
    }

    public void setScore(String score) {
        Score = score;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
