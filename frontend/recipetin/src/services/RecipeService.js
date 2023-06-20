import React from 'react';
import axios from 'axios';
import { useState } from 'react';
 const baseURL="http://localhost:8080/api/v1/recipe"

//  recipe = {
//     "name":"Orange Chicken",
//         "directions":{
//              "direction_1": "dklfjdlkafj",
//              "direction_2": "dfdfadfdf"},
//     "ingredients":{
//             //for id = 0 we change to ingredient_1 etc....
//             "ingredient_1": "Orange",
//             "ingredient_2": "4 Chicken Breast"},
// }



// {
//  "name": [{
//      "id": 0,
//      "name": " Orange Chicken",
//      "made": true,
//      "edit": false
//  }],
//  "ingredients": [{
//      "id": 0,
//      "name": "Orange",
//      "edit": false
//  }, {
//      "id": 1,
//      "name": "4 Chicken Breast",
//      "edit": true
//  }],
//  "directions": [{
//      "id": 0,
//      "name": "First cut the chicken breast into bite sized pieces.",
//      "edit": false
//  }, {
//      "id": 1,
//      "name": "Then coat in a mixture of cornstarch and flour.",
//      "edit": false
//  }]
// }


 export const AddRecipeAxios = (value) =>{
    
    
    const valueJSON = JSON.stringify(value)
    console.log(valueJSON)

    //configuring CORS for
    //content-type: application/json
    const headers = {
        'content-type': 'application/json'
    };

    //axios.post(url[, data[, config]])
    axios.post(
        //url
        baseURL+'/upload',
        //data 
        valueJSON
        ,
        {headers}
        )
        .then(function (response){
            console.log(response);
        }).catch(function (error){
            console.log(error);
        });
 }