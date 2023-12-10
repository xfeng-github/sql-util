package org.xfeng.sqlutil;

import cn.hutool.core.util.StrUtil;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class TestMain {

    public static void main(String[] args) throws JSQLParserException {

        /*System.out.println(StrUtil.toCamelCase("a_a"));

        String sqlStr = "select a_a, b_b from temp001";
//        String sqlStr = "select 1 from dual where a=b";
        Statement statement = CCJSqlParserUtil.parse(sqlStr);

        System.out.println("statement: " + statement.toString());

        if (statement instanceof Select) {
            SelectBody selectBody = ((Select) statement).getSelectBody();
            List<SelectItem> selectItems = ((PlainSelect) selectBody).getSelectItems();
            for (SelectItem item : selectItems) {
                if (item instanceof SelectExpressionItem) {
                    Expression expression = ((SelectExpressionItem) item).getExpression();
                    if (expression instanceof Column) {
                        String columnName = ((Column) expression).getColumnName();
                        Alias alias = new Alias(StrUtil.toCamelCase(columnName));
                        ((SelectExpressionItem) item).setAlias(alias);
                    }
                }
            }
        }

        System.out.println(statement.toString());*/
//        SelectItem selectItem =
//                select.getSelectItems().get(0);
//        System.out.println(selectItem);
//
//        Table table = (Table) select.getFromItem();
//        System.out.println(table);
//
//        EqualsTo equalsTo = (EqualsTo) select.getWhere();
//        Column a = (Column) equalsTo.getLeftExpression();
//        Column b = (Column) equalsTo.getRightExpression();
//        System.out.println(a.getColumnName());
//        System.out.println(b.getColumnName());

        BigDecimal divide = new BigDecimal(123).divide(new BigDecimal(100));
        System.out.println(divide);


        System.out.println(new Random().nextInt());

    }


}
