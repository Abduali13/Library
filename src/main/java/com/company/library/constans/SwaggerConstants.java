package com.company.library.constans;

public class SwaggerConstants {
    public static final String AUTHOR_SUCCESS = """
             {            
             "success":"true",
             "code":"0",
             "message":"OK",
             "data": {
             "authorFirstName":"Value",   
             "authorLastName":"Value",
             "authorAge":"Value"
             }
                        
            """;
    public static final String AUTHOR_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Author is not found!"
            }
            """;
    public static final String BOOK_SUCCESS = """
             {            
             "success":"true",
             "code":"0",
             "message":"OK",
             "data": {
             "bookName":"Value",   
             "price":"Value",
             "page":"Value",
             "amount":"Value"
             }
                        
            """;
    public static final String BOOK_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Book is not found!"
            }
            """;
    public static final String CARD_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "cardName":"Value...",
                    "cardFullName":"Value...",
                    "cardCode":"Value..."
                 }
            }
            """;

    public static final String CARD_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Card is not found!"
            }
            """;
    public static final String GOAL_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "language":"Value...",
                    "name":"Value...",
                                 }
            }
            """;

    public static final String GOAL_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Goal is not found!"
            }
            """;
    public static final String GENDER_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                                     "name":"Value...",
                                 }
            }
            """;

    public static final String GENDER_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Gender is not found!"
            }
            """;

    public static final String ORDERS_BOOK_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "cardId":"Value...",
                    "authorId":"Value..."
                              
                                 }
            }
            """;

    public static final String ORDERS_BOOK_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"OrdersBook is not found!"
            }
            """;
 public static final String IMAGE_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "path":"Value...",
                    "type":"Value...",
                    "size":"Value...",
                  "token":"Value..."
                              
                                 }
            }
            """;

    public static final String IMAGE_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"OrdersBook is not found!"
            }
            """;

    public static final String ORDERS_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {         
                      "total":"Value...",
                                        
                       }
            }
            """;

    public static final String ORDERS_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Orders is not found!"
            }
            """;

    public static final String PUBLISHER_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                        "publisher":"Value...",
                        "location":"Value..."
                                 }
            }
            """;

    public static final String PUBLISHER_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Publisher is not found!"
            }
            """;
    public static final String USER_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                 "firstName":"Value...",
                 "lastName":"Value...",
                 "email":"Value...",
                 "genderId":"Value...",
                 "phone":"Value...",
                 "password":"Value" ,             
                  "cardId":"Value",
                  "birthDate":"Value..."
                                 }
            }
            """;

    public static final String USER_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"User is not found!"
            }
            """;
}
