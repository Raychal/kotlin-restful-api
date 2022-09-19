# API SPEC

## Authorization

Register

Request :
- Method : POST
- Endpoint : /api/v1/register
- Header : 
  - Content-Type: application/json 
  - Accept: application/json
- Body : 
```json
{
  "id" : "String, Unique",
  "username" : "String",
  "email" : "String",
  "hp" : "integer",
  "password" : "String"
}
```

- Response :
```json
{
  "code" : "number",
  "status" : "String"
}
```

Login

Request :
- Method : POST
- Endpoint : /api/v1/login
- Header :
  - Content-Type: application/json
  - Accept: application/json
- Body :
```json
{
  "email" : "String",
  "password" : "String"
}
```

- Response :
```json
{
  "code" : "number",
  "status" : "String",
  "data" : {
    "username" : "String",
    "email" : "String",
    "hp" : "integer",
    "password" : "String",
    "createdAt" : "date ",
    "updatedAt" : "date "
  }
}
```


## Authentication

All API must use this Authentication

Request :
- Header :
  - X-Api-Key : "your secret api key"

## Create Product

Request :
- Method : POST
- Endpoint : `/api/v1/products`
- Header :
    -  Content-Type: application/json
    -  Accept: application/json 
- Body :

```json
{
  "id" : "String, Unique",
  "barcode" : "String",
  "name_product" : "String",
  "category" : "String",
  "purchase_price" : "long",
  "selling_price" : "long",
  "quantity" : "integer" 
}
```

Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "String, Unique",
    "barcode" : "String",
    "name_product" : "String",
    "category" : "String",
    "purchase_price" : "long",
    "selling_price" : "long",
    "quantity" : "integer",
    "createdAt" : "date ",
    "updatedAt" : "date "  
  }
}
```

## Get Product

Request :
- Method : GET
- Endpoint : `/api/v1/products`
- Header :
    -  Accept: application/json 

Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id_user" : "String, Unique",
    "id_product" : "String, Unique",
    "barcode" : "String",
    "name_product" : "String",
    "category" : "String",
    "purchase_price" : "long",
    "selling_price" : "long",
    "quantity" : "integer",
    "createdAt" : "date ",
    "updatedAt" : "date "
  }
}
```

## Update Product

Request :
- Method : PUT
- Endpoint : `/api/v1/products`
- Header :
    -  Content-Type: application/json
    -  Accept: application/json
- Body :

```json
{
  "id_user" : "String, Unique",
  "id_product" : "String, Unique",
  "barcode" : "String",
  "name_product" : "String",
  "category" : "String",
  "purchase_price" : "long",
  "selling_price" : "long",
  "quantity" : "integer"
}
```

Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id_user" : "String, Unique",
    "id_product" : "String, Unique",
    "barcode" : "String",
    "name_product" : "String",
    "category" : "String",
    "purchase_price" : "long",
    "selling_price" : "long",
    "quantity" : "integer",
    "createdAt" : "date ",
    "updatedAt" : "date "
  }
}
```

## List Product

Request :
- Method : GET
- Endpoint : `/api/v1/products`
- Header :
    -  Accept: application/json
- Query Param  : 
  - size : number,
  - page : number

Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : [
    {
      "id_product" : "String, Unique",
      "barcode" : "String",
      "name_product" : "String",
      "category" : "String",
      "purchase_price" : "long",
      "selling_price" : "long",
      "quantity" : "integer",
      "createdAt" : "date ",
      "updatedAt" : "date "
    },
    {
      "id_product" : "String, Unique",
      "barcode" : "String",
      "name_product" : "String",
      "category" : "String",
      "purchase_price" : "long",
      "selling_price" : "long",
      "quantity" : "integer",
      "createdAt" : "date ",
      "updatedAt" : "date "
    },
    {
      "id_product" : "String, Unique",
      "barcode" : "String",
      "name_product" : "String",
      "category" : "String",
      "purchase_price" : "long",
      "selling_price" : "long",
      "quantity" : "integer",
      "createdAt" : "date ",
      "updatedAt" : "date "
    }  
  ]
}
```

## Delete Product

Request :
- Method : DELETE
- Endpoint : `/api/v1/products`
- Header :
    -  Accept: application/json
  
- Body :

```json
{
  "id_user" : "String, Unique",
  "id_product" : "String, Unique",
  "barcode" : "String",
  "name_product" : "String"
}
```

Response :
```json
{
  "code" : "number",
  "status" : "string" 
}
```

## Cart

Request :
- Method : POST
- Endpoint : `/api/v1/cart`
- Header :
  -  Accept: application/json

- Body :

```json
{
  "id_user" : "String, Unique",
  "status" : "String"
}
```

Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : [
    {
      "id_cart" : "String",
      "id_user" : "String",
      "quantity" : "integer",
      "total_price" : "Long",
      "status" : "String",
      "createdAt" : "date",
      "sale" : [] 
    }
  ]
}
```

## Search Product

Request :
- Method : GET
- Endpoint : `/api/v1/search`
- Header :
  -  Accept: application/json

- Body :

```json
{
  "id_user" : "String, Unique",
  "keyword" : "String"
}
```

Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : [
    {
      "id_cart" : "String",
      "id_user" : "String",
      "quantity" : "integer",
      "total_price" : "Long",
      "status" : "String",
      "createdAt" : "date",
      "sale" : [] 
    }
  ]
}
```

## Add Item To Cart

Request :
- Method : POST
- Endpoint : `/api/v1/cart`
- Header :
  -  Accept: application/json

- Body :

```json
{
  "id_cart" : "String",
  "id_user" : "String",
  "id_product" : "String",
  "name_product" : "String",
  "quantity" : "integer",
  "total_price" : "Long",
  "status" : "String",
  "createdAt" : "date"
}
```

Response :
```json
{
  "code" : "number",
  "status" : "string"
}
```

## Delete Item From Cart

Request :
- Method : DELETE
- Endpoint : `/api/v1/cart`
- Header :
  -  Accept: application/json

- Body :

```json
{
  "id_cart" : "String",
  "id_user" : "String",
  "id_product" : "String",
  "id_sale" : "String"
}
```

Response :
```json
{
  "code" : "number",
  "status" : "string"
}
```

## Sell Goods

Request :
- Method : POST
- Endpoint : `/api/v1/sell`
- Header :
  -  Accept: application/json

- Body :

```json
{
  "id_user" : "String",
  "id_product" : "String",
  "status" : "String",
  "quantity" : "integer",
  "total_price" : "Long"
}
```

Response :
```json
{
  "code" : "number",
  "status" : "string"
}
```

## Report

Request :
- Method : GET
- Endpoint : `/api/v1/report/{id_user}`
- Header :
  -  Accept: application/json
- Query Param  :
  - size : number,
  - page : number,
  - status : string

Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : [
    {
      "id_user" : "String",
      "id_cart" : "String",
      "status" : "String",
      "quantity" : "integer",
      "total_price" : "Long",
      "createdAt" : "date"
    },
    {
      "id_user" : "String",
      "id_cart" : "String",
      "status" : "String",
      "quantity" : "integer",
      "total_price" : "Long",
      "createdAt" : "date"
    },
    {
      "id_user" : "String",
      "id_cart" : "String",
      "status" : "String",
      "quantity" : "integer",
      "total_price" : "Long",
      "createdAt" : "date"
    }  
  ]
}
```