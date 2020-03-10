
--

    mvn clean verify package
    docker build -f Dockerfile -t ltgo/load-management-service .
    docker run -d -p 9595:9595 -e ENV=local ltgo/load-management-service
--

    query {
      findAllLocations {
        id
        city
        state
      }
      findAllOrders {
        loadId
        id
        pickUpDateTime
        deliveryDateTime
        pickUpStop {
          city
          state
          zipCode
        }
        deliveryStop{
          city
          state
          zipCode
        }
      }
      findAllLoads{
        stops
        origin {
          city
          state
          zipCode
        }
        destination {
          city
          state
          zipCode
        }
        equipmentType
        hazmat
        weight
        ltl
        miles
      }
    }
--
    
    mutation newLocation($city: String!, $state: String!, $zipCode: String!) {
        newLocation(city: $city, state: $state, zipCode: $zipCode){
            id
        }
    }
    
    {
    	"city" : "Dallas",
    	"state": "TX",
    	"zipCode": "76017"
    }
--
    
    mutation updateLocation($id: ID!, $city: String!, $state: String!, $zipCode: String!) {
        updateLocation(id: $id, city: $city, state: $state, zipCode: $zipCode){
            id
        }
    }
    
    {
    	"city" : "Plano",
    	"state": "TX",
    	"zipCode": "76017",
    	"id" : 1
    }
    
--

    mutation deleteLocation($city: String!) {
        deleteLocation(city: $city)
    }
    
    {
        "city": "Plano"
    }
    
--

    mutation newOrder($pickUpDateTime: String!, $deliveryDateTime: String!, $pickUpStopId: ID!, $deliveryStopId: ID!, $hazmat: Boolean!) {
        newOrder(pickUpDateTime: $pickUpDateTime,  deliveryDateTime: $deliveryDateTime, pickUpStopId: $pickUpStopId, deliveryStopId: $deliveryStopId, hazmat: $hazmat){
            id
        }
    }
    
    {
    	"pickUpDateTime":"2020-02-27T09:15:01",
    	"deliveryDateTime": "2020-02-28T09:15:01",
    	"pickUpStopId": 2,
    	"deliveryStopId": 5,
    	"hazmat": true
    }
    
--

    mutation updateOrder($id: ID!, $pickUpDateTime: String, $deliveryDateTime: String, $pickUpStopId: ID, $deliveryStopId: ID, $hazmat: Boolean!, $loadId: ID) {
        updateOrder(id: $id, pickUpDateTime: $pickUpDateTime,  deliveryDateTime: $deliveryDateTime, pickUpStopId: $pickUpStopId, deliveryStopId: $deliveryStopId, hazmat: $hazmat, loadId: $loadId){
            id
        }
    }
    
    {
    	"id": 1,
    	"loadId": 3,
    	"hazmat": true
    }
    
    {
    	"query": "{ findAllOrders {  id loadId pickUpStop{city state zipCode} deliveryStop {city state zipCode} hazmat }}"
    }
--
