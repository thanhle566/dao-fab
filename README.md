# DAOFAB Coding Assignment

###Server
Steps:
1. git clone https://github.com/thanhle566/dao-fab.git
2. Go to dao-fab/server
3. Build the project : mvn clean install
4. Run the project : java -jar ./target/coding-assignment-daofab-0.0.1-SNAPSHOT.jar
5. Verify assignment tasks.

1. API get parent transactions GET : localhost:8888/dao-fab/api/v1/transaction/parent?page=0&size=2

Sample response :
[
    {
        "id": 1,
        "sender": "ABC",
        "receiver": "XYZ",
        "totalAmount": 200,
        "totalPaidAmount": 100
    },
    {
        "id": 2,
        "sender": "XYZ",
        "receiver": "MNP",
        "totalAmount": 100,
        "totalPaidAmount": 100
    }
]



2. API get child transactions : GET : http://localhost:8080/daofab-api/v1/child-transactions/{parentId}

Sample response for parentId=1 :
[
    {
        "id": 1,
        "sender": "ABC",
        "receiver": "XYZ",
        "totalAmount": 200,
        "paidAmount": 10
    },
    {
        "id": 2,
        "sender": "ABC",
        "receiver": "XYZ",
        "totalAmount": 200,
        "paidAmount": 50
    },
    {
        "id": 3,
        "sender": "ABC",
        "receiver": "XYZ",
        "totalAmount": 200,
        "paidAmount": 40
    }
]

### Client
Steps:
1. Go to dao-fab/client
2. npm install && npm start
3. Verify assignment tasks.

