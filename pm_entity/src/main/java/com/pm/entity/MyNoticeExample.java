package com.pm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MyNoticeExample() {
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

        public Criteria andNewTitleIsNull() {
            addCriterion("new_title is null");
            return (Criteria) this;
        }

        public Criteria andNewTitleIsNotNull() {
            addCriterion("new_title is not null");
            return (Criteria) this;
        }

        public Criteria andNewTitleEqualTo(String value) {
            addCriterion("new_title =", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleNotEqualTo(String value) {
            addCriterion("new_title <>", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleGreaterThan(String value) {
            addCriterion("new_title >", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleGreaterThanOrEqualTo(String value) {
            addCriterion("new_title >=", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleLessThan(String value) {
            addCriterion("new_title <", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleLessThanOrEqualTo(String value) {
            addCriterion("new_title <=", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleLike(String value) {
            addCriterion("new_title like", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleNotLike(String value) {
            addCriterion("new_title not like", value, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleIn(List<String> values) {
            addCriterion("new_title in", values, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleNotIn(List<String> values) {
            addCriterion("new_title not in", values, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleBetween(String value1, String value2) {
            addCriterion("new_title between", value1, value2, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewTitleNotBetween(String value1, String value2) {
            addCriterion("new_title not between", value1, value2, "newTitle");
            return (Criteria) this;
        }

        public Criteria andNewSourceIsNull() {
            addCriterion("new_source is null");
            return (Criteria) this;
        }

        public Criteria andNewSourceIsNotNull() {
            addCriterion("new_source is not null");
            return (Criteria) this;
        }

        public Criteria andNewSourceEqualTo(String value) {
            addCriterion("new_source =", value, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewSourceNotEqualTo(String value) {
            addCriterion("new_source <>", value, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewSourceGreaterThan(String value) {
            addCriterion("new_source >", value, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewSourceGreaterThanOrEqualTo(String value) {
            addCriterion("new_source >=", value, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewSourceLessThan(String value) {
            addCriterion("new_source <", value, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewSourceLessThanOrEqualTo(String value) {
            addCriterion("new_source <=", value, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewSourceLike(String value) {
            addCriterion("new_source like", value, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewSourceNotLike(String value) {
            addCriterion("new_source not like", value, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewSourceIn(List<String> values) {
            addCriterion("new_source in", values, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewSourceNotIn(List<String> values) {
            addCriterion("new_source not in", values, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewSourceBetween(String value1, String value2) {
            addCriterion("new_source between", value1, value2, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewSourceNotBetween(String value1, String value2) {
            addCriterion("new_source not between", value1, value2, "newSource");
            return (Criteria) this;
        }

        public Criteria andNewAuthorIsNull() {
            addCriterion("new_author is null");
            return (Criteria) this;
        }

        public Criteria andNewAuthorIsNotNull() {
            addCriterion("new_author is not null");
            return (Criteria) this;
        }

        public Criteria andNewAuthorEqualTo(String value) {
            addCriterion("new_author =", value, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewAuthorNotEqualTo(String value) {
            addCriterion("new_author <>", value, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewAuthorGreaterThan(String value) {
            addCriterion("new_author >", value, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("new_author >=", value, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewAuthorLessThan(String value) {
            addCriterion("new_author <", value, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewAuthorLessThanOrEqualTo(String value) {
            addCriterion("new_author <=", value, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewAuthorLike(String value) {
            addCriterion("new_author like", value, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewAuthorNotLike(String value) {
            addCriterion("new_author not like", value, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewAuthorIn(List<String> values) {
            addCriterion("new_author in", values, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewAuthorNotIn(List<String> values) {
            addCriterion("new_author not in", values, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewAuthorBetween(String value1, String value2) {
            addCriterion("new_author between", value1, value2, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewAuthorNotBetween(String value1, String value2) {
            addCriterion("new_author not between", value1, value2, "newAuthor");
            return (Criteria) this;
        }

        public Criteria andNewTimeIsNull() {
            addCriterion("new_time is null");
            return (Criteria) this;
        }

        public Criteria andNewTimeIsNotNull() {
            addCriterion("new_time is not null");
            return (Criteria) this;
        }

        public Criteria andNewTimeEqualTo(Date value) {
            addCriterion("new_time =", value, "newTime");
            return (Criteria) this;
        }

        public Criteria andNewTimeNotEqualTo(Date value) {
            addCriterion("new_time <>", value, "newTime");
            return (Criteria) this;
        }

        public Criteria andNewTimeGreaterThan(Date value) {
            addCriterion("new_time >", value, "newTime");
            return (Criteria) this;
        }

        public Criteria andNewTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("new_time >=", value, "newTime");
            return (Criteria) this;
        }

        public Criteria andNewTimeLessThan(Date value) {
            addCriterion("new_time <", value, "newTime");
            return (Criteria) this;
        }

        public Criteria andNewTimeLessThanOrEqualTo(Date value) {
            addCriterion("new_time <=", value, "newTime");
            return (Criteria) this;
        }

        public Criteria andNewTimeIn(List<Date> values) {
            addCriterion("new_time in", values, "newTime");
            return (Criteria) this;
        }

        public Criteria andNewTimeNotIn(List<Date> values) {
            addCriterion("new_time not in", values, "newTime");
            return (Criteria) this;
        }

        public Criteria andNewTimeBetween(Date value1, Date value2) {
            addCriterion("new_time between", value1, value2, "newTime");
            return (Criteria) this;
        }

        public Criteria andNewTimeNotBetween(Date value1, Date value2) {
            addCriterion("new_time not between", value1, value2, "newTime");
            return (Criteria) this;
        }

        public Criteria andNewRecordIsNull() {
            addCriterion("new_record is null");
            return (Criteria) this;
        }

        public Criteria andNewRecordIsNotNull() {
            addCriterion("new_record is not null");
            return (Criteria) this;
        }

        public Criteria andNewRecordEqualTo(Integer value) {
            addCriterion("new_record =", value, "newRecord");
            return (Criteria) this;
        }

        public Criteria andNewRecordNotEqualTo(Integer value) {
            addCriterion("new_record <>", value, "newRecord");
            return (Criteria) this;
        }

        public Criteria andNewRecordGreaterThan(Integer value) {
            addCriterion("new_record >", value, "newRecord");
            return (Criteria) this;
        }

        public Criteria andNewRecordGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_record >=", value, "newRecord");
            return (Criteria) this;
        }

        public Criteria andNewRecordLessThan(Integer value) {
            addCriterion("new_record <", value, "newRecord");
            return (Criteria) this;
        }

        public Criteria andNewRecordLessThanOrEqualTo(Integer value) {
            addCriterion("new_record <=", value, "newRecord");
            return (Criteria) this;
        }

        public Criteria andNewRecordIn(List<Integer> values) {
            addCriterion("new_record in", values, "newRecord");
            return (Criteria) this;
        }

        public Criteria andNewRecordNotIn(List<Integer> values) {
            addCriterion("new_record not in", values, "newRecord");
            return (Criteria) this;
        }

        public Criteria andNewRecordBetween(Integer value1, Integer value2) {
            addCriterion("new_record between", value1, value2, "newRecord");
            return (Criteria) this;
        }

        public Criteria andNewRecordNotBetween(Integer value1, Integer value2) {
            addCriterion("new_record not between", value1, value2, "newRecord");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentIsNull() {
            addCriterion("new_attachment is null");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentIsNotNull() {
            addCriterion("new_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentEqualTo(String value) {
            addCriterion("new_attachment =", value, "newAttachment");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentNotEqualTo(String value) {
            addCriterion("new_attachment <>", value, "newAttachment");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentGreaterThan(String value) {
            addCriterion("new_attachment >", value, "newAttachment");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("new_attachment >=", value, "newAttachment");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentLessThan(String value) {
            addCriterion("new_attachment <", value, "newAttachment");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentLessThanOrEqualTo(String value) {
            addCriterion("new_attachment <=", value, "newAttachment");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentLike(String value) {
            addCriterion("new_attachment like", value, "newAttachment");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentNotLike(String value) {
            addCriterion("new_attachment not like", value, "newAttachment");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentIn(List<String> values) {
            addCriterion("new_attachment in", values, "newAttachment");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentNotIn(List<String> values) {
            addCriterion("new_attachment not in", values, "newAttachment");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentBetween(String value1, String value2) {
            addCriterion("new_attachment between", value1, value2, "newAttachment");
            return (Criteria) this;
        }

        public Criteria andNewAttachmentNotBetween(String value1, String value2) {
            addCriterion("new_attachment not between", value1, value2, "newAttachment");
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