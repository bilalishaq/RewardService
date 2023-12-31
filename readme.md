# User Stories

* A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
* A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar
  spent over $50 in each transaction
* (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
* Given a record of every transaction during a three month period, calculate the reward points earned for each
  customer per month and total.

### Reference Documentation



For further reference, please consider the following sections:

# [Order APIs]
* (http://{BASE_URL}/order/placeOrder) POST (Place Order and this API will compute reward points)
* (http://{BASE_URL}/order/{orderId})  GET  (Get Order Details by Order Id)

# [Product APIs]
* (http://{BASE_URL}/product) POST (Add Product API)
* (http://{BASE_URL}/product/{id}) GET (Get Product by Product Id API)
* (http://{BASE_URL}/product/reduceQuantity/{id}) PUT (Reduce Product Quantity by Product Id and Quantity API)

# [Customer API]
* (http://{BASE_URL}/customer) POST (Add Customer API)

# [Reward API]
* (http://{BASE_URL}/reward/list) GET (List Reward Points of all customers with respect to given date range)

### Database Scripts Path 
* src/main/resources/scripts/Db-script.sql

### Swagger Path
* http://{BASE_URL}/swagger-ui/index.html

### Guides

The following guides illustrate how to use some features concretely:

# [Reward Points Computation Test Cases]
  
* Reward Points Computation Test Cases are given in Junit5 Test Class RewardServiceImplTest

*  void OneTwentyDollarPurchaseShouldCreateNinetyPoints()
*  void OneFiftyDollarPurchaseShouldCreateOneFiftyPoints()
*  void TwoHundredDollarPurchaseShouldCreateTwoFiftyPoints()
*  void OneThousandDollarPurchaseShouldCreateEighteenHundredFiftyPoints()
*  void OneHundredDollarPurchaseShouldCreateFiftyPoints()
*  void FiftyOneDollarPurchaseShouldCreateOnePoint()
*  void FiftyDollarPurchaseShouldCreateZeroPoint()
*  void TenDollarPurchaseShouldCreateZeroPoint()
*  void ZeroDollarPurchaseShouldCreateZeroPoint()
*  void NegativeDollarPurchaseShouldCreateIllegalArgumentException()

Developed By Bilal Ishaq, ishaq.bilal@gmail.com
* https://www.linkedin.com/in/bilalishaq/
