# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Order APIs]
* (http://localhost:8080/order/placeOrder) POST (Place Order and this API will compute reward points)
* (http://localhost:8080/order/{orderId})  GET  (Get Order Details by Order Id)

* [Product APIs]
* (http://localhost:8080/product) POST (Add Product API)
* (http://localhost:8080/product/{id}) GET (Get Product by Product Id API)
* (http://localhost:8080/product/reduceQuantity/{id}) PUT (Reduce Product Quantity by Product Id and Quantity API)

* [Customer API]
* (http://localhost:8080/customer) POST (Add Customer API)

* [Reward API]
* (http://localhost:8080/reward/list) GET (List Reward Points of all customers with respect to given date range)
### Guides

The following guides illustrate how to use some features concretely:

* [Reward Points Computation Test Cases]
  
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

* [Developed By Bilal Ishaq, ishaq.bilal@gmail.com] 
* https://www.linkedin.com/in/bilalishaq/
