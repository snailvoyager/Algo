package coding;

public class II220821C {
    /*
    SELECT *
    FROM (
        SELECT g.name,
            (SELECT COUNT(*) FROM test_cases c WHERE c.group_name = g.name) AS all_test_cases,
            (SELECT COUNT(*) FROM test_cases c WHERE c.group_name = g.name AND c.status = 'OK') AS passed_test_cases,
            (SELECT COUNT(*) FROM test_cases c WHERE c.group_name = g.name AND c.status = 'OK') * g.test_value AS total_value
        FROM test_groups g
    )
    ORDER BY total_value desc, name

     */
}
