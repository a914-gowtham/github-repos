package com.gowtham.datasource_test.cache
import com.gowtham.entities.Repository
//import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import org.junit.Assert.assertEquals
import org.junit.Test

class ItemDatabaseTest {

   /* private val inMemorySqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).apply {
        Database.Schema.create(this)
    }

    private val queries = Database(inMemorySqlDriver).githubQueries

    @Test
    fun smokeTest() {
        val emptyItems = queries.selectAll().executeAsList()
        assertEquals(emptyItems.size, 0)

        queries.insert(
            Repository(
               id = 1,
                name = "Repo one",
                fullName = "square/repo-one",
                ownerName = "square",
                description = "",
                avatar = "",
                language = "",
                starsCount = 26
            )
        )

        val items = queries.selectAll().executeAsList()
        assertEquals(items.size, 1)

        val repo = queries.selectRepoByName("Repo one").executeAsOneOrNull()
        assertEquals(repo?.fullName, "square/repo-one")
        assertEquals(repo?.starsCount?.toInt(), 26)
    }*/
}
