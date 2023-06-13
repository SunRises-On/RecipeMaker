
import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
//import {faTwitter} from '@fortawesome/fontawesome-svg-core'
//import {faTwitter} from '@fortawesome/free-regular-svg-icons'
//import {faTwitter} from '@fortawesome/free-solid-svg-icons'
//import {faTwitter} from '@fortawesome/free-regular-svg-icons'
import {faTwitter} from '@fortawesome/free-brands-svg-icons'
import { faInstagram } from '@fortawesome/free-brands-svg-icons';
import { faFacebook } from '@fortawesome/free-brands-svg-icons';

export default function Footer(){
    return(
        <div className="container">
            <footer className='d-flex flex-wrap justify-content-between align-tems-center py-3 my-4 border-top'>

                <div className='col-md-4 d-flex align-items-center'
            
                >
                    <a className='mb-3 me-2 mb-md-0 text-muted text-decoration-non 1h-1'
                        href="/"
                    >
                    </a>
                    <span
                        className="mb-3 mb-md-0 text-muted"
                    >
                        &copy; {new Date().getFullYear()} Copyright: CreateRecipeTin.com
                    </span>
                </div>
                <ul className='nav col-md-4 justify-content-end list-unstyled d-flex'
                >
                    <li className="ms-3">
                        <a className="text-muted" href="#">
                            <svg className="bi" width="24" height="24">
                                <FontAwesomeIcon icon={faTwitter}
                                    size="lg"
                                />
                            </svg>
                        </a> 
                    </li>
                    <li className="ms-3">
                        <a className="text-muted" href="#">
                            <svg className="bi" width="24" height="24">
                                <FontAwesomeIcon icon={faInstagram}
                                    size="lg"
                                />
                            </svg>
                        
                        </a> 
                    </li>
                    <li className="ms-3">
                        <a className="text-muted" href="#">
                            <svg className="bi" width="24" height="24">
                                <FontAwesomeIcon icon={faFacebook}
                                    size="lg"
                                />
                            </svg>
                
                        </a> 
                    </li>
                </ul>
            </footer>
        </div>

    );


}