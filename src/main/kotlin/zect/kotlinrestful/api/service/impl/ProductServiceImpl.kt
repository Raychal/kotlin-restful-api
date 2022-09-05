package zect.kotlinrestful.api.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import zect.kotlinrestful.api.entity.Product
import zect.kotlinrestful.api.error.NotFoundException
import zect.kotlinrestful.api.model.CreateProductRequest
import zect.kotlinrestful.api.model.ListProductRequest
import zect.kotlinrestful.api.model.ProductResponse
import zect.kotlinrestful.api.model.UpdateProductRequest
import zect.kotlinrestful.api.repository.ProductRepository
import zect.kotlinrestful.api.service.ProductService
import zect.kotlinrestful.api.validation.ValidationUtil
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
    ) : ProductService {
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest )
        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!! ,
            createdAt = Date(),
            updatedAt = null
        )
        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
        val product = productRepository.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        } else {
            return convertProductToProductResponse(product)
        }
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = productRepository.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        } else {

            validationUtil.validate(updateProductRequest)

             product.apply {
                 name = updateProductRequest.name!!
                 price = updateProductRequest.price!!
                 quantity = updateProductRequest.quantity!!
                 updatedAt = Date()
             }

            productRepository.save(product)
            
            return convertProductToProductResponse(product )
        }
    }

    override fun delete(id: String) {
        val product = findProductByIdOrThrowNotFound(id)
        productRepository.delete(product )
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products : List<Product> = page.get().collect(Collectors.toList())
        return products.map { convertProductToProductResponse(it) }
    }

    private fun findProductByIdOrThrowNotFound(id: String): Product {
        val product = productRepository.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        } else {
            return product
        }
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse {
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}