# online-sponsored-ads
This project is focused on developing a powerful module that empowers sellers to effortlessly create and manage promotional campaigns for their products.


| APIs            | METHOD | URL                                      | Parameters                                           | Expected result |
| ----------------|--------|------------------------------------------|------------------------------------------------------|-----------------|   
| Create campaign | POST   | http://localhost:8080/campaigns          | @RequestBody = campaignName<String> & products<LIST> |                 |
| Serve Ad        | GET    | http://localhost:8080/campaigns/serve-ad | @RequestParam = category                             |                 |

-------------
# Examples:
### POST : http://localhost:8080/campaigns
#### RequestBody:
```json
{
  "campaignName":"Valentine day",
  "products":[
    {
      "productId":1
    },
    {
      "productId":2
    }
  ]
}
```
#### Result :
 
---------------------
### GET : http://localhost:8080/campaigns
#### Result : 
```json
[
    {
        "campaignId": 1,
        "campaignName": "Black Friday",
        "products": []
    },
    {
        "campaignId": 2,
        "campaignName": "Summer Sales",
        "products": []
    },
    {
        "campaignId": 3,
        "campaignName": "Valentine day",
        "products": [
                      {
                        "productId": 1,
                        "productName": "ElectraWave Bluetooth Speaker"
                        },
                        {
                        "productId": 2,
                        "productName": "PowerPulse Wireless Charger"
                        }
                    ]
    }
]
```
-------------------------
http://localhost:8080/campaigns/serve-ad?category=Electronics
```json
{
"productId": 2,
"productName": "Canon EOS 5D Mark IV",
"productCategory": "Electronics",
"productPrice": 2499.99
}
```
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
  
   
 
   