package dsl

class SqlQueryBuilder {

    private val columns: MutableList<String> = mutableListOf("*")
    private var table: String = ""
    private var condition: Condition? = null
    private val WHERE = " where "
    fun build(): String {
        return "select ${columns.joinToString(", ")} from $table ${if (condition!=null) {(WHERE + condition.toString())} else ""} "
    }

    fun select(vararg s: String) {
        this.columns.clear()
        if (s.isEmpty()) {
            columns.add("*")
        } else {
            columns.addAll(s)
        }
    }

    fun from(table: String) {
        this.table = table
    }

    fun where(function: Condition.() -> Unit) {
        condition = And().apply(function)
    }
}

abstract class Condition{
    infix fun String.eq(value: Any?) {
        addCondition(Eq(this, value))
    }

    abstract fun addCondition(condition: Condition)
}

class And : Condition() {

    private val conditions = mutableListOf<Condition>()

    override fun addCondition(condition: Condition) {
        conditions += condition
    }

    override fun toString(): String {
        return if (conditions.size == 1) {
            conditions.first().toString()
        } else {
            conditions.joinToString(prefix = "(", postfix = ")", separator = " and ")
        }
    }
}

class Eq(private val column: String, private val value: Any?) : Condition(){

    init {
        if (value != null && value !is Number && value !is String) {
            throw IllegalArgumentException(
                "Only <null>, numbers and strings values can be used in the 'where' clause")
        }
    }

    override fun addCondition(condition: Condition) {
        throw IllegalStateException("Can't add a nested condition to the sql 'eq'")
    }

    override fun toString(): String {
        return when (value) {
            null -> "$column is null"
            is String -> "$column = '$value'"
            else -> "$column = $value"
        }
    }
}
