package com.pm.entity;

import java.util.ArrayList;
import java.util.List;

public class FileUpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FileUpExample() {
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

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFillePathbigIsNull() {
            addCriterion("fille_pathbig is null");
            return (Criteria) this;
        }

        public Criteria andFillePathbigIsNotNull() {
            addCriterion("fille_pathbig is not null");
            return (Criteria) this;
        }

        public Criteria andFillePathbigEqualTo(String value) {
            addCriterion("fille_pathbig =", value, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFillePathbigNotEqualTo(String value) {
            addCriterion("fille_pathbig <>", value, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFillePathbigGreaterThan(String value) {
            addCriterion("fille_pathbig >", value, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFillePathbigGreaterThanOrEqualTo(String value) {
            addCriterion("fille_pathbig >=", value, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFillePathbigLessThan(String value) {
            addCriterion("fille_pathbig <", value, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFillePathbigLessThanOrEqualTo(String value) {
            addCriterion("fille_pathbig <=", value, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFillePathbigLike(String value) {
            addCriterion("fille_pathbig like", value, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFillePathbigNotLike(String value) {
            addCriterion("fille_pathbig not like", value, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFillePathbigIn(List<String> values) {
            addCriterion("fille_pathbig in", values, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFillePathbigNotIn(List<String> values) {
            addCriterion("fille_pathbig not in", values, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFillePathbigBetween(String value1, String value2) {
            addCriterion("fille_pathbig between", value1, value2, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFillePathbigNotBetween(String value1, String value2) {
            addCriterion("fille_pathbig not between", value1, value2, "fillePathbig");
            return (Criteria) this;
        }

        public Criteria andFilePathmidIsNull() {
            addCriterion("file_pathmid is null");
            return (Criteria) this;
        }

        public Criteria andFilePathmidIsNotNull() {
            addCriterion("file_pathmid is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathmidEqualTo(String value) {
            addCriterion("file_pathmid =", value, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathmidNotEqualTo(String value) {
            addCriterion("file_pathmid <>", value, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathmidGreaterThan(String value) {
            addCriterion("file_pathmid >", value, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathmidGreaterThanOrEqualTo(String value) {
            addCriterion("file_pathmid >=", value, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathmidLessThan(String value) {
            addCriterion("file_pathmid <", value, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathmidLessThanOrEqualTo(String value) {
            addCriterion("file_pathmid <=", value, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathmidLike(String value) {
            addCriterion("file_pathmid like", value, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathmidNotLike(String value) {
            addCriterion("file_pathmid not like", value, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathmidIn(List<String> values) {
            addCriterion("file_pathmid in", values, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathmidNotIn(List<String> values) {
            addCriterion("file_pathmid not in", values, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathmidBetween(String value1, String value2) {
            addCriterion("file_pathmid between", value1, value2, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathmidNotBetween(String value1, String value2) {
            addCriterion("file_pathmid not between", value1, value2, "filePathmid");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallIsNull() {
            addCriterion("file_pathsmall is null");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallIsNotNull() {
            addCriterion("file_pathsmall is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallEqualTo(String value) {
            addCriterion("file_pathsmall =", value, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallNotEqualTo(String value) {
            addCriterion("file_pathsmall <>", value, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallGreaterThan(String value) {
            addCriterion("file_pathsmall >", value, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallGreaterThanOrEqualTo(String value) {
            addCriterion("file_pathsmall >=", value, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallLessThan(String value) {
            addCriterion("file_pathsmall <", value, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallLessThanOrEqualTo(String value) {
            addCriterion("file_pathsmall <=", value, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallLike(String value) {
            addCriterion("file_pathsmall like", value, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallNotLike(String value) {
            addCriterion("file_pathsmall not like", value, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallIn(List<String> values) {
            addCriterion("file_pathsmall in", values, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallNotIn(List<String> values) {
            addCriterion("file_pathsmall not in", values, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallBetween(String value1, String value2) {
            addCriterion("file_pathsmall between", value1, value2, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathsmallNotBetween(String value1, String value2) {
            addCriterion("file_pathsmall not between", value1, value2, "filePathsmall");
            return (Criteria) this;
        }

        public Criteria andFilePathshowIsNull() {
            addCriterion("file_pathshow is null");
            return (Criteria) this;
        }

        public Criteria andFilePathshowIsNotNull() {
            addCriterion("file_pathshow is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathshowEqualTo(String value) {
            addCriterion("file_pathshow =", value, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andFilePathshowNotEqualTo(String value) {
            addCriterion("file_pathshow <>", value, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andFilePathshowGreaterThan(String value) {
            addCriterion("file_pathshow >", value, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andFilePathshowGreaterThanOrEqualTo(String value) {
            addCriterion("file_pathshow >=", value, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andFilePathshowLessThan(String value) {
            addCriterion("file_pathshow <", value, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andFilePathshowLessThanOrEqualTo(String value) {
            addCriterion("file_pathshow <=", value, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andFilePathshowLike(String value) {
            addCriterion("file_pathshow like", value, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andFilePathshowNotLike(String value) {
            addCriterion("file_pathshow not like", value, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andFilePathshowIn(List<String> values) {
            addCriterion("file_pathshow in", values, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andFilePathshowNotIn(List<String> values) {
            addCriterion("file_pathshow not in", values, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andFilePathshowBetween(String value1, String value2) {
            addCriterion("file_pathshow between", value1, value2, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andFilePathshowNotBetween(String value1, String value2) {
            addCriterion("file_pathshow not between", value1, value2, "filePathshow");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andStateIdIsNull() {
            addCriterion("state_id is null");
            return (Criteria) this;
        }

        public Criteria andStateIdIsNotNull() {
            addCriterion("state_id is not null");
            return (Criteria) this;
        }

        public Criteria andStateIdEqualTo(Integer value) {
            addCriterion("state_id =", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdNotEqualTo(Integer value) {
            addCriterion("state_id <>", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdGreaterThan(Integer value) {
            addCriterion("state_id >", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("state_id >=", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdLessThan(Integer value) {
            addCriterion("state_id <", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdLessThanOrEqualTo(Integer value) {
            addCriterion("state_id <=", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdIn(List<Integer> values) {
            addCriterion("state_id in", values, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdNotIn(List<Integer> values) {
            addCriterion("state_id not in", values, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdBetween(Integer value1, Integer value2) {
            addCriterion("state_id between", value1, value2, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("state_id not between", value1, value2, "stateId");
            return (Criteria) this;
        }

        public Criteria andModeIsNull() {
            addCriterion("mode is null");
            return (Criteria) this;
        }

        public Criteria andModeIsNotNull() {
            addCriterion("mode is not null");
            return (Criteria) this;
        }

        public Criteria andModeEqualTo(Integer value) {
            addCriterion("mode =", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotEqualTo(Integer value) {
            addCriterion("mode <>", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThan(Integer value) {
            addCriterion("mode >", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mode >=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThan(Integer value) {
            addCriterion("mode <", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThanOrEqualTo(Integer value) {
            addCriterion("mode <=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeIn(List<Integer> values) {
            addCriterion("mode in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotIn(List<Integer> values) {
            addCriterion("mode not in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeBetween(Integer value1, Integer value2) {
            addCriterion("mode between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotBetween(Integer value1, Integer value2) {
            addCriterion("mode not between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andCameramanIsNull() {
            addCriterion("cameraman is null");
            return (Criteria) this;
        }

        public Criteria andCameramanIsNotNull() {
            addCriterion("cameraman is not null");
            return (Criteria) this;
        }

        public Criteria andCameramanEqualTo(String value) {
            addCriterion("cameraman =", value, "cameraman");
            return (Criteria) this;
        }

        public Criteria andCameramanNotEqualTo(String value) {
            addCriterion("cameraman <>", value, "cameraman");
            return (Criteria) this;
        }

        public Criteria andCameramanGreaterThan(String value) {
            addCriterion("cameraman >", value, "cameraman");
            return (Criteria) this;
        }

        public Criteria andCameramanGreaterThanOrEqualTo(String value) {
            addCriterion("cameraman >=", value, "cameraman");
            return (Criteria) this;
        }

        public Criteria andCameramanLessThan(String value) {
            addCriterion("cameraman <", value, "cameraman");
            return (Criteria) this;
        }

        public Criteria andCameramanLessThanOrEqualTo(String value) {
            addCriterion("cameraman <=", value, "cameraman");
            return (Criteria) this;
        }

        public Criteria andCameramanLike(String value) {
            addCriterion("cameraman like", value, "cameraman");
            return (Criteria) this;
        }

        public Criteria andCameramanNotLike(String value) {
            addCriterion("cameraman not like", value, "cameraman");
            return (Criteria) this;
        }

        public Criteria andCameramanIn(List<String> values) {
            addCriterion("cameraman in", values, "cameraman");
            return (Criteria) this;
        }

        public Criteria andCameramanNotIn(List<String> values) {
            addCriterion("cameraman not in", values, "cameraman");
            return (Criteria) this;
        }

        public Criteria andCameramanBetween(String value1, String value2) {
            addCriterion("cameraman between", value1, value2, "cameraman");
            return (Criteria) this;
        }

        public Criteria andCameramanNotBetween(String value1, String value2) {
            addCriterion("cameraman not between", value1, value2, "cameraman");
            return (Criteria) this;
        }

        public Criteria andPictureNameIsNull() {
            addCriterion("picture_name is null");
            return (Criteria) this;
        }

        public Criteria andPictureNameIsNotNull() {
            addCriterion("picture_name is not null");
            return (Criteria) this;
        }

        public Criteria andPictureNameEqualTo(String value) {
            addCriterion("picture_name =", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotEqualTo(String value) {
            addCriterion("picture_name <>", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameGreaterThan(String value) {
            addCriterion("picture_name >", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameGreaterThanOrEqualTo(String value) {
            addCriterion("picture_name >=", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameLessThan(String value) {
            addCriterion("picture_name <", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameLessThanOrEqualTo(String value) {
            addCriterion("picture_name <=", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameLike(String value) {
            addCriterion("picture_name like", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotLike(String value) {
            addCriterion("picture_name not like", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameIn(List<String> values) {
            addCriterion("picture_name in", values, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotIn(List<String> values) {
            addCriterion("picture_name not in", values, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameBetween(String value1, String value2) {
            addCriterion("picture_name between", value1, value2, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotBetween(String value1, String value2) {
            addCriterion("picture_name not between", value1, value2, "pictureName");
            return (Criteria) this;
        }

        public Criteria andIndexSlideIsNull() {
            addCriterion("index_slide is null");
            return (Criteria) this;
        }

        public Criteria andIndexSlideIsNotNull() {
            addCriterion("index_slide is not null");
            return (Criteria) this;
        }

        public Criteria andIndexSlideEqualTo(Integer value) {
            addCriterion("index_slide =", value, "indexSlide");
            return (Criteria) this;
        }

        public Criteria andIndexSlideNotEqualTo(Integer value) {
            addCriterion("index_slide <>", value, "indexSlide");
            return (Criteria) this;
        }

        public Criteria andIndexSlideGreaterThan(Integer value) {
            addCriterion("index_slide >", value, "indexSlide");
            return (Criteria) this;
        }

        public Criteria andIndexSlideGreaterThanOrEqualTo(Integer value) {
            addCriterion("index_slide >=", value, "indexSlide");
            return (Criteria) this;
        }

        public Criteria andIndexSlideLessThan(Integer value) {
            addCriterion("index_slide <", value, "indexSlide");
            return (Criteria) this;
        }

        public Criteria andIndexSlideLessThanOrEqualTo(Integer value) {
            addCriterion("index_slide <=", value, "indexSlide");
            return (Criteria) this;
        }

        public Criteria andIndexSlideIn(List<Integer> values) {
            addCriterion("index_slide in", values, "indexSlide");
            return (Criteria) this;
        }

        public Criteria andIndexSlideNotIn(List<Integer> values) {
            addCriterion("index_slide not in", values, "indexSlide");
            return (Criteria) this;
        }

        public Criteria andIndexSlideBetween(Integer value1, Integer value2) {
            addCriterion("index_slide between", value1, value2, "indexSlide");
            return (Criteria) this;
        }

        public Criteria andIndexSlideNotBetween(Integer value1, Integer value2) {
            addCriterion("index_slide not between", value1, value2, "indexSlide");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalIsNull() {
            addCriterion("index_animal is null");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalIsNotNull() {
            addCriterion("index_animal is not null");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalEqualTo(Integer value) {
            addCriterion("index_animal =", value, "indexAnimal");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalNotEqualTo(Integer value) {
            addCriterion("index_animal <>", value, "indexAnimal");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalGreaterThan(Integer value) {
            addCriterion("index_animal >", value, "indexAnimal");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalGreaterThanOrEqualTo(Integer value) {
            addCriterion("index_animal >=", value, "indexAnimal");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalLessThan(Integer value) {
            addCriterion("index_animal <", value, "indexAnimal");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalLessThanOrEqualTo(Integer value) {
            addCriterion("index_animal <=", value, "indexAnimal");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalIn(List<Integer> values) {
            addCriterion("index_animal in", values, "indexAnimal");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalNotIn(List<Integer> values) {
            addCriterion("index_animal not in", values, "indexAnimal");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalBetween(Integer value1, Integer value2) {
            addCriterion("index_animal between", value1, value2, "indexAnimal");
            return (Criteria) this;
        }

        public Criteria andIndexAnimalNotBetween(Integer value1, Integer value2) {
            addCriterion("index_animal not between", value1, value2, "indexAnimal");
            return (Criteria) this;
        }

        public Criteria andIndexPlantIsNull() {
            addCriterion("index_plant is null");
            return (Criteria) this;
        }

        public Criteria andIndexPlantIsNotNull() {
            addCriterion("index_plant is not null");
            return (Criteria) this;
        }

        public Criteria andIndexPlantEqualTo(Integer value) {
            addCriterion("index_plant =", value, "indexPlant");
            return (Criteria) this;
        }

        public Criteria andIndexPlantNotEqualTo(Integer value) {
            addCriterion("index_plant <>", value, "indexPlant");
            return (Criteria) this;
        }

        public Criteria andIndexPlantGreaterThan(Integer value) {
            addCriterion("index_plant >", value, "indexPlant");
            return (Criteria) this;
        }

        public Criteria andIndexPlantGreaterThanOrEqualTo(Integer value) {
            addCriterion("index_plant >=", value, "indexPlant");
            return (Criteria) this;
        }

        public Criteria andIndexPlantLessThan(Integer value) {
            addCriterion("index_plant <", value, "indexPlant");
            return (Criteria) this;
        }

        public Criteria andIndexPlantLessThanOrEqualTo(Integer value) {
            addCriterion("index_plant <=", value, "indexPlant");
            return (Criteria) this;
        }

        public Criteria andIndexPlantIn(List<Integer> values) {
            addCriterion("index_plant in", values, "indexPlant");
            return (Criteria) this;
        }

        public Criteria andIndexPlantNotIn(List<Integer> values) {
            addCriterion("index_plant not in", values, "indexPlant");
            return (Criteria) this;
        }

        public Criteria andIndexPlantBetween(Integer value1, Integer value2) {
            addCriterion("index_plant between", value1, value2, "indexPlant");
            return (Criteria) this;
        }

        public Criteria andIndexPlantNotBetween(Integer value1, Integer value2) {
            addCriterion("index_plant not between", value1, value2, "indexPlant");
            return (Criteria) this;
        }

        public Criteria andIndexScapeIsNull() {
            addCriterion("index_scape is null");
            return (Criteria) this;
        }

        public Criteria andIndexScapeIsNotNull() {
            addCriterion("index_scape is not null");
            return (Criteria) this;
        }

        public Criteria andIndexScapeEqualTo(Integer value) {
            addCriterion("index_scape =", value, "indexScape");
            return (Criteria) this;
        }

        public Criteria andIndexScapeNotEqualTo(Integer value) {
            addCriterion("index_scape <>", value, "indexScape");
            return (Criteria) this;
        }

        public Criteria andIndexScapeGreaterThan(Integer value) {
            addCriterion("index_scape >", value, "indexScape");
            return (Criteria) this;
        }

        public Criteria andIndexScapeGreaterThanOrEqualTo(Integer value) {
            addCriterion("index_scape >=", value, "indexScape");
            return (Criteria) this;
        }

        public Criteria andIndexScapeLessThan(Integer value) {
            addCriterion("index_scape <", value, "indexScape");
            return (Criteria) this;
        }

        public Criteria andIndexScapeLessThanOrEqualTo(Integer value) {
            addCriterion("index_scape <=", value, "indexScape");
            return (Criteria) this;
        }

        public Criteria andIndexScapeIn(List<Integer> values) {
            addCriterion("index_scape in", values, "indexScape");
            return (Criteria) this;
        }

        public Criteria andIndexScapeNotIn(List<Integer> values) {
            addCriterion("index_scape not in", values, "indexScape");
            return (Criteria) this;
        }

        public Criteria andIndexScapeBetween(Integer value1, Integer value2) {
            addCriterion("index_scape between", value1, value2, "indexScape");
            return (Criteria) this;
        }

        public Criteria andIndexScapeNotBetween(Integer value1, Integer value2) {
            addCriterion("index_scape not between", value1, value2, "indexScape");
            return (Criteria) this;
        }

        public Criteria andInstructionIsNull() {
            addCriterion("instruction is null");
            return (Criteria) this;
        }

        public Criteria andInstructionIsNotNull() {
            addCriterion("instruction is not null");
            return (Criteria) this;
        }

        public Criteria andInstructionEqualTo(String value) {
            addCriterion("instruction =", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionNotEqualTo(String value) {
            addCriterion("instruction <>", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionGreaterThan(String value) {
            addCriterion("instruction >", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionGreaterThanOrEqualTo(String value) {
            addCriterion("instruction >=", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionLessThan(String value) {
            addCriterion("instruction <", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionLessThanOrEqualTo(String value) {
            addCriterion("instruction <=", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionLike(String value) {
            addCriterion("instruction like", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionNotLike(String value) {
            addCriterion("instruction not like", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionIn(List<String> values) {
            addCriterion("instruction in", values, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionNotIn(List<String> values) {
            addCriterion("instruction not in", values, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionBetween(String value1, String value2) {
            addCriterion("instruction between", value1, value2, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionNotBetween(String value1, String value2) {
            addCriterion("instruction not between", value1, value2, "instruction");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
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

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(Integer value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(Integer value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(Integer value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(Integer value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(Integer value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<Integer> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<Integer> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(Integer value1, Integer value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(Integer value1, Integer value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andSpeciesIsNull() {
            addCriterion("species is null");
            return (Criteria) this;
        }

        public Criteria andSpeciesIsNotNull() {
            addCriterion("species is not null");
            return (Criteria) this;
        }

        public Criteria andSpeciesEqualTo(Integer value) {
            addCriterion("species =", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesNotEqualTo(Integer value) {
            addCriterion("species <>", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesGreaterThan(Integer value) {
            addCriterion("species >", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesGreaterThanOrEqualTo(Integer value) {
            addCriterion("species >=", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesLessThan(Integer value) {
            addCriterion("species <", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesLessThanOrEqualTo(Integer value) {
            addCriterion("species <=", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesIn(List<Integer> values) {
            addCriterion("species in", values, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesNotIn(List<Integer> values) {
            addCriterion("species not in", values, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesBetween(Integer value1, Integer value2) {
            addCriterion("species between", value1, value2, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesNotBetween(Integer value1, Integer value2) {
            addCriterion("species not between", value1, value2, "species");
            return (Criteria) this;
        }

        public Criteria andKeyoneIsNull() {
            addCriterion("keyone is null");
            return (Criteria) this;
        }

        public Criteria andKeyoneIsNotNull() {
            addCriterion("keyone is not null");
            return (Criteria) this;
        }

        public Criteria andKeyoneEqualTo(Long value) {
            addCriterion("keyone =", value, "keyone");
            return (Criteria) this;
        }

        public Criteria andKeyoneNotEqualTo(Long value) {
            addCriterion("keyone <>", value, "keyone");
            return (Criteria) this;
        }

        public Criteria andKeyoneGreaterThan(Long value) {
            addCriterion("keyone >", value, "keyone");
            return (Criteria) this;
        }

        public Criteria andKeyoneGreaterThanOrEqualTo(Long value) {
            addCriterion("keyone >=", value, "keyone");
            return (Criteria) this;
        }

        public Criteria andKeyoneLessThan(Long value) {
            addCriterion("keyone <", value, "keyone");
            return (Criteria) this;
        }

        public Criteria andKeyoneLessThanOrEqualTo(Long value) {
            addCriterion("keyone <=", value, "keyone");
            return (Criteria) this;
        }

        public Criteria andKeyoneIn(List<Long> values) {
            addCriterion("keyone in", values, "keyone");
            return (Criteria) this;
        }

        public Criteria andKeyoneNotIn(List<Long> values) {
            addCriterion("keyone not in", values, "keyone");
            return (Criteria) this;
        }

        public Criteria andKeyoneBetween(Long value1, Long value2) {
            addCriterion("keyone between", value1, value2, "keyone");
            return (Criteria) this;
        }

        public Criteria andKeyoneNotBetween(Long value1, Long value2) {
            addCriterion("keyone not between", value1, value2, "keyone");
            return (Criteria) this;
        }

        public Criteria andKeytwoIsNull() {
            addCriterion("keytwo is null");
            return (Criteria) this;
        }

        public Criteria andKeytwoIsNotNull() {
            addCriterion("keytwo is not null");
            return (Criteria) this;
        }

        public Criteria andKeytwoEqualTo(Long value) {
            addCriterion("keytwo =", value, "keytwo");
            return (Criteria) this;
        }

        public Criteria andKeytwoNotEqualTo(Long value) {
            addCriterion("keytwo <>", value, "keytwo");
            return (Criteria) this;
        }

        public Criteria andKeytwoGreaterThan(Long value) {
            addCriterion("keytwo >", value, "keytwo");
            return (Criteria) this;
        }

        public Criteria andKeytwoGreaterThanOrEqualTo(Long value) {
            addCriterion("keytwo >=", value, "keytwo");
            return (Criteria) this;
        }

        public Criteria andKeytwoLessThan(Long value) {
            addCriterion("keytwo <", value, "keytwo");
            return (Criteria) this;
        }

        public Criteria andKeytwoLessThanOrEqualTo(Long value) {
            addCriterion("keytwo <=", value, "keytwo");
            return (Criteria) this;
        }

        public Criteria andKeytwoIn(List<Long> values) {
            addCriterion("keytwo in", values, "keytwo");
            return (Criteria) this;
        }

        public Criteria andKeytwoNotIn(List<Long> values) {
            addCriterion("keytwo not in", values, "keytwo");
            return (Criteria) this;
        }

        public Criteria andKeytwoBetween(Long value1, Long value2) {
            addCriterion("keytwo between", value1, value2, "keytwo");
            return (Criteria) this;
        }

        public Criteria andKeytwoNotBetween(Long value1, Long value2) {
            addCriterion("keytwo not between", value1, value2, "keytwo");
            return (Criteria) this;
        }

        public Criteria andKeythreeIsNull() {
            addCriterion("keythree is null");
            return (Criteria) this;
        }

        public Criteria andKeythreeIsNotNull() {
            addCriterion("keythree is not null");
            return (Criteria) this;
        }

        public Criteria andKeythreeEqualTo(String value) {
            addCriterion("keythree =", value, "keythree");
            return (Criteria) this;
        }

        public Criteria andKeythreeNotEqualTo(String value) {
            addCriterion("keythree <>", value, "keythree");
            return (Criteria) this;
        }

        public Criteria andKeythreeGreaterThan(String value) {
            addCriterion("keythree >", value, "keythree");
            return (Criteria) this;
        }

        public Criteria andKeythreeGreaterThanOrEqualTo(String value) {
            addCriterion("keythree >=", value, "keythree");
            return (Criteria) this;
        }

        public Criteria andKeythreeLessThan(String value) {
            addCriterion("keythree <", value, "keythree");
            return (Criteria) this;
        }

        public Criteria andKeythreeLessThanOrEqualTo(String value) {
            addCriterion("keythree <=", value, "keythree");
            return (Criteria) this;
        }

        public Criteria andKeythreeLike(String value) {
            addCriterion("keythree like", value, "keythree");
            return (Criteria) this;
        }

        public Criteria andKeythreeNotLike(String value) {
            addCriterion("keythree not like", value, "keythree");
            return (Criteria) this;
        }

        public Criteria andKeythreeIn(List<String> values) {
            addCriterion("keythree in", values, "keythree");
            return (Criteria) this;
        }

        public Criteria andKeythreeNotIn(List<String> values) {
            addCriterion("keythree not in", values, "keythree");
            return (Criteria) this;
        }

        public Criteria andKeythreeBetween(String value1, String value2) {
            addCriterion("keythree between", value1, value2, "keythree");
            return (Criteria) this;
        }

        public Criteria andKeythreeNotBetween(String value1, String value2) {
            addCriterion("keythree not between", value1, value2, "keythree");
            return (Criteria) this;
        }

        public Criteria andIndexVideoIsNull() {
            addCriterion("index_video is null");
            return (Criteria) this;
        }

        public Criteria andIndexVideoIsNotNull() {
            addCriterion("index_video is not null");
            return (Criteria) this;
        }

        public Criteria andIndexVideoEqualTo(Integer value) {
            addCriterion("index_video =", value, "indexVideo");
            return (Criteria) this;
        }

        public Criteria andIndexVideoNotEqualTo(Integer value) {
            addCriterion("index_video <>", value, "indexVideo");
            return (Criteria) this;
        }

        public Criteria andIndexVideoGreaterThan(Integer value) {
            addCriterion("index_video >", value, "indexVideo");
            return (Criteria) this;
        }

        public Criteria andIndexVideoGreaterThanOrEqualTo(Integer value) {
            addCriterion("index_video >=", value, "indexVideo");
            return (Criteria) this;
        }

        public Criteria andIndexVideoLessThan(Integer value) {
            addCriterion("index_video <", value, "indexVideo");
            return (Criteria) this;
        }

        public Criteria andIndexVideoLessThanOrEqualTo(Integer value) {
            addCriterion("index_video <=", value, "indexVideo");
            return (Criteria) this;
        }

        public Criteria andIndexVideoIn(List<Integer> values) {
            addCriterion("index_video in", values, "indexVideo");
            return (Criteria) this;
        }

        public Criteria andIndexVideoNotIn(List<Integer> values) {
            addCriterion("index_video not in", values, "indexVideo");
            return (Criteria) this;
        }

        public Criteria andIndexVideoBetween(Integer value1, Integer value2) {
            addCriterion("index_video between", value1, value2, "indexVideo");
            return (Criteria) this;
        }

        public Criteria andIndexVideoNotBetween(Integer value1, Integer value2) {
            addCriterion("index_video not between", value1, value2, "indexVideo");
            return (Criteria) this;
        }

        public Criteria andPathPriceIsNull() {
            addCriterion("path_price is null");
            return (Criteria) this;
        }

        public Criteria andPathPriceIsNotNull() {
            addCriterion("path_price is not null");
            return (Criteria) this;
        }

        public Criteria andPathPriceEqualTo(Double value) {
            addCriterion("path_price =", value, "pathPrice");
            return (Criteria) this;
        }

        public Criteria andPathPriceNotEqualTo(Double value) {
            addCriterion("path_price <>", value, "pathPrice");
            return (Criteria) this;
        }

        public Criteria andPathPriceGreaterThan(Double value) {
            addCriterion("path_price >", value, "pathPrice");
            return (Criteria) this;
        }

        public Criteria andPathPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("path_price >=", value, "pathPrice");
            return (Criteria) this;
        }

        public Criteria andPathPriceLessThan(Double value) {
            addCriterion("path_price <", value, "pathPrice");
            return (Criteria) this;
        }

        public Criteria andPathPriceLessThanOrEqualTo(Double value) {
            addCriterion("path_price <=", value, "pathPrice");
            return (Criteria) this;
        }

        public Criteria andPathPriceIn(List<Double> values) {
            addCriterion("path_price in", values, "pathPrice");
            return (Criteria) this;
        }

        public Criteria andPathPriceNotIn(List<Double> values) {
            addCriterion("path_price not in", values, "pathPrice");
            return (Criteria) this;
        }

        public Criteria andPathPriceBetween(Double value1, Double value2) {
            addCriterion("path_price between", value1, value2, "pathPrice");
            return (Criteria) this;
        }

        public Criteria andPathPriceNotBetween(Double value1, Double value2) {
            addCriterion("path_price not between", value1, value2, "pathPrice");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceIsNull() {
            addCriterion("bigpath_price is null");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceIsNotNull() {
            addCriterion("bigpath_price is not null");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceEqualTo(Double value) {
            addCriterion("bigpath_price =", value, "bigpathPrice");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceNotEqualTo(Double value) {
            addCriterion("bigpath_price <>", value, "bigpathPrice");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceGreaterThan(Double value) {
            addCriterion("bigpath_price >", value, "bigpathPrice");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("bigpath_price >=", value, "bigpathPrice");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceLessThan(Double value) {
            addCriterion("bigpath_price <", value, "bigpathPrice");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceLessThanOrEqualTo(Double value) {
            addCriterion("bigpath_price <=", value, "bigpathPrice");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceIn(List<Double> values) {
            addCriterion("bigpath_price in", values, "bigpathPrice");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceNotIn(List<Double> values) {
            addCriterion("bigpath_price not in", values, "bigpathPrice");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceBetween(Double value1, Double value2) {
            addCriterion("bigpath_price between", value1, value2, "bigpathPrice");
            return (Criteria) this;
        }

        public Criteria andBigpathPriceNotBetween(Double value1, Double value2) {
            addCriterion("bigpath_price not between", value1, value2, "bigpathPrice");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceIsNull() {
            addCriterion("midpath_price is null");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceIsNotNull() {
            addCriterion("midpath_price is not null");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceEqualTo(Double value) {
            addCriterion("midpath_price =", value, "midpathPrice");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceNotEqualTo(Double value) {
            addCriterion("midpath_price <>", value, "midpathPrice");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceGreaterThan(Double value) {
            addCriterion("midpath_price >", value, "midpathPrice");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("midpath_price >=", value, "midpathPrice");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceLessThan(Double value) {
            addCriterion("midpath_price <", value, "midpathPrice");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceLessThanOrEqualTo(Double value) {
            addCriterion("midpath_price <=", value, "midpathPrice");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceIn(List<Double> values) {
            addCriterion("midpath_price in", values, "midpathPrice");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceNotIn(List<Double> values) {
            addCriterion("midpath_price not in", values, "midpathPrice");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceBetween(Double value1, Double value2) {
            addCriterion("midpath_price between", value1, value2, "midpathPrice");
            return (Criteria) this;
        }

        public Criteria andMidpathPriceNotBetween(Double value1, Double value2) {
            addCriterion("midpath_price not between", value1, value2, "midpathPrice");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceIsNull() {
            addCriterion("smallpath_price is null");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceIsNotNull() {
            addCriterion("smallpath_price is not null");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceEqualTo(Double value) {
            addCriterion("smallpath_price =", value, "smallpathPrice");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceNotEqualTo(Double value) {
            addCriterion("smallpath_price <>", value, "smallpathPrice");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceGreaterThan(Double value) {
            addCriterion("smallpath_price >", value, "smallpathPrice");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("smallpath_price >=", value, "smallpathPrice");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceLessThan(Double value) {
            addCriterion("smallpath_price <", value, "smallpathPrice");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceLessThanOrEqualTo(Double value) {
            addCriterion("smallpath_price <=", value, "smallpathPrice");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceIn(List<Double> values) {
            addCriterion("smallpath_price in", values, "smallpathPrice");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceNotIn(List<Double> values) {
            addCriterion("smallpath_price not in", values, "smallpathPrice");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceBetween(Double value1, Double value2) {
            addCriterion("smallpath_price between", value1, value2, "smallpathPrice");
            return (Criteria) this;
        }

        public Criteria andSmallpathPriceNotBetween(Double value1, Double value2) {
            addCriterion("smallpath_price not between", value1, value2, "smallpathPrice");
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