package com.asomepig.finance.model;

public class Muchmoney {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column muchmoney.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column muchmoney.spendDate
     *
     * @mbggenerated
     */
    private String spenddate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column muchmoney.inOrOut
     *
     * @mbggenerated
     */
    private Boolean inorout;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column muchmoney.whyIt
     *
     * @mbggenerated
     */
    private String whyit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column muchmoney.catId
     *
     * @mbggenerated
     */
    private Integer catid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column muchmoney.id
     *
     * @return the value of muchmoney.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column muchmoney.id
     *
     * @param id the value for muchmoney.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column muchmoney.spendDate
     *
     * @return the value of muchmoney.spendDate
     *
     * @mbggenerated
     */
    public String getSpenddate() {
        return spenddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column muchmoney.spendDate
     *
     * @param spenddate the value for muchmoney.spendDate
     *
     * @mbggenerated
     */
    public void setSpenddate(String spenddate) {
        this.spenddate = spenddate == null ? null : spenddate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column muchmoney.inOrOut
     *
     * @return the value of muchmoney.inOrOut
     *
     * @mbggenerated
     */
    public Boolean getInorout() {
        return inorout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column muchmoney.inOrOut
     *
     * @param inorout the value for muchmoney.inOrOut
     *
     * @mbggenerated
     */
    public void setInorout(Boolean inorout) {
        this.inorout = inorout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column muchmoney.whyIt
     *
     * @return the value of muchmoney.whyIt
     *
     * @mbggenerated
     */
    public String getWhyit() {
        return whyit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column muchmoney.whyIt
     *
     * @param whyit the value for muchmoney.whyIt
     *
     * @mbggenerated
     */
    public void setWhyit(String whyit) {
        this.whyit = whyit == null ? null : whyit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column muchmoney.catId
     *
     * @return the value of muchmoney.catId
     *
     * @mbggenerated
     */
    public Integer getCatid() {
        return catid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column muchmoney.catId
     *
     * @param catid the value for muchmoney.catId
     *
     * @mbggenerated
     */
    public void setCatid(Integer catid) {
        this.catid = catid;
    }
}