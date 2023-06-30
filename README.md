# online-sponsored-ads
This project is focused on developing a powerful module that empowers sellers to effortlessly create and manage promotional campaigns for their products.

The existing URL, http://localhost:8080, can be effortlessly changed to the following address: </br> https://online-sponsored-ads-production.up.railway.app. By doing this, you will gain access to the deployed server, allowing you to conveniently view its functionality.
</br> For example : </br> https://online-sponsored-ads-production.up.railway.app/products  


| APIs                  | METHOD | URL                                      | Parameters                                                                          | Expected result                                                               |
|-----------------------|--------|------------------------------------------|-------------------------------------------------------------------------------------|-------------------------------------------------------------------------------|   
| Create campaign       | POST   | http://localhost:8080/campaigns          | @RequestBody = campaignName::String & startDate::Date & bid:Double & products::LIST | a campaign is created.                                                        |
| Serve Ad              | GET    | http://localhost:8080/campaigns/serve-ad | @RequestParam = category::String                                                    | highest-bid promoted product from active campaigns in the specified category. |
| Get all the products  | GET    | http://localhost:8080/products           | null                                                                                | all the products from DB.                                                     |
| Get all the campaigns | GET    | http://localhost:8080/campaigns          | null                                                                                | all the campaigns from DB.                                                    |

-------------
# Examples:
### POST : http://localhost:8080/campaigns
#### RequestBody:
```json
{
  "campaignName":"Summer Sale",
  "startDate": "2023-07-05",
  "bid": 9999,
  "products":[
    {
      "productId":1
    },
    {
      "productId":2
    },
    {
      "productId":6
    },
    {
      "productId":8
    }

  ]
}
```
#### Result :
 ```json
 {
  "campaignId": 1,
  "campaignName": "Summer Sale",
  "startDate": "2023-07-05T00:00:00.000+00:00",
  "bid": 9999.0,
  "products": [
    {
      "productId": 1,
      "productName": "MacBook Pro",
      "productCategory": "Gaming",
      "productPrice": 1999.99
    },
    {
      "productId": 2,
      "productName": "Canon EOS 5D Mark IV",
      "productCategory": "Electronics",
      "productPrice": 2499.99
    },
    {
      "productId": 6,
      "productName": "Fitbit Charge 4",
      "productCategory": "Wearable Tech",
      "productPrice": 129.99
    },
    {
      "productId": 8,
      "productName": "Nintendo Switch",
      "productCategory": "Gaming",
      "productPrice": 299.99
    }
  ]
}
```
---------------------
### GET : http://localhost:8080/campaigns
#### Result : 
```json
[
  {
    "campaignId": 1,
    "campaignName": "Summer Sale",
    "startDate": "2023-07-05T00:00:00.000+00:00",
    "bid": 9999.0,
    "products": [
      {
        "productId": 2,
        "productName": "Canon EOS 5D Mark IV",
        "productCategory": "Electronics",
        "productPrice": 2499.99
      },
      {
        "productId": 6,
        "productName": "Fitbit Charge 4",
        "productCategory": "Wearable Tech",
        "productPrice": 129.99
      },
      {
        "productId": 8,
        "productName": "Nintendo Switch",
        "productCategory": "Gaming",
        "productPrice": 299.99
      },
      {
        "productId": 1,
        "productName": "MacBook Pro",
        "productCategory": "Gaming",
        "productPrice": 1999.99
      }
    ]
  },
  {
    "campaignId": 2,
    "campaignName": "Summer Vacation",
    "startDate": "2023-07-03T00:00:00.000+00:00",
    "bid": 200000.0,
    "products": [
      {
        "productId": 1,
        "productName": "MacBook Pro",
        "productCategory": "Gaming",
        "productPrice": 1999.99
      },
      {
        "productId": 4,
        "productName": "Samsung QLED Q90R",
        "productCategory": "Electronics",
        "productPrice": 1999.99
      }
    ]
  }
]
```
-------------------------
### GET : http://localhost:8080/campaigns/serve-ad?category=Electronics
#### Result :
```json
{
  "productId": 4,
  "productName": "Samsung QLED Q90R",
  "productCategory": "Electronics",
  "productPrice": 1999.99
}
```
---------
### GET : http://localhost:8080/products
#### Result :
```json
[
    {
        "productId": 1,
        "productName": "MacBook Pro",
        "productCategory": "Gaming",
        "productPrice": 1999.99
    },
    {
        "productId": 2,
        "productName": "Canon EOS 5D Mark IV",
        "productCategory": "Electronics",
        "productPrice": 2499.99
    },
    {
        "productId": 3,
        "productName": "Nike Air Max 270",
        "productCategory": "Footwear",
        "productPrice": 149.99
    },
    {
        "productId": 4,
        "productName": "Samsung QLED Q90R",
        "productCategory": "Electronics",
        "productPrice": 1999.99
    },
    {
        "productId": 5,
        "productName": "Amazon Echo Dot",
        "productCategory": "Smart Home",
        "productPrice": 49.99
    },
    {
        "productId": 6,
        "productName": "Fitbit Charge 4",
        "productCategory": "Wearable Tech",
        "productPrice": 129.99
    },
    {
        "productId": 7,
        "productName": "Dyson V11 Absolute",
        "productCategory": "Home Appliances",
        "productPrice": 599.99
    },
    {
        "productId": 8,
        "productName": "Nintendo Switch",
        "productCategory": "Gaming",
        "productPrice": 299.99
    },
    {
        "productId": 9,
        "productName": "Adidas Ultraboost",
        "productCategory": "Footwear",
        "productPrice": 179.99
    },
    {
        "productId": 10,
        "productName": "LG OLED CX Series",
        "productCategory": "Electronics",
        "productPrice": 2499.99
    },
    {
        "productId": 11,
        "productName": "Apple Watch Series 6",
        "productCategory": "Wearable Tech",
        "productPrice": 399.99
    },
    {
        "productId": 12,
        "productName": "Bose QuietComfort 35 II",
        "productCategory": "Audio",
        "productPrice": 349.99
    },
    {
        "productId": 13,
        "productName": "Sony WH-1000XM4",
        "productCategory": "Audio",
        "productPrice": 349.99
    }
]
```
--------

## APIs
### Create campaign - api for creating a campaign
-   Parameters:
    - name
    - startDate
    - List of product identifiers to promote.
    - Bid - the price seller is willing to pay for a click on a product advertised in this campaign.
-   Expected result: a campaign is created (with specified parameters) ready to promote all products.
- Response - a json representation of the created campaign.

### Serve Ad - api to retrieve ads
-   Parameters:
    - Category - a String representing category of products
    - Expected Result:
      - the api should return a single promoted product, the one with the highest bid,
        belonging to active campaign/s from the specified category. If there are no
        promoted product for the matching category simply return a promoted product
        with the highest bid.
      -    if more than one product is found, you may return the first.
      - The response should be in JSON format

## Entities
There are (at least) two main entities composing this module:
1. Product - simply represents a product with title, category, price and product-serial number (can
   be any int/string-sequence for the sake of this exercise)
2. Campaign - a group of products to promote(/advertise) with shared properties: start-date,
   bid. As well, the campaign has a name.
   a. Campaign is considered active for the 10 days following its start-date.
   b. Different campaigns may promote the same product
  
   
 
   