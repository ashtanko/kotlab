package dev.shtanko.algorithms.leetcode

object EmployeeImportance {

    private val employeeMap: MutableMap<Int, Employee> = hashMapOf()

    data class Employee(
        var id: Int = 0,
        var importance: Int = 0,
        var subordinates: List<Int> = listOf()
    )

    fun getImportance(employees: List<Employee?>, id: Int): Int {
        for (e in employees) {
            e?.let {
                employeeMap[it.id] = it
            }
        }
        return dfs(id)
    }

    private fun dfs(eid: Int): Int {
        val employee: Employee = employeeMap[eid] ?: return 0
        var ans = employee.importance
        for (subId in employee.subordinates) ans += dfs(subId)
        return ans
    }
}
