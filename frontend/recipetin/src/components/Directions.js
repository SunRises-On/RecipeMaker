import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';

const deepCopyFunction = (inObject) => {
    let outObject, value, key
    if (typeof inObject !== "object" || inObject === null) {
        return inObject // Return the value if inObject is not an object
      }
    
      // Create an array or object to hold the values
      outObject = Array.isArray(inObject) ? [] : {}
    
      for (key in inObject) {
        value = inObject[key]
    
        // Recursively (deep) copy for nested objects, including arrays
        outObject[key] = deepCopyFunction(value)
      }
    
      return outObject

}


const Directions = ({value, setValue})=>{

    function updateEdit(index){
        console.log("in updateEdit()")
        console.log(value)
        
        const newList = deepCopyFunction(value)
        const newDirectionArray = [...newList.directions]; // direction array 

        const newDirection = newDirectionArray.find( // find needed index 
            d => d.id === index // deep copy newDirection with old Direction 
        );
        newDirection.edit = !newDirection.edit; // edit is opposite
        
        //Note that the ... spread syntax is “shallow”—
        //it only copies things one level deep.
        // This makes it fast, but it also means that 
        //if you want to update a nested property, you’ll have to use it more than once.
        
        setValue({...newList}) //Now point value to our new created object
        
    }

    function handleDirectionChange(event, index){

        const newList = deepCopyFunction(value);
        const newDirectionArray = [...newList.directions];

        const newDirection = newDirectionArray.find(
            d => d.id === index
        )
        newDirection.name = event.target.value;

        setValue({...newList})

    }

    return(
        <ol type="1">
            {value.directions?.map(item =>
                <li key={item.id}>
                    {item.edit?(
                        <div>
                            <input type="text"
                                value={item.name}
                                // style={{border:'none'}}
                                onChange={
                                    (e)=>
                                    handleDirectionChange(e, item.id)
                                }
                            />
                            <Button
                                onClick={
                                    ()=>{
                                        updateEdit(item.id)
                                    }
                                }
                            >Save</Button>
                        </div>
                        
                    ):(
                        <div>
                            <div>{item.name}</div>
                            <Button
                                onClick={
                                    ()=>{
                                        updateEdit(item.id);
                                    }
                                }
                                    
                            >Edit</Button>
                        </div>
                        
                    )}
                    
                </li>
            )}
        </ol>
    );
};
export default Directions;