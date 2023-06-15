import React, { useState } from 'react';




const Ingredients = ({value})=>{

    return(
        <ul>
            {value.ingredients?.map(item =>
                <li key={item.id}>
                    <p>
                        {item.name}
                    </p>
                </li>
            )}
        </ul>
    );
};
export default Ingredients;