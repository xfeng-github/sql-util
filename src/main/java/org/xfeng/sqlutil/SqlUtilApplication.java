package org.xfeng.sqlutil;

import cn.hutool.core.util.StrUtil;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class SqlUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlUtilApplication.class, args);
    }


    @GetMapping("/sql/underlineAsHump")
    public String underlineAsHump(@RequestParam("sqlStr") String sqlStr) throws JSQLParserException {
        Statement statement = CCJSqlParserUtil.parse(sqlStr);
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
        return statement.toString();
    }
}
