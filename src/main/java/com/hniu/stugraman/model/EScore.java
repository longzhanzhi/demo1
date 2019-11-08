package com.hniu.stugraman.model;

import java.util.List;

/**
 * 考试成绩类
 * @author bojiangzhou
 *
 */
public class EScore {
	
	private int id; //ID

	private int score; //成绩

    private String courseName;// 科目名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "EScore{" +
                "id=" + id +
                ", score=" + score +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
