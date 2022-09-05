package zect.kotlinrestful.api.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import zect.kotlinrestful.api.model.*
import zect.kotlinrestful.api.service.ProductService

@RestController
class ProductController(val productService: ProductService ) {

    @PostMapping(
        value = ["/api/v1/products"],
        produces = ["application/json"],
        consumes = ["application/json" ]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/v1/products/{id_product}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("id_product") id: String): WebResponse<ProductResponse> {
        val productResponse = productService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @PutMapping(
        value = ["/api/v1/products/{id_product}"],
        produces = ["application/json"],
        consumes = ["application/json" ]
    )
    fun updateProduct(
        @PathVariable("id_product")id: String,
        @RequestBody updateProductRequest: UpdateProductRequest
    ): WebResponse<ProductResponse> {
        val productResponse = productService.update(id, updateProductRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @DeleteMapping(
        value = ["/api/v1/products/{id_product}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("id_product") id: String): WebResponse<String> {
        productService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/v1/products"],
        produces = ["application/json"]
    )
    fun listProducts(
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "page", defaultValue = "0 ") page: Int
    ): WebResponse<List<ProductResponse>> {
        val request = ListProductRequest(page = page, size = size)
        val responses = productService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }
}