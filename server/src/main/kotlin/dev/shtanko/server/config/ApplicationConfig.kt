package dev.shtanko.server.config

import javax.persistence.Entity
import javax.persistence.EntityManagerFactory
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.http.HttpHeaders

@Configuration
@EnableCaching
open class ApplicationConfig(
    private val entityManagerFactory: EntityManagerFactory
) : RepositoryRestConfigurer {

    companion object {
        private const val MAX_AGE = 36000L
    }

    /**
     * Export all entity id.
     */
    override fun configureRepositoryRestConfiguration(restConfiguration: RepositoryRestConfiguration) {
        entityManagerFactory.metamodel.managedTypes
            .filter { managedType -> managedType.javaType.isAnnotationPresent(Entity::class.java) }
            .map { it.javaType }
            .forEach { restConfiguration.exposeIdsFor(it) }
        restConfiguration.exposureConfiguration
            .disablePutForCreation()
            .disablePutOnItemResources()
        restConfiguration.corsRegistry
            .addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "PATCH", "DELETE", "OPTIONS")
            .allowedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.ORIGIN)
            .allowCredentials(true)
            .maxAge(MAX_AGE)
    }
}
