package com.coffee.jiahui.domain;

public class StudentScore {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_score.id
     *
     * @mbg.generated Sun Apr 14 17:21:34 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_score.chinese
     *
     * @mbg.generated Sun Apr 14 17:21:34 CST 2019
     */
    private Integer chinese;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_score.english
     *
     * @mbg.generated Sun Apr 14 17:21:34 CST 2019
     */
    private Integer english;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_score.id
     *
     * @return the value of student_score.id
     *
     * @mbg.generated Sun Apr 14 17:21:34 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_score.id
     *
     * @param id the value for student_score.id
     *
     * @mbg.generated Sun Apr 14 17:21:34 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_score.chinese
     *
     * @return the value of student_score.chinese
     *
     * @mbg.generated Sun Apr 14 17:21:34 CST 2019
     */
    public Integer getChinese() {
        return chinese;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_score.chinese
     *
     * @param chinese the value for student_score.chinese
     *
     * @mbg.generated Sun Apr 14 17:21:34 CST 2019
     */
    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_score.english
     *
     * @return the value of student_score.english
     *
     * @mbg.generated Sun Apr 14 17:21:34 CST 2019
     */
    public Integer getEnglish() {
        return english;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_score.english
     *
     * @param english the value for student_score.english
     *
     * @mbg.generated Sun Apr 14 17:21:34 CST 2019
     */
    public void setEnglish(Integer english) {
        this.english = english;
    }
}