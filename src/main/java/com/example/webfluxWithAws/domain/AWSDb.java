package com.example.webfluxWithAws.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "jeff_own_use")
public class AWSDb {

    @DynamoDBHashKey(attributeName = "side_project_db")
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute
    private String jsonData;
}
