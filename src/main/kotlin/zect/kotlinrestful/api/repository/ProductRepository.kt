package zect.kotlinrestful.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import zect.kotlinrestful.api.entity.Product

interface ProductRepository : JpaRepository<Product, String> {
}