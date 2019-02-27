package com.pm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MyOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderPicidIsNull() {
            addCriterion("order_picid is null");
            return (Criteria) this;
        }

        public Criteria andOrderPicidIsNotNull() {
            addCriterion("order_picid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPicidEqualTo(Long value) {
            addCriterion("order_picid =", value, "orderPicid");
            return (Criteria) this;
        }

        public Criteria andOrderPicidNotEqualTo(Long value) {
            addCriterion("order_picid <>", value, "orderPicid");
            return (Criteria) this;
        }

        public Criteria andOrderPicidGreaterThan(Long value) {
            addCriterion("order_picid >", value, "orderPicid");
            return (Criteria) this;
        }

        public Criteria andOrderPicidGreaterThanOrEqualTo(Long value) {
            addCriterion("order_picid >=", value, "orderPicid");
            return (Criteria) this;
        }

        public Criteria andOrderPicidLessThan(Long value) {
            addCriterion("order_picid <", value, "orderPicid");
            return (Criteria) this;
        }

        public Criteria andOrderPicidLessThanOrEqualTo(Long value) {
            addCriterion("order_picid <=", value, "orderPicid");
            return (Criteria) this;
        }

        public Criteria andOrderPicidIn(List<Long> values) {
            addCriterion("order_picid in", values, "orderPicid");
            return (Criteria) this;
        }

        public Criteria andOrderPicidNotIn(List<Long> values) {
            addCriterion("order_picid not in", values, "orderPicid");
            return (Criteria) this;
        }

        public Criteria andOrderPicidBetween(Long value1, Long value2) {
            addCriterion("order_picid between", value1, value2, "orderPicid");
            return (Criteria) this;
        }

        public Criteria andOrderPicidNotBetween(Long value1, Long value2) {
            addCriterion("order_picid not between", value1, value2, "orderPicid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIsNull() {
            addCriterion("order_userid is null");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIsNotNull() {
            addCriterion("order_userid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUseridEqualTo(Long value) {
            addCriterion("order_userid =", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotEqualTo(Long value) {
            addCriterion("order_userid <>", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridGreaterThan(Long value) {
            addCriterion("order_userid >", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("order_userid >=", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridLessThan(Long value) {
            addCriterion("order_userid <", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridLessThanOrEqualTo(Long value) {
            addCriterion("order_userid <=", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIn(List<Long> values) {
            addCriterion("order_userid in", values, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotIn(List<Long> values) {
            addCriterion("order_userid not in", values, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridBetween(Long value1, Long value2) {
            addCriterion("order_userid between", value1, value2, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotBetween(Long value1, Long value2) {
            addCriterion("order_userid not between", value1, value2, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUploadIsNull() {
            addCriterion("order_upload is null");
            return (Criteria) this;
        }

        public Criteria andOrderUploadIsNotNull() {
            addCriterion("order_upload is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUploadEqualTo(Long value) {
            addCriterion("order_upload =", value, "orderUpload");
            return (Criteria) this;
        }

        public Criteria andOrderUploadNotEqualTo(Long value) {
            addCriterion("order_upload <>", value, "orderUpload");
            return (Criteria) this;
        }

        public Criteria andOrderUploadGreaterThan(Long value) {
            addCriterion("order_upload >", value, "orderUpload");
            return (Criteria) this;
        }

        public Criteria andOrderUploadGreaterThanOrEqualTo(Long value) {
            addCriterion("order_upload >=", value, "orderUpload");
            return (Criteria) this;
        }

        public Criteria andOrderUploadLessThan(Long value) {
            addCriterion("order_upload <", value, "orderUpload");
            return (Criteria) this;
        }

        public Criteria andOrderUploadLessThanOrEqualTo(Long value) {
            addCriterion("order_upload <=", value, "orderUpload");
            return (Criteria) this;
        }

        public Criteria andOrderUploadIn(List<Long> values) {
            addCriterion("order_upload in", values, "orderUpload");
            return (Criteria) this;
        }

        public Criteria andOrderUploadNotIn(List<Long> values) {
            addCriterion("order_upload not in", values, "orderUpload");
            return (Criteria) this;
        }

        public Criteria andOrderUploadBetween(Long value1, Long value2) {
            addCriterion("order_upload between", value1, value2, "orderUpload");
            return (Criteria) this;
        }

        public Criteria andOrderUploadNotBetween(Long value1, Long value2) {
            addCriterion("order_upload not between", value1, value2, "orderUpload");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameIsNull() {
            addCriterion("copyright_name is null");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameIsNotNull() {
            addCriterion("copyright_name is not null");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameEqualTo(String value) {
            addCriterion("copyright_name =", value, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameNotEqualTo(String value) {
            addCriterion("copyright_name <>", value, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameGreaterThan(String value) {
            addCriterion("copyright_name >", value, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameGreaterThanOrEqualTo(String value) {
            addCriterion("copyright_name >=", value, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameLessThan(String value) {
            addCriterion("copyright_name <", value, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameLessThanOrEqualTo(String value) {
            addCriterion("copyright_name <=", value, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameLike(String value) {
            addCriterion("copyright_name like", value, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameNotLike(String value) {
            addCriterion("copyright_name not like", value, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameIn(List<String> values) {
            addCriterion("copyright_name in", values, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameNotIn(List<String> values) {
            addCriterion("copyright_name not in", values, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameBetween(String value1, String value2) {
            addCriterion("copyright_name between", value1, value2, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNameNotBetween(String value1, String value2) {
            addCriterion("copyright_name not between", value1, value2, "copyrightName");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberIsNull() {
            addCriterion("copyright_number is null");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberIsNotNull() {
            addCriterion("copyright_number is not null");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberEqualTo(String value) {
            addCriterion("copyright_number =", value, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberNotEqualTo(String value) {
            addCriterion("copyright_number <>", value, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberGreaterThan(String value) {
            addCriterion("copyright_number >", value, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberGreaterThanOrEqualTo(String value) {
            addCriterion("copyright_number >=", value, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberLessThan(String value) {
            addCriterion("copyright_number <", value, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberLessThanOrEqualTo(String value) {
            addCriterion("copyright_number <=", value, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberLike(String value) {
            addCriterion("copyright_number like", value, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberNotLike(String value) {
            addCriterion("copyright_number not like", value, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberIn(List<String> values) {
            addCriterion("copyright_number in", values, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberNotIn(List<String> values) {
            addCriterion("copyright_number not in", values, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberBetween(String value1, String value2) {
            addCriterion("copyright_number between", value1, value2, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightNumberNotBetween(String value1, String value2) {
            addCriterion("copyright_number not between", value1, value2, "copyrightNumber");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneIsNull() {
            addCriterion("copyright_telephone is null");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneIsNotNull() {
            addCriterion("copyright_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneEqualTo(Long value) {
            addCriterion("copyright_telephone =", value, "copyrightTelephone");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneNotEqualTo(Long value) {
            addCriterion("copyright_telephone <>", value, "copyrightTelephone");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneGreaterThan(Long value) {
            addCriterion("copyright_telephone >", value, "copyrightTelephone");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneGreaterThanOrEqualTo(Long value) {
            addCriterion("copyright_telephone >=", value, "copyrightTelephone");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneLessThan(Long value) {
            addCriterion("copyright_telephone <", value, "copyrightTelephone");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneLessThanOrEqualTo(Long value) {
            addCriterion("copyright_telephone <=", value, "copyrightTelephone");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneIn(List<Long> values) {
            addCriterion("copyright_telephone in", values, "copyrightTelephone");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneNotIn(List<Long> values) {
            addCriterion("copyright_telephone not in", values, "copyrightTelephone");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneBetween(Long value1, Long value2) {
            addCriterion("copyright_telephone between", value1, value2, "copyrightTelephone");
            return (Criteria) this;
        }

        public Criteria andCopyrightTelephoneNotBetween(Long value1, Long value2) {
            addCriterion("copyright_telephone not between", value1, value2, "copyrightTelephone");
            return (Criteria) this;
        }

        public Criteria andApplicationIsNull() {
            addCriterion("application is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIsNotNull() {
            addCriterion("application is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationEqualTo(Integer value) {
            addCriterion("application =", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotEqualTo(Integer value) {
            addCriterion("application <>", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThan(Integer value) {
            addCriterion("application >", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThanOrEqualTo(Integer value) {
            addCriterion("application >=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThan(Integer value) {
            addCriterion("application <", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThanOrEqualTo(Integer value) {
            addCriterion("application <=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationIn(List<Integer> values) {
            addCriterion("application in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotIn(List<Integer> values) {
            addCriterion("application not in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationBetween(Integer value1, Integer value2) {
            addCriterion("application between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotBetween(Integer value1, Integer value2) {
            addCriterion("application not between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andCountryRangeIsNull() {
            addCriterion("country_range is null");
            return (Criteria) this;
        }

        public Criteria andCountryRangeIsNotNull() {
            addCriterion("country_range is not null");
            return (Criteria) this;
        }

        public Criteria andCountryRangeEqualTo(Integer value) {
            addCriterion("country_range =", value, "countryRange");
            return (Criteria) this;
        }

        public Criteria andCountryRangeNotEqualTo(Integer value) {
            addCriterion("country_range <>", value, "countryRange");
            return (Criteria) this;
        }

        public Criteria andCountryRangeGreaterThan(Integer value) {
            addCriterion("country_range >", value, "countryRange");
            return (Criteria) this;
        }

        public Criteria andCountryRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("country_range >=", value, "countryRange");
            return (Criteria) this;
        }

        public Criteria andCountryRangeLessThan(Integer value) {
            addCriterion("country_range <", value, "countryRange");
            return (Criteria) this;
        }

        public Criteria andCountryRangeLessThanOrEqualTo(Integer value) {
            addCriterion("country_range <=", value, "countryRange");
            return (Criteria) this;
        }

        public Criteria andCountryRangeIn(List<Integer> values) {
            addCriterion("country_range in", values, "countryRange");
            return (Criteria) this;
        }

        public Criteria andCountryRangeNotIn(List<Integer> values) {
            addCriterion("country_range not in", values, "countryRange");
            return (Criteria) this;
        }

        public Criteria andCountryRangeBetween(Integer value1, Integer value2) {
            addCriterion("country_range between", value1, value2, "countryRange");
            return (Criteria) this;
        }

        public Criteria andCountryRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("country_range not between", value1, value2, "countryRange");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPayAccountIsNull() {
            addCriterion("pay_account is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountIsNotNull() {
            addCriterion("pay_account is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountEqualTo(String value) {
            addCriterion("pay_account =", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotEqualTo(String value) {
            addCriterion("pay_account <>", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountGreaterThan(String value) {
            addCriterion("pay_account >", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("pay_account >=", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLessThan(String value) {
            addCriterion("pay_account <", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLessThanOrEqualTo(String value) {
            addCriterion("pay_account <=", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLike(String value) {
            addCriterion("pay_account like", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotLike(String value) {
            addCriterion("pay_account not like", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountIn(List<String> values) {
            addCriterion("pay_account in", values, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotIn(List<String> values) {
            addCriterion("pay_account not in", values, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountBetween(String value1, String value2) {
            addCriterion("pay_account between", value1, value2, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotBetween(String value1, String value2) {
            addCriterion("pay_account not between", value1, value2, "payAccount");
            return (Criteria) this;
        }

        public Criteria andEmailBoxIsNull() {
            addCriterion("email_box is null");
            return (Criteria) this;
        }

        public Criteria andEmailBoxIsNotNull() {
            addCriterion("email_box is not null");
            return (Criteria) this;
        }

        public Criteria andEmailBoxEqualTo(String value) {
            addCriterion("email_box =", value, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailBoxNotEqualTo(String value) {
            addCriterion("email_box <>", value, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailBoxGreaterThan(String value) {
            addCriterion("email_box >", value, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailBoxGreaterThanOrEqualTo(String value) {
            addCriterion("email_box >=", value, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailBoxLessThan(String value) {
            addCriterion("email_box <", value, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailBoxLessThanOrEqualTo(String value) {
            addCriterion("email_box <=", value, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailBoxLike(String value) {
            addCriterion("email_box like", value, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailBoxNotLike(String value) {
            addCriterion("email_box not like", value, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailBoxIn(List<String> values) {
            addCriterion("email_box in", values, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailBoxNotIn(List<String> values) {
            addCriterion("email_box not in", values, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailBoxBetween(String value1, String value2) {
            addCriterion("email_box between", value1, value2, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailBoxNotBetween(String value1, String value2) {
            addCriterion("email_box not between", value1, value2, "emailBox");
            return (Criteria) this;
        }

        public Criteria andEmailAdressIsNull() {
            addCriterion("email_adress is null");
            return (Criteria) this;
        }

        public Criteria andEmailAdressIsNotNull() {
            addCriterion("email_adress is not null");
            return (Criteria) this;
        }

        public Criteria andEmailAdressEqualTo(String value) {
            addCriterion("email_adress =", value, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andEmailAdressNotEqualTo(String value) {
            addCriterion("email_adress <>", value, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andEmailAdressGreaterThan(String value) {
            addCriterion("email_adress >", value, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andEmailAdressGreaterThanOrEqualTo(String value) {
            addCriterion("email_adress >=", value, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andEmailAdressLessThan(String value) {
            addCriterion("email_adress <", value, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andEmailAdressLessThanOrEqualTo(String value) {
            addCriterion("email_adress <=", value, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andEmailAdressLike(String value) {
            addCriterion("email_adress like", value, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andEmailAdressNotLike(String value) {
            addCriterion("email_adress not like", value, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andEmailAdressIn(List<String> values) {
            addCriterion("email_adress in", values, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andEmailAdressNotIn(List<String> values) {
            addCriterion("email_adress not in", values, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andEmailAdressBetween(String value1, String value2) {
            addCriterion("email_adress between", value1, value2, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andEmailAdressNotBetween(String value1, String value2) {
            addCriterion("email_adress not between", value1, value2, "emailAdress");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNull() {
            addCriterion("pay_state is null");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNotNull() {
            addCriterion("pay_state is not null");
            return (Criteria) this;
        }

        public Criteria andPayStateEqualTo(Integer value) {
            addCriterion("pay_state =", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotEqualTo(Integer value) {
            addCriterion("pay_state <>", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThan(Integer value) {
            addCriterion("pay_state >", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_state >=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThan(Integer value) {
            addCriterion("pay_state <", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThanOrEqualTo(Integer value) {
            addCriterion("pay_state <=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateIn(List<Integer> values) {
            addCriterion("pay_state in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotIn(List<Integer> values) {
            addCriterion("pay_state not in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateBetween(Integer value1, Integer value2) {
            addCriterion("pay_state between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_state not between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andContractStateIsNull() {
            addCriterion("contract_state is null");
            return (Criteria) this;
        }

        public Criteria andContractStateIsNotNull() {
            addCriterion("contract_state is not null");
            return (Criteria) this;
        }

        public Criteria andContractStateEqualTo(Integer value) {
            addCriterion("contract_state =", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateNotEqualTo(Integer value) {
            addCriterion("contract_state <>", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateGreaterThan(Integer value) {
            addCriterion("contract_state >", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_state >=", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateLessThan(Integer value) {
            addCriterion("contract_state <", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateLessThanOrEqualTo(Integer value) {
            addCriterion("contract_state <=", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateIn(List<Integer> values) {
            addCriterion("contract_state in", values, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateNotIn(List<Integer> values) {
            addCriterion("contract_state not in", values, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateBetween(Integer value1, Integer value2) {
            addCriterion("contract_state between", value1, value2, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_state not between", value1, value2, "contractState");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerIsNull() {
            addCriterion("copyright_owner is null");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerIsNotNull() {
            addCriterion("copyright_owner is not null");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerEqualTo(String value) {
            addCriterion("copyright_owner =", value, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerNotEqualTo(String value) {
            addCriterion("copyright_owner <>", value, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerGreaterThan(String value) {
            addCriterion("copyright_owner >", value, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("copyright_owner >=", value, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerLessThan(String value) {
            addCriterion("copyright_owner <", value, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerLessThanOrEqualTo(String value) {
            addCriterion("copyright_owner <=", value, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerLike(String value) {
            addCriterion("copyright_owner like", value, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerNotLike(String value) {
            addCriterion("copyright_owner not like", value, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerIn(List<String> values) {
            addCriterion("copyright_owner in", values, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerNotIn(List<String> values) {
            addCriterion("copyright_owner not in", values, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerBetween(String value1, String value2) {
            addCriterion("copyright_owner between", value1, value2, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andCopyrightOwnerNotBetween(String value1, String value2) {
            addCriterion("copyright_owner not between", value1, value2, "copyrightOwner");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberIsNull() {
            addCriterion("owner_number is null");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberIsNotNull() {
            addCriterion("owner_number is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberEqualTo(String value) {
            addCriterion("owner_number =", value, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberNotEqualTo(String value) {
            addCriterion("owner_number <>", value, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberGreaterThan(String value) {
            addCriterion("owner_number >", value, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberGreaterThanOrEqualTo(String value) {
            addCriterion("owner_number >=", value, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberLessThan(String value) {
            addCriterion("owner_number <", value, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberLessThanOrEqualTo(String value) {
            addCriterion("owner_number <=", value, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberLike(String value) {
            addCriterion("owner_number like", value, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberNotLike(String value) {
            addCriterion("owner_number not like", value, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberIn(List<String> values) {
            addCriterion("owner_number in", values, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberNotIn(List<String> values) {
            addCriterion("owner_number not in", values, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberBetween(String value1, String value2) {
            addCriterion("owner_number between", value1, value2, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andOwnerNumberNotBetween(String value1, String value2) {
            addCriterion("owner_number not between", value1, value2, "ownerNumber");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceIsNull() {
            addCriterion("company_price is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceIsNotNull() {
            addCriterion("company_price is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceEqualTo(Double value) {
            addCriterion("company_price =", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceNotEqualTo(Double value) {
            addCriterion("company_price <>", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceGreaterThan(Double value) {
            addCriterion("company_price >", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("company_price >=", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceLessThan(Double value) {
            addCriterion("company_price <", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceLessThanOrEqualTo(Double value) {
            addCriterion("company_price <=", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceIn(List<Double> values) {
            addCriterion("company_price in", values, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceNotIn(List<Double> values) {
            addCriterion("company_price not in", values, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceBetween(Double value1, Double value2) {
            addCriterion("company_price between", value1, value2, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceNotBetween(Double value1, Double value2) {
            addCriterion("company_price not between", value1, value2, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyStateIsNull() {
            addCriterion("company_state is null");
            return (Criteria) this;
        }

        public Criteria andCompanyStateIsNotNull() {
            addCriterion("company_state is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyStateEqualTo(Integer value) {
            addCriterion("company_state =", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateNotEqualTo(Integer value) {
            addCriterion("company_state <>", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateGreaterThan(Integer value) {
            addCriterion("company_state >", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_state >=", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateLessThan(Integer value) {
            addCriterion("company_state <", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateLessThanOrEqualTo(Integer value) {
            addCriterion("company_state <=", value, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateIn(List<Integer> values) {
            addCriterion("company_state in", values, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateNotIn(List<Integer> values) {
            addCriterion("company_state not in", values, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateBetween(Integer value1, Integer value2) {
            addCriterion("company_state between", value1, value2, "companyState");
            return (Criteria) this;
        }

        public Criteria andCompanyStateNotBetween(Integer value1, Integer value2) {
            addCriterion("company_state not between", value1, value2, "companyState");
            return (Criteria) this;
        }

        public Criteria andClientStateIsNull() {
            addCriterion("client_state is null");
            return (Criteria) this;
        }

        public Criteria andClientStateIsNotNull() {
            addCriterion("client_state is not null");
            return (Criteria) this;
        }

        public Criteria andClientStateEqualTo(Integer value) {
            addCriterion("client_state =", value, "clientState");
            return (Criteria) this;
        }

        public Criteria andClientStateNotEqualTo(Integer value) {
            addCriterion("client_state <>", value, "clientState");
            return (Criteria) this;
        }

        public Criteria andClientStateGreaterThan(Integer value) {
            addCriterion("client_state >", value, "clientState");
            return (Criteria) this;
        }

        public Criteria andClientStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("client_state >=", value, "clientState");
            return (Criteria) this;
        }

        public Criteria andClientStateLessThan(Integer value) {
            addCriterion("client_state <", value, "clientState");
            return (Criteria) this;
        }

        public Criteria andClientStateLessThanOrEqualTo(Integer value) {
            addCriterion("client_state <=", value, "clientState");
            return (Criteria) this;
        }

        public Criteria andClientStateIn(List<Integer> values) {
            addCriterion("client_state in", values, "clientState");
            return (Criteria) this;
        }

        public Criteria andClientStateNotIn(List<Integer> values) {
            addCriterion("client_state not in", values, "clientState");
            return (Criteria) this;
        }

        public Criteria andClientStateBetween(Integer value1, Integer value2) {
            addCriterion("client_state between", value1, value2, "clientState");
            return (Criteria) this;
        }

        public Criteria andClientStateNotBetween(Integer value1, Integer value2) {
            addCriterion("client_state not between", value1, value2, "clientState");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountIsNull() {
            addCriterion("company_account is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountIsNotNull() {
            addCriterion("company_account is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountEqualTo(String value) {
            addCriterion("company_account =", value, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountNotEqualTo(String value) {
            addCriterion("company_account <>", value, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountGreaterThan(String value) {
            addCriterion("company_account >", value, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountGreaterThanOrEqualTo(String value) {
            addCriterion("company_account >=", value, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountLessThan(String value) {
            addCriterion("company_account <", value, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountLessThanOrEqualTo(String value) {
            addCriterion("company_account <=", value, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountLike(String value) {
            addCriterion("company_account like", value, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountNotLike(String value) {
            addCriterion("company_account not like", value, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountIn(List<String> values) {
            addCriterion("company_account in", values, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountNotIn(List<String> values) {
            addCriterion("company_account not in", values, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountBetween(String value1, String value2) {
            addCriterion("company_account between", value1, value2, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyAccountNotBetween(String value1, String value2) {
            addCriterion("company_account not between", value1, value2, "companyAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountIsNull() {
            addCriterion("client_account is null");
            return (Criteria) this;
        }

        public Criteria andClientAccountIsNotNull() {
            addCriterion("client_account is not null");
            return (Criteria) this;
        }

        public Criteria andClientAccountEqualTo(String value) {
            addCriterion("client_account =", value, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountNotEqualTo(String value) {
            addCriterion("client_account <>", value, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountGreaterThan(String value) {
            addCriterion("client_account >", value, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountGreaterThanOrEqualTo(String value) {
            addCriterion("client_account >=", value, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountLessThan(String value) {
            addCriterion("client_account <", value, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountLessThanOrEqualTo(String value) {
            addCriterion("client_account <=", value, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountLike(String value) {
            addCriterion("client_account like", value, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountNotLike(String value) {
            addCriterion("client_account not like", value, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountIn(List<String> values) {
            addCriterion("client_account in", values, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountNotIn(List<String> values) {
            addCriterion("client_account not in", values, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountBetween(String value1, String value2) {
            addCriterion("client_account between", value1, value2, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andClientAccountNotBetween(String value1, String value2) {
            addCriterion("client_account not between", value1, value2, "clientAccount");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}