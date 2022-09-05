package zect.kotlinrestful.api.service

import zect.kotlinrestful.api.model.CreateProductRequest
import zect.kotlinrestful.api.model.ListProductRequest
import zect.kotlinrestful.api.model.ProductResponse
import zect.kotlinrestful.api.model.UpdateProductRequest

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequest): List<ProductResponse >

}