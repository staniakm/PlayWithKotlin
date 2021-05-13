import dsl.SqlQueryBuilder

fun main() {
//    https://www.baeldung.com/kotlin/dsl
    val query = query {
        select("column1", "column2")
        from("tableName")
        where {
            "column" eq "value"
            "column2" eq 123
        }
    }.build().print()

}


fun query(init: SqlQueryBuilder.() -> Unit): SqlQueryBuilder {
    return SqlQueryBuilder().apply(init)
}
