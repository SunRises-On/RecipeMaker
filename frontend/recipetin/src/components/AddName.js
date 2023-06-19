import React, { useState } from 'react';




const AddName = ({value})=>{

    return(
        <>
            {value.name.map(item=>
                    <span key={item.id}>
                        {item.name}
                    </span>
                )}
        </>
        
    );
};
export default AddName;
