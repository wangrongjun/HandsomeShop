package com.handsome.shop.framework.hibernate;

import java.util.ArrayList;
import java.util.List;

/**
 * by wangrongjun on 2017/10/7.
 */
public class Where {

    /**
     * 查询条件的模式（相等，不相等，小于，小于等于，大于，大于等于，模糊查询）
     */
    public enum QueryMode {
        EQUAL,
        NOT_EQUAL,
        LESS,
        LESS_EQUAL,
        MORE,
        MORE_EQUAL,
        LIKE,
        NOT_LIKE
    }

    /**
     * 当前查询条件与下一个查询条件的逻辑（and,or）
     * 注意：若查询条件Equation为最后一个，则不存在下一个查询条件，也就没有所谓的逻辑，忽略该变量
     */
    public enum QueryLogic {
        AND,
        OR,
    }

    private List<Expression> expressionList;

    public Where() {
        expressionList = new ArrayList<>();
    }

    public int size() {
        return expressionList.size();
    }

    public Where equal(String name, String value) {
        expressionList.add(new Expression(name, value, QueryMode.EQUAL, QueryLogic.AND));
        return this;
    }

    public Where notEqual(String name, String value) {
        expressionList.add(new Expression(name, value, QueryMode.NOT_EQUAL, QueryLogic.AND));
        return this;
    }

    public Where less(String name, String value) {
        expressionList.add(new Expression(name, value, QueryMode.LESS, QueryLogic.AND));
        return this;
    }

    public Where lessEqual(String name, String value) {
        expressionList.add(new Expression(name, value, QueryMode.LESS_EQUAL, QueryLogic.AND));
        return this;
    }

    public Where more(String name, String value) {
        expressionList.add(new Expression(name, value, QueryMode.MORE, QueryLogic.AND));
        return this;
    }

    public Where moreEqual(String name, String value) {
        expressionList.add(new Expression(name, value, QueryMode.MORE_EQUAL, QueryLogic.AND));
        return this;
    }

    public Where like(String name, String value) {
        expressionList.add(new Expression(name, value, QueryMode.LIKE, QueryLogic.AND));
        return this;
    }

    public Where notLike(String name, String value) {
        expressionList.add(new Expression(name, value, QueryMode.NOT_LIKE, QueryLogic.AND));
        return this;
    }

    public Where and() {
        expressionList.get(size() - 1).queryLogic = QueryLogic.AND;
        return this;
    }

    public Where or() {
        expressionList.get(size() - 1).queryLogic = QueryLogic.OR;
        return this;
    }

    public static Where eq(String whereName, String whereValue) {
        return new Where().equal(whereName, whereValue);
    }

    public static Where eq(String whereName, int whereValue) {
        return new Where().equal(whereName, String.valueOf(whereValue));
    }

    public static Where eq(String whereName, long whereValue) {
        return new Where().equal(whereName, String.valueOf(whereValue));
    }

    /**
     * 返回 " where username='wang' and password='123' or gender='1' or nickname like '%abc%'"
     * 如果expressionList为空或长度为0，返回 ""
     */
    @Override
    public String toString() {
        if (size() == 0) {
            return "";
        }
        String sql = "";
        for (int i = 0; i < size(); i++) {
            Expression expression = expressionList.get(i);
            if (expression.value == null) {// username='null' 无意义，忽略
                continue;
            }
            // 1.字段名字
            sql += expression.name;
            // 2.查询模式
            switch (expression.queryMode) {
                case EQUAL:
                    sql += "=";
                    break;
                case NOT_EQUAL:
                    sql += "!=";
                    break;
                case LESS:
                    sql += "<";
                    break;
                case LESS_EQUAL:
                    sql += "<=";
                    break;
                case MORE:
                    sql += ">";
                    break;
                case MORE_EQUAL:
                    sql += ">=";
                    break;
                case LIKE:
                    sql += " like ";
                    break;
                case NOT_LIKE:
                    sql += " not like ";
                    break;
            }
            // 3.赋值
            // TODO 使用占位符（？）或定义参数
            sql += "'" + expression.value + "'";
            // 4.如果不是最后一个查询条件，添加查询逻辑
            if (i < size() - 1) {
                switch (expression.queryLogic) {
                    case AND:
                        sql += " and ";
                        break;
                    case OR:
                        sql += " or ";
                        break;
                }
            }
        }
        if (sql.length() > 0) {
            sql = " where " + sql;
        }
        return sql;
    }

    private class Expression {
        String name;
        String value;
        QueryMode queryMode;
        QueryLogic queryLogic;

        Expression(String name, String value, QueryMode queryMode,
                   QueryLogic queryLogic) {
            this.name = name;
            this.value = value;
            this.queryMode = queryMode;
            this.queryLogic = queryLogic;
        }
    }

}