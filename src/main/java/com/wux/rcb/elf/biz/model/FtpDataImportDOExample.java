package com.wux.rcb.elf.biz.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FtpDataImportDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FtpDataImportDOExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andAcctTypeIsNull() {
            addCriterion("ACCT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIsNotNull() {
            addCriterion("ACCT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAcctTypeEqualTo(String value) {
            addCriterion("ACCT_TYPE =", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotEqualTo(String value) {
            addCriterion("ACCT_TYPE <>", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeGreaterThan(String value) {
            addCriterion("ACCT_TYPE >", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCT_TYPE >=", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLessThan(String value) {
            addCriterion("ACCT_TYPE <", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLessThanOrEqualTo(String value) {
            addCriterion("ACCT_TYPE <=", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLike(String value) {
            addCriterion("ACCT_TYPE like", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotLike(String value) {
            addCriterion("ACCT_TYPE not like", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIn(List<String> values) {
            addCriterion("ACCT_TYPE in", values, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotIn(List<String> values) {
            addCriterion("ACCT_TYPE not in", values, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeBetween(String value1, String value2) {
            addCriterion("ACCT_TYPE between", value1, value2, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotBetween(String value1, String value2) {
            addCriterion("ACCT_TYPE not between", value1, value2, "acctType");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNull() {
            addCriterion("ACCOUNT_NO is null");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNotNull() {
            addCriterion("ACCOUNT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNoEqualTo(String value) {
            addCriterion("ACCOUNT_NO =", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotEqualTo(String value) {
            addCriterion("ACCOUNT_NO <>", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThan(String value) {
            addCriterion("ACCOUNT_NO >", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NO >=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThan(String value) {
            addCriterion("ACCOUNT_NO <", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NO <=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLike(String value) {
            addCriterion("ACCOUNT_NO like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotLike(String value) {
            addCriterion("ACCOUNT_NO not like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoIn(List<String> values) {
            addCriterion("ACCOUNT_NO in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotIn(List<String> values) {
            addCriterion("ACCOUNT_NO not in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NO between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NO not between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdIsNull() {
            addCriterion("PRIM_CST_ID is null");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdIsNotNull() {
            addCriterion("PRIM_CST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdEqualTo(String value) {
            addCriterion("PRIM_CST_ID =", value, "primCstId");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdNotEqualTo(String value) {
            addCriterion("PRIM_CST_ID <>", value, "primCstId");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdGreaterThan(String value) {
            addCriterion("PRIM_CST_ID >", value, "primCstId");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRIM_CST_ID >=", value, "primCstId");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdLessThan(String value) {
            addCriterion("PRIM_CST_ID <", value, "primCstId");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdLessThanOrEqualTo(String value) {
            addCriterion("PRIM_CST_ID <=", value, "primCstId");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdLike(String value) {
            addCriterion("PRIM_CST_ID like", value, "primCstId");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdNotLike(String value) {
            addCriterion("PRIM_CST_ID not like", value, "primCstId");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdIn(List<String> values) {
            addCriterion("PRIM_CST_ID in", values, "primCstId");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdNotIn(List<String> values) {
            addCriterion("PRIM_CST_ID not in", values, "primCstId");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdBetween(String value1, String value2) {
            addCriterion("PRIM_CST_ID between", value1, value2, "primCstId");
            return (Criteria) this;
        }

        public Criteria andPrimCstIdNotBetween(String value1, String value2) {
            addCriterion("PRIM_CST_ID not between", value1, value2, "primCstId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdIsNull() {
            addCriterion("RPRG_OU_IP_ID is null");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdIsNotNull() {
            addCriterion("RPRG_OU_IP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdEqualTo(String value) {
            addCriterion("RPRG_OU_IP_ID =", value, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdNotEqualTo(String value) {
            addCriterion("RPRG_OU_IP_ID <>", value, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdGreaterThan(String value) {
            addCriterion("RPRG_OU_IP_ID >", value, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdGreaterThanOrEqualTo(String value) {
            addCriterion("RPRG_OU_IP_ID >=", value, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdLessThan(String value) {
            addCriterion("RPRG_OU_IP_ID <", value, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdLessThanOrEqualTo(String value) {
            addCriterion("RPRG_OU_IP_ID <=", value, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdLike(String value) {
            addCriterion("RPRG_OU_IP_ID like", value, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdNotLike(String value) {
            addCriterion("RPRG_OU_IP_ID not like", value, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdIn(List<String> values) {
            addCriterion("RPRG_OU_IP_ID in", values, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdNotIn(List<String> values) {
            addCriterion("RPRG_OU_IP_ID not in", values, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdBetween(String value1, String value2) {
            addCriterion("RPRG_OU_IP_ID between", value1, value2, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andRprgOuIpIdNotBetween(String value1, String value2) {
            addCriterion("RPRG_OU_IP_ID not between", value1, value2, "rprgOuIpId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNull() {
            addCriterion("MANAGER_ID is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNotNull() {
            addCriterion("MANAGER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdEqualTo(String value) {
            addCriterion("MANAGER_ID =", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotEqualTo(String value) {
            addCriterion("MANAGER_ID <>", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThan(String value) {
            addCriterion("MANAGER_ID >", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThanOrEqualTo(String value) {
            addCriterion("MANAGER_ID >=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThan(String value) {
            addCriterion("MANAGER_ID <", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThanOrEqualTo(String value) {
            addCriterion("MANAGER_ID <=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLike(String value) {
            addCriterion("MANAGER_ID like", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotLike(String value) {
            addCriterion("MANAGER_ID not like", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIn(List<String> values) {
            addCriterion("MANAGER_ID in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotIn(List<String> values) {
            addCriterion("MANAGER_ID not in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdBetween(String value1, String value2) {
            addCriterion("MANAGER_ID between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotBetween(String value1, String value2) {
            addCriterion("MANAGER_ID not between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andPaiRateIsNull() {
            addCriterion("PAI_RATE is null");
            return (Criteria) this;
        }

        public Criteria andPaiRateIsNotNull() {
            addCriterion("PAI_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andPaiRateEqualTo(Double value) {
            addCriterion("PAI_RATE =", value, "paiRate");
            return (Criteria) this;
        }

        public Criteria andPaiRateNotEqualTo(Double value) {
            addCriterion("PAI_RATE <>", value, "paiRate");
            return (Criteria) this;
        }

        public Criteria andPaiRateGreaterThan(Double value) {
            addCriterion("PAI_RATE >", value, "paiRate");
            return (Criteria) this;
        }

        public Criteria andPaiRateGreaterThanOrEqualTo(Double value) {
            addCriterion("PAI_RATE >=", value, "paiRate");
            return (Criteria) this;
        }

        public Criteria andPaiRateLessThan(Double value) {
            addCriterion("PAI_RATE <", value, "paiRate");
            return (Criteria) this;
        }

        public Criteria andPaiRateLessThanOrEqualTo(Double value) {
            addCriterion("PAI_RATE <=", value, "paiRate");
            return (Criteria) this;
        }

        public Criteria andPaiRateIn(List<Double> values) {
            addCriterion("PAI_RATE in", values, "paiRate");
            return (Criteria) this;
        }

        public Criteria andPaiRateNotIn(List<Double> values) {
            addCriterion("PAI_RATE not in", values, "paiRate");
            return (Criteria) this;
        }

        public Criteria andPaiRateBetween(Double value1, Double value2) {
            addCriterion("PAI_RATE between", value1, value2, "paiRate");
            return (Criteria) this;
        }

        public Criteria andPaiRateNotBetween(Double value1, Double value2) {
            addCriterion("PAI_RATE not between", value1, value2, "paiRate");
            return (Criteria) this;
        }

        public Criteria andStrDateIsNull() {
            addCriterion("STR_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStrDateIsNotNull() {
            addCriterion("STR_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStrDateEqualTo(Date value) {
            addCriterionForJDBCDate("STR_DATE =", value, "strDate");
            return (Criteria) this;
        }

        public Criteria andStrDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("STR_DATE <>", value, "strDate");
            return (Criteria) this;
        }

        public Criteria andStrDateGreaterThan(Date value) {
            addCriterionForJDBCDate("STR_DATE >", value, "strDate");
            return (Criteria) this;
        }

        public Criteria andStrDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STR_DATE >=", value, "strDate");
            return (Criteria) this;
        }

        public Criteria andStrDateLessThan(Date value) {
            addCriterionForJDBCDate("STR_DATE <", value, "strDate");
            return (Criteria) this;
        }

        public Criteria andStrDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STR_DATE <=", value, "strDate");
            return (Criteria) this;
        }

        public Criteria andStrDateIn(List<Date> values) {
            addCriterionForJDBCDate("STR_DATE in", values, "strDate");
            return (Criteria) this;
        }

        public Criteria andStrDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("STR_DATE not in", values, "strDate");
            return (Criteria) this;
        }

        public Criteria andStrDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STR_DATE between", value1, value2, "strDate");
            return (Criteria) this;
        }

        public Criteria andStrDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STR_DATE not between", value1, value2, "strDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_DATE not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andImportModeIsNull() {
            addCriterion("IMPORT_MODE is null");
            return (Criteria) this;
        }

        public Criteria andImportModeIsNotNull() {
            addCriterion("IMPORT_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andImportModeEqualTo(String value) {
            addCriterion("IMPORT_MODE =", value, "importMode");
            return (Criteria) this;
        }

        public Criteria andImportModeNotEqualTo(String value) {
            addCriterion("IMPORT_MODE <>", value, "importMode");
            return (Criteria) this;
        }

        public Criteria andImportModeGreaterThan(String value) {
            addCriterion("IMPORT_MODE >", value, "importMode");
            return (Criteria) this;
        }

        public Criteria andImportModeGreaterThanOrEqualTo(String value) {
            addCriterion("IMPORT_MODE >=", value, "importMode");
            return (Criteria) this;
        }

        public Criteria andImportModeLessThan(String value) {
            addCriterion("IMPORT_MODE <", value, "importMode");
            return (Criteria) this;
        }

        public Criteria andImportModeLessThanOrEqualTo(String value) {
            addCriterion("IMPORT_MODE <=", value, "importMode");
            return (Criteria) this;
        }

        public Criteria andImportModeLike(String value) {
            addCriterion("IMPORT_MODE like", value, "importMode");
            return (Criteria) this;
        }

        public Criteria andImportModeNotLike(String value) {
            addCriterion("IMPORT_MODE not like", value, "importMode");
            return (Criteria) this;
        }

        public Criteria andImportModeIn(List<String> values) {
            addCriterion("IMPORT_MODE in", values, "importMode");
            return (Criteria) this;
        }

        public Criteria andImportModeNotIn(List<String> values) {
            addCriterion("IMPORT_MODE not in", values, "importMode");
            return (Criteria) this;
        }

        public Criteria andImportModeBetween(String value1, String value2) {
            addCriterion("IMPORT_MODE between", value1, value2, "importMode");
            return (Criteria) this;
        }

        public Criteria andImportModeNotBetween(String value1, String value2) {
            addCriterion("IMPORT_MODE not between", value1, value2, "importMode");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNull() {
            addCriterion("DEAL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNotNull() {
            addCriterion("DEAL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDealStatusEqualTo(String value) {
            addCriterion("DEAL_STATUS =", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotEqualTo(String value) {
            addCriterion("DEAL_STATUS <>", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThan(String value) {
            addCriterion("DEAL_STATUS >", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL_STATUS >=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThan(String value) {
            addCriterion("DEAL_STATUS <", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThanOrEqualTo(String value) {
            addCriterion("DEAL_STATUS <=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLike(String value) {
            addCriterion("DEAL_STATUS like", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotLike(String value) {
            addCriterion("DEAL_STATUS not like", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusIn(List<String> values) {
            addCriterion("DEAL_STATUS in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotIn(List<String> values) {
            addCriterion("DEAL_STATUS not in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusBetween(String value1, String value2) {
            addCriterion("DEAL_STATUS between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotBetween(String value1, String value2) {
            addCriterion("DEAL_STATUS not between", value1, value2, "dealStatus");
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